#!/usr/bin/env bash
#
# run-local.sh — build (optional) and run thc-web locally against a locally-running thc-api.
#
# Usage:
#   ./run-local.sh            # run the existing target/thc-web.war
#   ./run-local.sh --build    # rebuild first (skips tests), then run
#   ./run-local.sh --test     # rebuild running the full test suite, then run
#
# Requirements:
#   - JDK 8 installed (Amazon Corretto 8) — the system default Java is NOT touched.
#   - thc-api running locally on http://localhost:8080 (start it from ../thc-api:
#     `cd ../thc-api && ./run-local.sh --build`). thc-web is only a frontend; login and
#     every page delegate to that backend, so it must be up.
#
# Ports:
#   - thc-api uses 8080, so thc-web runs on 8081 here to avoid a collision.
#   - Open http://localhost:8081 in a browser once started.
#
# Notes:
#   - Deployed to Tomcat the backend lives under the /thc-api context; running thc-api
#     locally via `java -jar` serves it at the root, so BACKEND_BASE_URL below has no
#     /thc-api suffix. Override BACKEND_BASE_URL / SERVER_PORT if your setup differs.
#   - Trello integration (product-repair board) uses placeholder keys in
#     application.properties and will not work locally unless you supply real ones.

set -euo pipefail
cd "$(dirname "$0")"

# --- JDK 8 (per-process only; system default stays untouched) ---
JAVA_HOME="$(/usr/libexec/java_home -v 1.8 2>/dev/null)" || {
    echo "ERROR: no JDK 8 found. Install Amazon Corretto 8." >&2; exit 1; }
export JAVA_HOME
echo "Using JDK 8 at: $JAVA_HOME"

# --- Config (override by exporting these before running) ---
export SERVER_PORT="${SERVER_PORT:-8081}"
export BACKEND_BASE_URL="${BACKEND_BASE_URL:-http://localhost:8080}"

# --- Backend reachability check (thc-web is useless without thc-api) ---
BACKEND_HOSTPORT="${BACKEND_BASE_URL#*://}"     # strip scheme
BACKEND_HOST="${BACKEND_HOSTPORT%%[:/]*}"       # host before : or /
BACKEND_PORT="${BACKEND_HOSTPORT#*:}"; BACKEND_PORT="${BACKEND_PORT%%/*}"  # port between : and /
[ "$BACKEND_PORT" = "$BACKEND_HOSTPORT" ] && BACKEND_PORT=80   # no explicit port
if ! nc -z "$BACKEND_HOST" "$BACKEND_PORT" 2>/dev/null; then
    echo "ERROR: thc-api not reachable at $BACKEND_BASE_URL ($BACKEND_HOST:$BACKEND_PORT)." >&2
    echo "       Start it first:  cd ../thc-api && ./run-local.sh --build" >&2
    exit 1
fi
echo "Backend reachable at $BACKEND_BASE_URL"

# --- Optional build ---
case "${1:-}" in
    --build)
        echo "Building WAR (tests skipped)..."
        ./mvnw clean package -Dmaven.test.skip=true
        ;;
    --test)
        echo "Building WAR with full test suite..."
        ./mvnw clean package
        ;;
    "")
        ;;
    *)
        echo "Unknown option: $1 (use --build, --test, or nothing)" >&2; exit 1
        ;;
esac

WAR=target/thc-web.war
[ -f "$WAR" ] || { echo "ERROR: $WAR not found. Run: ./run-local.sh --build" >&2; exit 1; }

# --- Run the exact artifact that gets deployed ---
echo "Starting $WAR on http://localhost:$SERVER_PORT (Ctrl+C to stop)..."
exec "$JAVA_HOME/bin/java" \
    -Dserver.port="$SERVER_PORT" \
    -Dbackend.base.url="$BACKEND_BASE_URL" \
    -jar "$WAR"

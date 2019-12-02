package com.treshermanas.thcweb.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ThcDigestUtils {

    public static String getSha256(String input) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encoded = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return new String(encoded);
    }
}

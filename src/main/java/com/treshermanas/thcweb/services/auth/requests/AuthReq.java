package com.treshermanas.thcweb.services.auth.requests;

public class AuthReq {

    private String userName;
    private String passwordDigest;

    public AuthReq() {
    }

    public AuthReq(String userName, String passwordDigest) {
        this.userName = userName;
        this.passwordDigest = passwordDigest;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }
}

package com.example.back.auth;

public class AuthenticationResponseObject {
    private String token;

    public AuthenticationResponseObject(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.mirego.cschat.models.request;

/**
 * Created by mahad on 25/03/17.
 */

public class RegisterRequest {
    private String username;
    private String password;
    private String photoURL;


    public RegisterRequest(String username, String password, String photoURL) {
        this.username = username;
        this.password = password;
        this.photoURL = photoURL;
    }

    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}

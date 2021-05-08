package com.mad2021june.dianacosmetics.Model;

public class EnqUser {
    private String id;
    private String email;
    private String message;

    public EnqUser() {
    }

    public EnqUser(String id, String email, String message) {
        this.id = id;
        this.email = email;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

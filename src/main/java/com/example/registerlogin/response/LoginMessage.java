package com.example.registerlogin.response;

public class LoginMessage {
    String message;
    String status;

    public LoginMessage(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public LoginMessage(String emailNotExits, boolean b) {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

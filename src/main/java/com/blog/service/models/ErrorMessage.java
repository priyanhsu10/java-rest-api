package com.blog.service.models;

import java.util.ArrayList;

public class ErrorMessage {
    private ArrayList<String> messages;
    private String ResponseCode;
    public ErrorMessage(){
        this.messages = new ArrayList<>();
    }
    public ErrorMessage(String responseCode, String message) {
        ResponseCode = responseCode;
        this.messages = new ArrayList<>();
        this.messages.add(message);
    }

    public void addErrorMessage(String message) {
        this.messages.add(message);
    }

    public ArrayList<String> getMessages() {
        return messages;
    }
}

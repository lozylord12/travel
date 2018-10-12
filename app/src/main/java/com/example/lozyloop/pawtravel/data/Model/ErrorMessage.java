package com.example.lozyloop.pawtravel.data.Model;

import java.util.List;



public class ErrorMessage {

    private List<String> mMessageList;

    public List<String> getMessages() {
        return mMessageList;
    }

    public String getMessageList() {
        String listMessage = "";
        for (String message : mMessageList) {
            listMessage += "\n" + "-" + message;
        }
        return listMessage;
    }
}

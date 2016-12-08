package com.example.decode.dcgram_android.domain.models;

/**
 * Created by root on 07.12.16..
 */

public class MessageModel {

    private String messageText;

    public MessageModel(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}

package com.templateproject.api.config;

public class Message {
    private String messageContent;

    public Message() {
    }

    public Message(String content) {
      this.messageContent = content;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String content) {
        this.messageContent = content;
    }
}

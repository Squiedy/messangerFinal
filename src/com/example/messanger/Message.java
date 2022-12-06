package com.example.messanger;

public class Message {
    private String recipient;
    private String text;
    private int id;

    public Message(String recipient, String text, int id) {
        this.recipient = recipient;
        this.text = text;
        this.id = id;
    }

    public void getDetails() {
        System.out.println("Name : " + recipient +
                "\nMessage : " + text +
                "\nId : " + id);
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.mailnova.enums;

public enum SendChoice {

    SEND_NO("Send Now"),
   SCHEDULE_FOR_LATER ("Schedule for Later");

    private final String label;


    SendChoice(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

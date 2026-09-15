package com.mailnova.exceptionmessage;

import java.util.Map;

public class ApiResponse {

    private String message;
    private Map<String, Object> others;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getOthers() {
        return others;
    }

    public void setOthers(Map<String, Object> others) {
        this.others = others;
    }
}

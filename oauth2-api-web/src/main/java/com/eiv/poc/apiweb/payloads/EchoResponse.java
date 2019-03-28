package com.eiv.poc.apiweb.payloads;

public class EchoResponse {

    private String message;
    
    public EchoResponse() {
    }

    public EchoResponse(String message) {
        super();
        this.message = message == null ? null : message.trim().toUpperCase();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.example.app.model;

public class Resp {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

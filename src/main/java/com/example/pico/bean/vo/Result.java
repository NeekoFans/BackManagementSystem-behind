package com.example.pico.bean.vo;

public class Result<T> {
    private Integer code;
    private Boolean succes;
    private T data;
    private String message;

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setSucces(true);
        result.setData(data);
        return result;
    }
    public static Result success(String message){
        Result result = new Result();
        result.setCode(0);
        result.setSucces(true);
        result.setMessage(message);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSucces() {
        return succes;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

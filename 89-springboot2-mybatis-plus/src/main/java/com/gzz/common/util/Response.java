package com.gzz.common.util;

import lombok.Data;

@Data
public class Response {

    private String errorCode;
    private String errorMessage;
    private String extMessage;
    private Object result;
    private Status status;

    public Response() {
        this.status = Status.SUCCEED;
    }


    public static Response success() {
        return new Response();
    }

    public static Response success(Object result) {
        Response response = new Response();
        response.setResult(result);
        return response;
    }

    public static Response failure(String errorCode, String errorMessage) {
        Response response = new Response();
        response.errorCode = errorCode;
        response.errorMessage = errorMessage;
        response.status = Status.FAILED;
        return response;
    }
 

    public static Response failure(String message) {
        Response response = new Response();
        response.setErrorMessage(message);
        response.status = Status.FAILED;
        return response;
    }

    public static Response warring(Object result) {
        Response response = new Response();
        response.setResult(result);
        response.status = Status.WARRING;
        return response;
    }

    public enum Status {
        /**
         * 状态
         */
        SUCCEED,
        WARRING,
        FAILED;

        Status() {
        }
    }
}
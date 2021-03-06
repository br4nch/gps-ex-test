package com.gpx.exchange.constant.status;

import org.springframework.http.HttpStatus;

public class StatusFactory {

    public static <T> AppStatus getAppStatus(HttpStatus status, String message, T data) {
        return new AppStatus(status, message, data);
    }

    public static <T> AppStatus ofOk(T data) {
        return new AppStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> AppStatus ofNotFound() {
        return new AppStatus(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.getReasonPhrase(), null);
    }

    public static <T> AppStatus ofBadRequest(String badRequestInstruction) {
        return new AppStatus(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(), badRequestInstruction);
    }

    public static <T> AppStatus ofInternalError(T data) {
        return new AppStatus(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), data);
    }
}

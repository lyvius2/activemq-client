package com.walter.active.consumer.controller.vo;

import lombok.Getter;

@Getter
public class ResultV1 {
    private boolean listening;
    private String message;

    public ResultV1(boolean listening, String message) {
        this.listening = listening;
        this.message = message;
    }

    public static ResultV1 of(boolean listening, String message) {
        return new ResultV1(listening, message);
    }

    public static ResultV1 of(boolean listening) {
        return of(listening, "SUCCESS");
    }
}

package com.nizdeniz.HospitalApp.Core.Results;

public class Result implements IResult {
    private String message;
    private final boolean success;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}

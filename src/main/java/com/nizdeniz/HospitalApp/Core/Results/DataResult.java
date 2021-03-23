package com.nizdeniz.HospitalApp.Core.Results;

public class DataResult<T> extends Result implements IDataResult<T>{

    private final T data;

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public DataResult(T data ,boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }
}

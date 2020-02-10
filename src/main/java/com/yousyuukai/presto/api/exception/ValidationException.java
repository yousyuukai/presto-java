package com.yousyuukai.presto.api.exception;

import java.util.List;

public class ValidationException extends BaseException {

    private List<String> errors;

    public ValidationException(List<String> errors) {
        super(errors.toString());
        this.errors = errors;
    }

    @Override
    public String toString() {
        StringBuffer message = new StringBuffer();
        errors.stream().forEach(msg -> message.append(msg + " "));
        return message.toString();
    }
}

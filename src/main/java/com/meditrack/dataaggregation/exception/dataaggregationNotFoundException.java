package com.meditrack.dataaggregation.exception;

import com.meditrack.dataaggregation.constant.ErrorCode;
import lombok.Getter;

@Getter
public class dataaggregationNotFoundException extends Exception {
    private final ErrorCode errorCode;

    public dataaggregationNotFoundException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}

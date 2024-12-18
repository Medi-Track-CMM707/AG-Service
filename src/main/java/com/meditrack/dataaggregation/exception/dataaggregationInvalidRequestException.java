package com.meditrack.dataaggregation.exception;

import com.meditrack.dataaggregation.constant.ErrorCode;
import lombok.Getter;

@Getter
public class dataaggregationInvalidRequestException extends Exception {
    private final ErrorCode errorCode;

    public dataaggregationInvalidRequestException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}

package com.kevcode.cdtsaccountservice.domain.exceptions;

public class NotSuficientFundsException extends Exception {
    public NotSuficientFundsException() {
        super();
    }

    public NotSuficientFundsException(String message) {
        super(message);
    }


    public NotSuficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }


    public NotSuficientFundsException(Throwable cause) {
        super(cause);
    }


    protected NotSuficientFundsException(String message, Throwable cause,
                                         boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

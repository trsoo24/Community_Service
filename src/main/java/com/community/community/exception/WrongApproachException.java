package com.community.community.exception;

import lombok.Getter;

@Getter
public class WrongApproachException extends RuntimeException{
    private final ErrorMessage errorMessage;

    public WrongApproachException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}


package com.file.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttachmentException extends RuntimeException {
    private final String message;

    public AttachmentException(String message) {
        this.message = message;
    }
}

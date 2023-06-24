package com.airsys.airticket.exception;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data

public class InvalidDataException extends RuntimeException {
    public InvalidDataException() {
    }

    public InvalidDataException(String message) {
        super(message);
    }
}

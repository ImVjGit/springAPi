package com.airsys.airticket.exception;

public class ResourceNotFoundException  extends RuntimeException{
//    String user;
//    String userId;
//    Long customerId;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String user, String userId, Long customerId) {

    }
}

package com.revature.project2.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("User authentication failed!");
    }

    public AuthenticationException(String message) {
        super(message);
    }

}

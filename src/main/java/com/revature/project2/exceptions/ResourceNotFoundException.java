package com.revature.project2.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resources found using the specified criteria.");
    }

}

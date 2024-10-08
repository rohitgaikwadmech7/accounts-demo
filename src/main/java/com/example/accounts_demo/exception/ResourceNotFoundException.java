package com.example.accounts_demo.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue ){
        super(String.format("%s not found with the given i/p %s : %s",resourceName,fieldName,fieldValue));
    }
}

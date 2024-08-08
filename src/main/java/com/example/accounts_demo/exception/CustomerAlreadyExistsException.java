package com.example.accounts_demo.exception;

public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String msg){
        super(msg);
    }
}

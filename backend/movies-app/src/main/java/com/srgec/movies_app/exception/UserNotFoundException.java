package com.srgec.movies_app.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(){
        super("user not found");
    }
}

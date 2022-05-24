package com.sachin.exceptions;

public class MultiBotsException extends Exception {
    public MultiBotsException(){
        super("No more than bots are allowed.");
    }
}

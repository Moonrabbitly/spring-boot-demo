package com.chloeliu.demo.rest;

public class StudentNotFoundException extends RuntimeException {
    //generate constructors from the super class

    //this constructor takes a single argument, which is a message explaining the exception.
    //it calls the superclass constructor with the provided message.
    public StudentNotFoundException(String message) {
        super(message);
    }
    //this constructor takes two arguments: a message and a Throwable cause (a previous exception that caused this exception).
    //it calls the superclass constructor with both the message and the cause.
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}

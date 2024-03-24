package com.example.JPACustomers.exceptional;

import javax.swing.text.html.parser.Entity;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String message){
        super(message);
    }
}

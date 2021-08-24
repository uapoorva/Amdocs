package com.src.Exception;

import java.util.concurrent.BlockingQueue;

public class IncorrectCustomerFormatException extends Exception { 
    public IncorrectCustomerFormatException(String message) throws InterruptedException {
        super(message);
    }
}
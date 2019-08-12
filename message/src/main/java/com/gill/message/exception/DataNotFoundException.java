package com.gill.message.exception;

import com.gill.message.model.Message;

public class DataNotFoundException extends RuntimeException {
     private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}

package com.example.cinemaroomrestservice;

import org.springframework.http.HttpStatus;

public class PurchaseError {
    private HttpStatus status;
    private String message;

    PurchaseError(String message) {
        this.status = HttpStatus.BAD_REQUEST;
        this.message = message;
    }
}


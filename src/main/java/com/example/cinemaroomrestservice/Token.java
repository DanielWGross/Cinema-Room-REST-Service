package com.example.cinemaroomrestservice;

import java.util.UUID;

public class Token {
    private final UUID token;

    public Token() {
        this.token = UUID.randomUUID();
    }

    public UUID getToken() {
        return token;
    }
}
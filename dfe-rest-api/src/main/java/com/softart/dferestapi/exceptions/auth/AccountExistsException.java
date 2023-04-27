package com.softart.dferestapi.exceptions.auth;

import com.softart.dferestapi.exceptions.DfeRestApiException;

public class AccountExistsException extends DfeRestApiException {

    public AccountExistsException() {
        super("an account with this info already exists");
    }
}

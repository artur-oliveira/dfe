package com.softart.dferestapi.exceptions.auth;

import com.softart.dferestapi.exceptions.DfeRestException;

public class AccountExistsException extends DfeRestException {

    public AccountExistsException() {
        super("an account with this info already exists");
    }
}

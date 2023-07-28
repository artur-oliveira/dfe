package com.softart.dfe.exceptions.sefaz;

import com.softart.dfe.exceptions.DfeUncheckedException;

public class InvalidSefazResponseException extends DfeUncheckedException {
    public InvalidSefazResponseException() {
        super("invalid sefaz response");
    }
}

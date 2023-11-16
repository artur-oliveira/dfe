package org.dfe.exceptions.sefaz;

import org.dfe.exceptions.DfeUncheckedException;

public class InvalidSefazResponseException extends DfeUncheckedException {
    public InvalidSefazResponseException() {
        super("invalid sefaz response");
    }
}

package com.softart.dferestapi.exceptions.certificate;

public final class CertificateIncorrectPasswordException extends CertificateFileException {

    public CertificateIncorrectPasswordException(String password) {
        super(password + " is incorrect");
    }

}

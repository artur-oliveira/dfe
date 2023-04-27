package com.softart.dferestapi.exceptions.certificate;

public final class CertificateNullFileException extends CertificateFileException {

    public CertificateNullFileException() {
        super("certificate file is null");
    }

}

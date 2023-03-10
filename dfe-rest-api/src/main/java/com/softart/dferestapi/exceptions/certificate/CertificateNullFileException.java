package com.softart.dferestapi.exceptions.certificate;

import com.softart.dferestapi.exceptions.DfeRestException;

public final class CertificateNullFileException extends CertificateFileException {

    public CertificateNullFileException() {
        super("certificate file is null");
    }

}

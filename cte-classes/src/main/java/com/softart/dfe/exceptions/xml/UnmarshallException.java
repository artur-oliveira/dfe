package com.softart.dfe.exceptions.xml;

import com.softart.dfe.exceptions.DfeUncheckedException;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * > This exception is thrown when a problem occurs during marshalling
 */
@Log4j2
@Getter
public class UnmarshallException extends DfeUncheckedException {

    private String xml;

    public UnmarshallException(Exception exception) {
        super(exception);
    }

    public UnmarshallException(Exception exception, String xml) {
        super(exception);
        this.xml = xml;
        log.error(xml);
    }
}

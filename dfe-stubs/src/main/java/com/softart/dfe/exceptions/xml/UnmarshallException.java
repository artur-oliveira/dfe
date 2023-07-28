package com.softart.dfe.exceptions.xml;

import com.softart.dfe.exceptions.DfeUncheckedException;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

/**
 * This exception is thrown when a problem occurs during marshalling
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

    public UnmarshallException(String message) {
        super(message);
    }

    public UnmarshallException(String message, String xml) {
        super(message);
        if (Objects.nonNull(xml)) {
            this.xml = xml;
            log.error(xml);
        }
    }
}

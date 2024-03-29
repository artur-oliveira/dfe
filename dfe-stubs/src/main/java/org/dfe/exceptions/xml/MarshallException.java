package org.dfe.exceptions.xml;

import org.dfe.exceptions.DfeUncheckedException;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * This exception is thrown when a problem occurs during marshalling
 */
@Log4j2
@Getter
public class MarshallException extends DfeUncheckedException {

    private String xml;

    public MarshallException(Exception exception) {
        super(exception);
    }

    public MarshallException(Exception exception, String xml) {
        super(exception);
        this.xml = xml;
        log.error(xml);
    }
}

package com.softart.dfe.exceptions.xml;

import com.softart.dfe.exceptions.ValidationException;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.xml.sax.SAXParseException;

/**
 * A custom exception class that extends the ValidationException class.
 */
@Getter
@Log4j2
public class XSDValidationException extends ValidationException {

    private String xml;

    public XSDValidationException(Exception e) {
        this(e, null);
    }

    public XSDValidationException(Exception e, String xml) {
        super(e);
        this.xml = xml;
    }

    public XSDValidationException(SAXParseException ex) {
        super(ex.getMessage());
    }
}

package org.dfe.exceptions.xml;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.dfe.exceptions.ValidationException;

/**
 * The class XSDValidationException extends the ValidationException class in Java.
 */
@Getter
@Log4j2
public class XSDValidationException extends ValidationException {

    private final String xml;
    private final String tag;
    private final String value;

    public XSDValidationException(Exception e) {
        this(e, null, null, null);
    }

    public XSDValidationException(Exception e, String xml) {
        this(e, xml, null, null);
    }


    public XSDValidationException(Exception e, String xml, String tag, String value) {
        super(e);
        this.xml = xml;
        this.tag = tag;
        this.value = value;
    }
}

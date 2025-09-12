package org.dfe.components.internal.xml.validation;

import org.dfe.exceptions.xml.XSDValidationException;
import org.dfe.models.internal.xml.XMLValidation;
import org.xml.sax.SAXParseException;

public interface SaxParserExceptionHandler {

    XSDValidationException handleSaxParseException(SAXParseException e, XMLValidation validation);

    default boolean accept(SAXParseException e) {
        return e.getMessage().contains(getHandledTypeError());
    }

    String getHandledTypeError();
}

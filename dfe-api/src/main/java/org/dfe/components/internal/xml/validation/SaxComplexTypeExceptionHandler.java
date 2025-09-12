package org.dfe.components.internal.xml.validation;

import org.dfe.exceptions.xml.XSDValidationException;
import org.dfe.models.internal.xml.XMLValidation;
import org.xml.sax.SAXParseException;

final class SaxComplexTypeExceptionHandler implements SaxParserExceptionHandler {

    public XSDValidationException handleSaxParseException(SAXParseException e, XMLValidation validation) {
        return new XSDValidationException(e, validation.xml());
    }

    @Override
    public String getHandledTypeError() {
        return "cvc-complex";
    }
}

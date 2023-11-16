package org.dfe.interfaces.xml;

import org.dfe.exceptions.ValidationException;
import org.dfe.models.internal.xml.XMLValidation;

public interface XMLValidator {

    /**
     * Validates the XML document against the XML schema
     *
     * @param validation The XMLValidation object that contains the XML to be validated.
     */
    void validateXML(XMLValidation validation) throws ValidationException;

}

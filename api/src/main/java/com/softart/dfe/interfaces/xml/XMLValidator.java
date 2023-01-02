package com.softart.dfe.interfaces.xml;

import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.models.internal.xml.XMLValidation;

public interface XMLValidator {

    /**
     * Validates the XML document against the XML schema
     *
     * @param validation The XMLValidation object that contains the XML to be validated.
     */
    void validateXML(XMLValidation validation) throws ValidationException;

}

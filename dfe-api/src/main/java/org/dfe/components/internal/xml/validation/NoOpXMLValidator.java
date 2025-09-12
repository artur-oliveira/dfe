package org.dfe.components.internal.xml.validation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.xml.XMLValidator;
import org.dfe.models.internal.xml.XMLValidation;


public final class NoOpXMLValidator implements XMLValidator {
    @Override
    public void validateXML(XMLValidation validation) throws ValidationException {

    }
}

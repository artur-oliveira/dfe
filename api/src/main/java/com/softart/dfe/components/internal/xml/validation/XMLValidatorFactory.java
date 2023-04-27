package com.softart.dfe.components.internal.xml.validation;

import com.softart.dfe.interfaces.xml.XMLValidator;

/**
 * XMLValidatorFactory is an abstract class that implements XMLValidator and has a static method that returns an instance
 * of DefaultXMLValidator.
 *
 * @see DefaultXMLValidator
 */
public abstract class XMLValidatorFactory implements XMLValidator {

    protected XMLValidatorFactory() {
    }

    public static XMLValidatorFactory getInstance() {
        return XMLValidatorFactoryHolder.INSTANCE;
    }

    static final class XMLValidatorFactoryHolder {
        static final XMLValidatorFactory INSTANCE = new DefaultXMLValidator();
    }

}

package org.dfe.components.internal.xml.validation;

import org.dfe.interfaces.xml.XMLValidator;

/**
 * XMLValidatorFactory is an abstract class that implements XMLValidator and has a static method that returns an instance
 * of DefaultXMLValidator.
 *
 * @see DefaultXMLValidator
 */
public abstract class XMLValidatorFactory implements XMLValidator {

    protected XMLValidatorFactory() {
    }

    /**
     * The function returns an instance of the XMLValidatorFactory class.
     *
     * @return An instance of the XMLValidatorFactory class is being returned. This method uses the Singleton design
     * pattern to ensure that only one instance of the class is created and returned.
     */
    public static XMLValidatorFactory getInstance() {
        return XMLValidatorFactoryHolder.INSTANCE;
    }

    /**
     * The class defines a static final holder for an instance of the DefaultXMLValidator class.
     */
    static final class XMLValidatorFactoryHolder {
        static final XMLValidatorFactory INSTANCE = new DefaultXMLValidator();
    }

}

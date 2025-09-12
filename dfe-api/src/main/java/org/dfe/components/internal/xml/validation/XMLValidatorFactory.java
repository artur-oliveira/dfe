package org.dfe.components.internal.xml.validation;

import org.dfe.exceptions.DfeUncheckedException;
import org.dfe.interfaces.xml.XMLValidator;


public final class XMLValidatorFactory {

    private static volatile XMLValidator instance;

    private XMLValidatorFactory() {
    }

    public static void configure(XMLValidator customValidator) {
        if (customValidator == null) {
            throw new DfeUncheckedException("customValidator não pode ser null");
        }
        synchronized (XMLValidatorFactory.class) {
            instance = customValidator;
        }
    }

    public static XMLValidator getInstance() {
        if (instance == null) {
            synchronized (XMLValidatorFactory.class) {
                if (instance == null) {
                    instance = new DefaultXMLValidator();
                }
            }
        }
        return instance;
    }
}

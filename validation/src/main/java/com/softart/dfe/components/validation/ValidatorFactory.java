package com.softart.dfe.components.validation;


import com.softart.dfe.interfaces.validation.ValidationService;

public abstract class ValidatorFactory implements ValidationService {

    /**
     * > The ValidatorFactoryHolder class is a static inner class of the ValidatorFactory class. The ValidatorFactoryHolder
     * class has a static final field called INSTANCE of type ValidatorFactory. The ValidatorFactoryHolder class has a
     * private constructor. The ValidatorFactory class has a public static method called getInstance() that returns the
     * value of the INSTANCE field
     *
     * @return A singleton instance of the ValidatorFactory class.
     */
    public static ValidatorFactory getInstance() {
        return ValidatorFactoryHolder.INSTANCE;
    }

    private static final class ValidatorFactoryHolder {
        private final static ValidatorFactory INSTANCE = new DefaultValidatorFactory();
    }
}

package com.softart.dfe.components.validation;


import com.softart.dfe.interfaces.validation.cte.CteValidator;
import com.softart.dfe.interfaces.validation.mdfe.MdfeValidator;
import com.softart.dfe.interfaces.validation.nf.NfceValidator;
import com.softart.dfe.interfaces.validation.nf.NfeValidator;

public abstract class ValidatorFactory {

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

    /**
     * This function returns an instance of the NfeValidator class.
     *
     * @return An instance of the NfeValidator class.
     */
    public abstract NfeValidator nfeValidator();

    /**
     * It returns an instance of the NfceValidator class
     *
     * @return An instance of the NfceValidator class.
     */
    public abstract NfceValidator nfceValidator();

    /**
     * This function returns an instance of the CteValidator class.
     *
     * @return An instance of the CteValidator class.
     */
    public abstract CteValidator cteValidator();

    /**
     * It returns an object that can validate an MDF-e
     *
     * @return An instance of the MdfeValidator class.
     */
    public abstract MdfeValidator mdfeValidator();

    private static final class ValidatorFactoryHolder {
        private final static ValidatorFactory INSTANCE = new DefaultValidatorFactory();
    }
}

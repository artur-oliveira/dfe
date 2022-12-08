package com.softart.dfe.components.validation;


import com.softart.dfe.interfaces.validation.cte.CteValidator;
import com.softart.dfe.interfaces.validation.nf.NfceValidator;
import com.softart.dfe.interfaces.validation.nf.NfeValidator;

public abstract class ValidatorFactory {

    public static ValidatorFactory getInstance() {
        return new DefaultValidatorFactory();
    }

    public abstract NfeValidator nfeValidator();

    public abstract NfceValidator nfceValidator();

    public abstract CteValidator cteValidator();
}

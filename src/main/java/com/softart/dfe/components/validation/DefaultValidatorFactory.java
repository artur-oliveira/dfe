package com.softart.dfe.components.validation;

import com.softart.dfe.components.validation.cte.DefaultCteValidator;
import com.softart.dfe.components.validation.nf.DefaulNfceValidator;
import com.softart.dfe.components.validation.nf.DefaulNfeValidator;
import com.softart.dfe.interfaces.validation.cte.CteValidator;
import com.softart.dfe.interfaces.validation.nf.NfceValidator;
import com.softart.dfe.interfaces.validation.nf.NfeValidator;

final class DefaultValidatorFactory extends ValidatorFactory {
    @Override
    public NfeValidator nfeValidator() {
        return new DefaulNfeValidator();
    }

    @Override
    public NfceValidator nfceValidator() {
        return new DefaulNfceValidator();
    }

    @Override
    public CteValidator cteValidator() {
        return new DefaultCteValidator();
    }
}

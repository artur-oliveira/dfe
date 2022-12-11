package com.softart.dfe.components.validation;

import com.softart.dfe.components.validation.cte.DefaultCteValidator;
import com.softart.dfe.components.validation.mdfe.DefaultMdfeValidator;
import com.softart.dfe.components.validation.nf.DefaulNfceValidator;
import com.softart.dfe.components.validation.nf.DefaulNfeValidator;
import com.softart.dfe.interfaces.validation.cte.CteValidator;
import com.softart.dfe.interfaces.validation.mdfe.MdfeValidator;
import com.softart.dfe.interfaces.validation.nf.NfceValidator;
import com.softart.dfe.interfaces.validation.nf.NfeValidator;

final class DefaultValidatorFactory extends ValidatorFactory {

    @Override
    public NfeValidator nfeValidator() {
        return DefaultValidatorFactoryHolder.NFE_INSTANCE;
    }

    @Override
    public NfceValidator nfceValidator() {
        return DefaultValidatorFactoryHolder.NFCE_INSTANCE;
    }

    @Override
    public CteValidator cteValidator() {
        return DefaultValidatorFactoryHolder.CTE_INSTANCE;
    }

    @Override
    public MdfeValidator mdfeValidator() {
        return DefaultValidatorFactoryHolder.MDFE_INSTANCE;
    }

    private static final class DefaultValidatorFactoryHolder {
        private static final NfeValidator NFE_INSTANCE = new DefaulNfeValidator();
        private static final NfceValidator NFCE_INSTANCE = new DefaulNfceValidator();
        private static final CteValidator CTE_INSTANCE = new DefaultCteValidator();
        private static final MdfeValidator MDFE_INSTANCE = new DefaultMdfeValidator();
    }
}

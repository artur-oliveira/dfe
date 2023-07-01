package com.softart.dfe.components.validation;

import com.softart.dfe.components.validation.cte.DefaultCteValidator;
import com.softart.dfe.components.validation.cte4.DefaultCte4Validator;
import com.softart.dfe.components.validation.mdfe.DefaultMdfeValidator;
import com.softart.dfe.components.validation.nf.DefaulNfceValidator;
import com.softart.dfe.components.validation.nf.DefaulNfeValidator;
import com.softart.dfe.interfaces.validation.cte.CteValidator;
import com.softart.dfe.interfaces.validation.cte4.Cte4Validator;
import com.softart.dfe.interfaces.validation.mdfe.MdfeValidator;
import com.softart.dfe.interfaces.validation.nf.NfceValidator;
import com.softart.dfe.interfaces.validation.nf.NfeValidator;

final class DefaultValidatorFactory extends ValidatorFactory {

    /**
     * If the NfeValidator instance is null, create a new one and return it. Otherwise, return the existing instance.
     *
     * @return A validator instance.
     */
    public NfeValidator nfeValidator() {
        return DefaultValidatorFactoryHolder.NFE_INSTANCE;
    }

    /**
     * It returns a singleton instance of the NFCe validator
     *
     * @return A new instance of the NfceValidator class.
     */
    public NfceValidator nfceValidator() {
        return DefaultValidatorFactoryHolder.NFCE_INSTANCE;
    }

    /**
     * If the CTE validator has not been initialized, initialize it and return it. Otherwise, return the already
     * initialized CTE validator.
     *
     * @return A validator instance.
     */
    public CteValidator cteValidator() {
        return DefaultValidatorFactoryHolder.CTE_INSTANCE;
    }

    @Override
    public Cte4Validator cte4Validator() {
        return DefaultValidatorFactoryHolder.CTE4_INSTANCE;
    }

    /**
     * It returns a validator for MDF-e
     *
     * @return The instance of the class MdfeValidator.
     */
    public MdfeValidator mdfeValidator() {
        return DefaultValidatorFactoryHolder.MDFE_INSTANCE;
    }

    private static final class DefaultValidatorFactoryHolder {
        private static final NfeValidator NFE_INSTANCE = new DefaulNfeValidator();
        private static final NfceValidator NFCE_INSTANCE = new DefaulNfceValidator();
        private static final CteValidator CTE_INSTANCE = new DefaultCteValidator();
        private static final Cte4Validator CTE4_INSTANCE = new DefaultCte4Validator();
        private static final MdfeValidator MDFE_INSTANCE = new DefaultMdfeValidator();
    }
}

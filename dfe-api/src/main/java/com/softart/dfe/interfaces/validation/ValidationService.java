package com.softart.dfe.interfaces.validation;

import com.softart.dfe.interfaces.validation.cte.CteValidator;
import com.softart.dfe.interfaces.validation.cte4.Cte4Validator;
import com.softart.dfe.interfaces.validation.mdfe.MdfeValidator;
import com.softart.dfe.interfaces.validation.nf.NfceValidator;
import com.softart.dfe.interfaces.validation.nf.NfeValidator;

public interface ValidationService {

    /**
     * This function returns an instance of the NfeValidator class.
     *
     * @return An instance of the NfeValidator class.
     */
    NfeValidator nfeValidator();

    /**
     * It returns an instance of the NfceValidator class
     *
     * @return An instance of the NfceValidator class.
     */
    NfceValidator nfceValidator();

    /**
     * This function returns an instance of the CteValidator class.
     *
     * @return An instance of the CteValidator class.
     */
    CteValidator cteValidator();

    Cte4Validator cte4Validator();

    /**
     * It returns an object that can validate an MDF-e
     *
     * @return An instance of the MdfeValidator class.
     */
    MdfeValidator mdfeValidator();
}

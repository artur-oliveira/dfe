package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQueryUnclosedValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDQueryUnclosedValidator implements MdfeQueryUnclosedValidator {
    @Override
    public void valid(Validation<TConsMDFeNaoEnc> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/consMDFeNaoEnc_v3.00.xsd", o.xml()));
    }
}

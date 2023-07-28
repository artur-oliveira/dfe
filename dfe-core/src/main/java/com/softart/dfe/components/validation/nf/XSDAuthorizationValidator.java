package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.common.NfAuthorizationValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDAuthorizationValidator implements NfAuthorizationValidator {
    @Override
    public void valid(Validation<TEnviNFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_009k_NT2023_001_v110a/enviNFe_v4.00.xsd", o.xml()));
    }
}

package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.send.TConsCad;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.NfeQueryRegisterValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDQueryRegisterValidator implements NfeQueryRegisterValidator {
    @Override
    public void valid(Validation<TConsCad> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_009k_NT2023_001_v110a/consCad_v2.00.xsd", o.getXml()));
    }
}

package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.common.NfQueryGtinValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDGtinValidator implements NfQueryGtinValidator {
    @Override
    public void valid(Validation<TConsGTIN> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_ConsultaGTIN_v1.00/consGTIN_v1.00.xsd", o.xml()));
    }
}

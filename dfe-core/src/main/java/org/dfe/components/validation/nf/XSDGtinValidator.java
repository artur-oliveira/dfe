package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.common.NfQueryGtinValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDGtinValidator implements NfQueryGtinValidator {
    @Override
    public void valid(Validation<TConsGTIN> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_ConsultaGTIN_v1.00/consGTIN_v1.00.xsd", o.xml()));
    }
}

package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.send.TConsCad;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.NfeQueryRegisterValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDQueryRegisterValidator implements NfeQueryRegisterValidator {
    @Override
    public void valid(Validation<TConsCad> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_010b_NT2025_002_v1.21/consCad_v2.00.xsd", o.xml()));
    }
}

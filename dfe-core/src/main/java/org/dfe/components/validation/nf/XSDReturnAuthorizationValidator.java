package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.common.NfReturnAuthorizationValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDReturnAuthorizationValidator implements NfReturnAuthorizationValidator {
    @Override
    public void valid(Validation<TConsReciNFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_010b_NT2025_002_v1.21/consReciNFe_v4.00.xsd", o.xml()));
    }
}

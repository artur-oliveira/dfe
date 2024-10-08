package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.common.NfAuthorizationValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDAuthorizationValidator implements NfAuthorizationValidator {
    @Override
    public void valid(Validation<TEnviNFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_009o_NT2024_001_v100/enviNFe_v4.00.xsd", o.xml()));
    }
}

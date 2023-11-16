package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.common.NfQueryProtocolValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDQueryProtocolValidator implements NfQueryProtocolValidator {
    @Override
    public void valid(Validation<TConsSitNFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_009k_NT2023_001_v110a/consSitNFe_v4.00.xsd", o.xml()));
    }
}

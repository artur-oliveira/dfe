package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.NfeCorrectionLetterValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDCorrectionLetterValidator implements NfeCorrectionLetterValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_CCe_PL_v1.01/envCCe_v1.00.xsd", o.xml()));
    }
}

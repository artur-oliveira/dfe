package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.NfeCorrectionLetterValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDCorrectionLetterValidator implements NfeCorrectionLetterValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_CCe_PL_v1.01/envCCe_v1.00.xsd", o.getXml()));
    }
}

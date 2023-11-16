package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.common.NfCancelValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDCancelValidator implements NfCancelValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/envEventoCancNFe_v1.00.xsd", o.xml()));
    }
}

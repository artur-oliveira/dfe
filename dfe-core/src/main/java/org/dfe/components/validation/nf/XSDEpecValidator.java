package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.NfeEpecValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDEpecValidator implements NfeEpecValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_EPEC_PL_v1.01/envEPEC_v1.00.xsd", o.xml()));
    }
}

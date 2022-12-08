package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.NfeEpecValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDEpecValidator implements NfeEpecValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_EPEC_PL_v1.01/envEPEC_v1.00.xsd", o.getXml()));
    }
}

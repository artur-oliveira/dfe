package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.NfeInterestedActorValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDInterestedActorValidator implements NfeInterestedActorValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_AtorInteressado_PL_v1.02/envEventoAtorInteressado_v1.00.xsd", o.xml()));
    }
}

package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.NfeInterestedActorValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDInterestedActorValidator implements NfeInterestedActorValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_AtorInteressado_PL_v1.02/envEventoAtorInteressado_v1.00.xsd", o.xml()));
    }
}

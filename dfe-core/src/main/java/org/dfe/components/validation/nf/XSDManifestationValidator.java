package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.NfeManifestationValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDManifestationValidator implements NfeManifestationValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd", o.xml()));
    }
}

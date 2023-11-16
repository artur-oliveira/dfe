package org.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TCTeOS;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte.CteReceptionCteOsValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionCteOsValidator implements CteReceptionCteOsValidator {
    @Override
    public void valid(Validation<TCTeOS> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteOS_v"), o.xml()));
    }
}

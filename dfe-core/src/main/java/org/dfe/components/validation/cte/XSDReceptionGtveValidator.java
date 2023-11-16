package org.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TGTVe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte.CteReceptionGtveValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionGtveValidator implements CteReceptionGtveValidator {
    @Override
    public void valid(Validation<TGTVe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("GTVe_v"), o.xml()));
    }
}

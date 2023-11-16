package org.dfe.components.validation.cte4;

import br.inf.portalfiscal.cte.send400.TGTVe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte4.Cte4ReceptionGtveValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionGtveValidator implements Cte4ReceptionGtveValidator {
    @Override
    public void valid(Validation<TGTVe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("GTVe_v"), o.xml()));
    }
}

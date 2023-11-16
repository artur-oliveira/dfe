package org.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte.CteQueryReceiptValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDQueryReceiptValidator implements CteQueryReceiptValidator {
    @Override
    public void valid(Validation<TConsReciCTe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("consReciCTe_v"), o.xml()));
    }
}

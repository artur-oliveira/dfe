package org.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte.CteQuerySituationValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDQuerySituationValidator implements CteQuerySituationValidator {
    @Override
    public void valid(Validation<TConsSitCTe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("consSitCTe_v"), o.xml()));
    }
}

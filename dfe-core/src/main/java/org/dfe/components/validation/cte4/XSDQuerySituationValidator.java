package org.dfe.components.validation.cte4;

import br.inf.portalfiscal.cte.send400.TConsSitCTe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte4.Cte4QuerySituationValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDQuerySituationValidator implements Cte4QuerySituationValidator {
    @Override
    public void valid(Validation<TConsSitCTe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("consSitCTe_v"), o.xml()));
    }
}

package com.softart.dfe.components.validation.cte4;

import br.inf.portalfiscal.cte.send400.TConsSitCTe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte4.Cte4QuerySituationValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDQuerySituationValidator implements Cte4QuerySituationValidator {
    @Override
    public void valid(Validation<TConsSitCTe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("consSitCTe_v"), o.xml()));
    }
}
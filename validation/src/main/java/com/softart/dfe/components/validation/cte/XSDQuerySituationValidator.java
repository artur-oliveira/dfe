package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteQuerySituationValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDQuerySituationValidator implements CteQuerySituationValidator {
    @Override
    public void valid(Validation<TConsSitCTe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/consSitCTe_v3.00.xsd", o.xml()));
    }
}

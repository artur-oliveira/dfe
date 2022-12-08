package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteDistributionValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDDistributionValidator implements CteDistributionValidator {
    @Override
    public void valid(Validation<DistDFeInt> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTeDistDFe_100/distDFeInt_v1.00.xsd", o.getXml()));
    }
}

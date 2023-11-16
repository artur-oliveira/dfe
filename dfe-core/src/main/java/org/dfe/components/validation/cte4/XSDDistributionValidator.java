package org.dfe.components.validation.cte4;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte4.CteDistributionValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDDistributionValidator implements CteDistributionValidator {
    @Override
    public void valid(Validation<DistDFeInt> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTeDistDFe_100/distDFeInt_v1.00.xsd", o.xml()));
    }
}

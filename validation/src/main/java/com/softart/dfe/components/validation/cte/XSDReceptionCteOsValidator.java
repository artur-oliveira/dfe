package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TCTeOS;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteOsValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionCteOsValidator implements CteReceptionCteOsValidator {
    @Override
    public void valid(Validation<TCTeOS> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteOS_v3.00.xsd", o.xml()));
    }
}

package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteStatusServiceValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDStatusServiceValidator implements CteStatusServiceValidator {
    @Override
    public void valid(Validation<TConsStatServ> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/consStatServCTe_v3.00.xsd", o.getXml()));
    }
}

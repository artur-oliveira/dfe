package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteQueryReceiptValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDQueryReceiptValidator implements CteQueryReceiptValidator {
    @Override
    public void valid(Validation<TConsReciCTe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/consReciCTe_v3.00.xsd", o.getXml()));
    }
}

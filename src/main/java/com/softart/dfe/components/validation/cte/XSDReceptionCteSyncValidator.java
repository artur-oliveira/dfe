package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TCTe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteSyncValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionCteSyncValidator implements CteReceptionCteSyncValidator {
    @Override
    public void valid(Validation<TCTe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cte_v3.00.xsd", o.getXml()));
    }
}

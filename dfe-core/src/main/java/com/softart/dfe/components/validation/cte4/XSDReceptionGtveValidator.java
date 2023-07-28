package com.softart.dfe.components.validation.cte4;

import br.inf.portalfiscal.cte.send400.TGTVe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte4.Cte4ReceptionGtveValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionGtveValidator implements Cte4ReceptionGtveValidator {
    @Override
    public void valid(Validation<TGTVe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("GTVe_v"), o.xml()));
    }
}

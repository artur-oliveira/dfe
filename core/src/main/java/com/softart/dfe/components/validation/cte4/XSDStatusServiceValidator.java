package com.softart.dfe.components.validation.cte4;

import br.inf.portalfiscal.cte.send400.TConsStatServ;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte4.Cte4StatusServiceValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDStatusServiceValidator implements Cte4StatusServiceValidator {
    @Override
    public void valid(Validation<TConsStatServ> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("consStatServCTe_v"), o.xml()));
    }
}

package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQuerySituationValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDQuerySituationValidator implements MdfeQuerySituationValidator {
    @Override
    public void valid(Validation<TConsSitMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/consSitMDFe_v3.00.xsd", o.getXml()));
    }
}

package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.DistDFeInt;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeDistributionValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDDistributionValidator implements MdfeDistributionValidator {
    @Override
    public void valid(Validation<DistDFeInt> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/distDFeInt_v1.00.xsd", o.getXml()));
    }
}

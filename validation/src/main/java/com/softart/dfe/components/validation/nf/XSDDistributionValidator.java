package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.NfeDistributionValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDDistributionValidator implements NfeDistributionValidator {
    @Override
    public void valid(Validation<TDistDFeInt> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_NFeDistDFe_103/distDFeInt_v1.01.xsd", o.xml()));
    }
}

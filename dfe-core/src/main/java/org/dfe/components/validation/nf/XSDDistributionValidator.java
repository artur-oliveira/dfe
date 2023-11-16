package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.NfeDistributionValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

final class XSDDistributionValidator implements NfeDistributionValidator {
    @Override
    public void valid(Validation<TDistDFeInt> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_NFeDistDFe_103/distDFeInt_v1.01.xsd", o.xml()));
    }
}

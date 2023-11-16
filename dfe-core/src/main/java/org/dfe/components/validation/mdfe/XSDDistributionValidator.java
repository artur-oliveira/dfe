package org.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.mdfe.MdfeDistributionValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDDistributionValidator implements MdfeDistributionValidator {
    @Override
    public void valid(Validation<TDistDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/distMDFe_v3.00.xsd", o.xml()));
    }
}

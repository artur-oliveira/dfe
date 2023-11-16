package org.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.mdfe.MdfeQuerySituationValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDQuerySituationValidator implements MdfeQuerySituationValidator {
    @Override
    public void valid(Validation<TConsSitMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/consSitMDFe_v3.00.xsd", o.xml()));
    }
}

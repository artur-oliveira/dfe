package org.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.mdfe.MdfeStatusServiceValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDStatusServiceValidator implements MdfeStatusServiceValidator {
    @Override
    public void valid(Validation<TConsStatServ> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/consStatServMDFe_v3.00.xsd", o.xml()));
    }
}

package org.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.mdfe.MdfeQueryReceiptValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDQueryReceiptValidator implements MdfeQueryReceiptValidator {
    @Override
    public void valid(Validation<TConsReciMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/consReciMDFe_v3.00.xsd", o.xml()));
    }
}

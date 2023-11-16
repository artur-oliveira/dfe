package org.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.mdfe.MdfeQueryUnclosedValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDQueryUnclosedValidator implements MdfeQueryUnclosedValidator {
    @Override
    public void valid(Validation<TConsMDFeNaoEnc> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/consMDFeNaoEnc_v3.00.xsd", o.xml()));
    }
}

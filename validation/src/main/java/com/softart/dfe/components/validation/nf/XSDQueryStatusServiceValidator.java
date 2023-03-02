package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.common.NfQueryStatusServiceValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDQueryStatusServiceValidator implements NfQueryStatusServiceValidator {
    @Override
    public void valid(Validation<TConsStatServ> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/PL_009i_NT2021_004_v100d/consStatServ_v4.00.xsd", o.getXml()));
    }
}

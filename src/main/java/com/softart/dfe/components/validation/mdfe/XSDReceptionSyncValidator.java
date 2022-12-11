package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeReceptionSyncValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionSyncValidator implements MdfeReceptionSyncValidator {
    @Override
    public void valid(Validation<TMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/mdfe_v3.00.xsd", o.getXml()));
    }
}

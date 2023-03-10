package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeEventValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDEventValidator implements MdfeEventValidator {
    @Override
    public void valid(Validation<TEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/eventoMDFe_v3.00.xsd", o.getXml()));
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/" + MdfeEvent.valueOfCode(o.getValue().getInfEvento().getTpEvento()).getXsdName(), MdfeMarshallerFactory.getInstance().any(o.getValue().getInfEvento().getDetEvento().getAny())));
    }
}

package org.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.mdfe.MdfeEvent;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.mdfe.MdfeEventValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDEventValidator implements MdfeEventValidator {
    @Override
    public void valid(Validation<TEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/eventoMDFe_v3.00.xsd", o.xml()));
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/" + MdfeEvent.valueOfCode(o.value().getInfEvento().getTpEvento()).getXsdName(), MdfeMarshallerFactory.getInstance().any(o.value().getInfEvento().getDetEvento().getAny())));
    }
}

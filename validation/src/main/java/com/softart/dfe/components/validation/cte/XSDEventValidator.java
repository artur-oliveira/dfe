package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteEventValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDEventValidator implements CteEventValidator {
    @Override
    public void valid(Validation<TEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/eventoCTe_v3.00.xsd", o.xml()));
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/" + CteEvent.valueOfCode(o.value().getInfEvento().getTpEvento()).getXsdName(), CteMarshallerFactory.getInstance().any(o.value().getInfEvento().getDetEvento().getAny())));
    }
}

package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.cte.version.CteEventVersion;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteEventValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDEventValidator implements CteEventValidator {
    @Override
    public void valid(Validation<TEvento> o) throws ValidationException {
        CteEventVersion eventVersion = CteEventVersion.valueOfVersion(o.value().getVersao());
        String rootXsd = eventVersion.xsdRootPath();

        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(rootXsd + "/eventoCTe_v" + eventVersion.getVersion() + ".xsd", o.xml()));
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(rootXsd + "/" + CteEvent.valueOfCode(o.value().getInfEvento().getTpEvento()).getXsdName().replace("{{VERSION}}", eventVersion.getVersion()), CteMarshallerFactory.getInstance().any(o.value().getInfEvento().getDetEvento().getAny())));
    }
}

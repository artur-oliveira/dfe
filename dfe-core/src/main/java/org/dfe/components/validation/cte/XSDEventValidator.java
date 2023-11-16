package org.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TEvento;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.CteEvent;
import org.dfe.enums.cte.version.CteEventVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte.CteEventValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDEventValidator implements CteEventValidator {
    @Override
    public void valid(Validation<TEvento> o) throws ValidationException {
        CteEventVersion eventVersion = CteEventVersion.valueOfVersion(o.value().getVersao());
        String rootXsd = eventVersion.xsdRootPath();

        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(rootXsd + "/eventoCTe_v" + eventVersion.getVersion() + ".xsd", o.xml()));
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(rootXsd + "/" + CteEvent.valueOfCode(o.value().getInfEvento().getTpEvento()).getXsdName().replace("{{VERSION}}", eventVersion.getVersion()), CteMarshallerFactory.getInstance().any(o.value().getInfEvento().getDetEvento().getAny())));
    }
}

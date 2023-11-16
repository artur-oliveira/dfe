package org.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.mdfe.identification.MdfeModal;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.mdfe.MdfeReceptionSyncValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionSyncValidator implements MdfeReceptionSyncValidator {
    @Override
    public void valid(Validation<TMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfe_v3.00.xsd", o.xml()));

        switch (MdfeModal.valueOfCode(o.value().getInfMDFe().getIde().getModal())) {
            case AEREO ->
                    XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalAereo_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.value().getInfMDFe().getInfModal().getAny())));
            case AQUAVIARIO ->
                    XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalAquaviario_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.value().getInfMDFe().getInfModal().getAny())));
            case RODOVIARIO ->
                    XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalRodoviario_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.value().getInfMDFe().getInfModal().getAny())));
            case FERROVIARIO ->
                    XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalFerroviario_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.value().getInfMDFe().getInfModal().getAny())));
        }
    }
}

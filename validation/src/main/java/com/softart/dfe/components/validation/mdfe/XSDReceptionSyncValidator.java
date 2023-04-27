package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.mdfe.identification.MdfeModal;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeReceptionSyncValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionSyncValidator implements MdfeReceptionSyncValidator {
    @Override
    public void valid(Validation<TMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfe_v3.00.xsd", o.getXml()));

        switch (MdfeModal.valueOfCode(o.getValue().getInfMDFe().getIde().getModal())) {
            case AEREO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalAereo_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.getValue().getInfMDFe().getInfModal().getAny())));
                break;
            case AQUAVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalAquaviario_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.getValue().getInfMDFe().getInfModal().getAny())));
                break;
            case RODOVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalRodoviario_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.getValue().getInfMDFe().getInfModal().getAny())));
                break;
            case FERROVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300b/mdfeModalFerroviario_v3.00.xsd", MdfeMarshallerFactory.getInstance().any(o.getValue().getInfMDFe().getInfModal().getAny())));
                break;
        }
    }
}

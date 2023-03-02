package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.identification.CteModal;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteSyncValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionCteSyncValidator implements CteReceptionCteSyncValidator {
    @Override
    public void valid(Validation<TCTe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cte_v3.00.xsd", o.getXml()));

        switch (CteModal.valueOfCode(o.getValue().getInfCte().getIde().getModal())) {
            case AEREO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAereo_v3.00.xsd", CteMarshallerFactory.getInstance().any(o.getValue().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                break;
            case AQUAVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAquaviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(o.getValue().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                break;
            case RODOVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalRodoviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(o.getValue().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                break;
            case FERROVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalFerroviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(o.getValue().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                break;
            case DUTOVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalDutoviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(o.getValue().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                break;
            case MULTIMODAL:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteMultiModal_v3.00.xsd", CteMarshallerFactory.getInstance().any(o.getValue().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                break;
        }
    }
}

package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TEnviCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.identification.CteModal;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionCteValidator implements CteReceptionCteValidator {
    @Override
    public void valid(Validation<TEnviCTe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/enviCTe_v3.00.xsd", o.xml()));

        for (TCTe it : o.value().getCTe()) {
            switch (CteModal.valueOfCode(it.getInfCte().getIde().getModal())) {
                case AEREO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAereo_v3.00.xsd", CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case AQUAVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAquaviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case RODOVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalRodoviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case FERROVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalFerroviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case DUTOVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteModalDutoviario_v3.00.xsd", CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case MULTIMODAL ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/cte/PL_CTe_300a_NT2022.001/cteMultiModal_v3.00.xsd", CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
            }
        }
    }
}

package com.softart.dfe.components.validation.cte;

import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TEnviCTe;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.cte.identification.CteModal;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

import java.util.Objects;

public final class XSDReceptionCteValidator implements CteReceptionCteValidator {
    @Override
    public void valid(Validation<TEnviCTe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("enviCTe_v"), o.xml()));
        if (Objects.equals(eventVersion, CteVersion.VERSION_400)) {

            for (TCTe it : o.value().getCTe()) {
                switch (CteModal.valueOfCode(it.getInfCte().getIde().getModal())) {
                    case AEREO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAereo_v"), CteMarshallerFactory.getInstance().any400(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case AQUAVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAquaviario_v"), CteMarshallerFactory.getInstance().any400(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case RODOVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalRodoviario_v"), CteMarshallerFactory.getInstance().any400(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case FERROVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalFerroviario_v"), CteMarshallerFactory.getInstance().any400(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case DUTOVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalDutoviario_v"), CteMarshallerFactory.getInstance().any400(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case MULTIMODAL ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteMultiModal_v"), CteMarshallerFactory.getInstance().any400(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                }
            }
        } else {
            for (TCTe it : o.value().getCTe()) {
                switch (CteModal.valueOfCode(it.getInfCte().getIde().getModal())) {
                    case AEREO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAereo_v"), CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case AQUAVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAquaviario_v"), CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case RODOVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalRodoviario_v"), CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case FERROVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalFerroviario_v"), CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case DUTOVIARIO ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalDutoviario_v"), CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                    case MULTIMODAL ->
                            XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteMultiModal_v"), CteMarshallerFactory.getInstance().any(it.getInfCte().getInfCTeNorm().getInfModal().getAny())));
                }
            }
        }
    }
}

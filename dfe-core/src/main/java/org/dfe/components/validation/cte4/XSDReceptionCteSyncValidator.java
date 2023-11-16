package org.dfe.components.validation.cte4;

import br.inf.portalfiscal.cte.send400.TCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.cte.identification.CteModal;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.cte4.Cte4ReceptionCteSyncValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;

import java.util.Objects;

public final class XSDReceptionCteSyncValidator implements Cte4ReceptionCteSyncValidator {
    @Override
    public void valid(Validation<TCTe> o) throws ValidationException {
        CteVersion eventVersion = CteVersion.valueOfVersion(o.value().getInfCte().getVersao());
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cte_v"), o.xml()));

        if (Objects.equals(eventVersion, CteVersion.VERSION_400)) {
            switch (CteModal.valueOfCode(o.value().getInfCte().getIde().getModal())) {
                case AEREO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAereo_v"), CteMarshallerFactory.getInstance().any400(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case AQUAVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAquaviario_v"), CteMarshallerFactory.getInstance().any400(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case RODOVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalRodoviario_v"), CteMarshallerFactory.getInstance().any400(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case FERROVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalFerroviario_v"), CteMarshallerFactory.getInstance().any400(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case DUTOVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalDutoviario_v"), CteMarshallerFactory.getInstance().any400(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case MULTIMODAL ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteMultiModal_v"), CteMarshallerFactory.getInstance().any400(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
            }
        } else {
            switch (CteModal.valueOfCode(o.value().getInfCte().getIde().getModal())) {
                case AEREO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAereo_v"), CteMarshallerFactory.getInstance().any(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case AQUAVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalAquaviario_v"), CteMarshallerFactory.getInstance().any(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case RODOVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalRodoviario_v"), CteMarshallerFactory.getInstance().any(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case FERROVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalFerroviario_v"), CteMarshallerFactory.getInstance().any(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case DUTOVIARIO ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteModalDutoviario_v"), CteMarshallerFactory.getInstance().any(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
                case MULTIMODAL ->
                        XMLValidatorFactory.getInstance().validateXML(new XMLValidation(eventVersion.getXsdPath("cteMultiModal_v"), CteMarshallerFactory.getInstance().any(o.value().getInfCte().getInfCTeNorm().getInfModal().getAny())));
            }
        }


    }
}

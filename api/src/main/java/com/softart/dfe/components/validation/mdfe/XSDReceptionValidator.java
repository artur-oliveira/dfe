package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshaller;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.mdfe.identification.MdfeModal;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeReceptionValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDReceptionValidator implements MdfeReceptionValidator {
    @Override
    public void valid(Validation<TEnviMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/enviMDFe_v3.00.xsd", o.getXml()));

        switch (MdfeModal.valueOfCode(o.getValue().getMDFe().getInfMDFe().getIde().getModal())) {
            case AEREO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/mdfeModalAereo_v3.00.xsd", MdfeMarshaller.any(o.getValue().getMDFe().getInfMDFe().getInfModal().getAny())));
                break;
            case AQUAVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/mdfeModalAquaviario_v3.00.xsd", MdfeMarshaller.any(o.getValue().getMDFe().getInfMDFe().getInfModal().getAny())));
                break;
            case RODOVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/mdfeModalRodoviario_v3.00.xsd", MdfeMarshaller.any(o.getValue().getMDFe().getInfMDFe().getInfModal().getAny())));
                break;
            case FERROVIARIO:
                XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/mdfeModalFerroviario_v3.00.xsd", MdfeMarshaller.any(o.getValue().getMDFe().getInfMDFe().getInfModal().getAny())));
                break;
        }
    }
}

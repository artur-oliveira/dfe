package com.softart.dfe.components.validation.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TEvento;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshaller;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.mdfe.MdfeEventValidator;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQueryReceiptValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDQueryReceiptValidator implements MdfeQueryReceiptValidator {
    @Override
    public void valid(Validation<TConsReciMDFe> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/mdfe/PL_MDFe_300a_NT012022/consReciMDFe_v3.00.xsd", o.getXml()));
    }
}

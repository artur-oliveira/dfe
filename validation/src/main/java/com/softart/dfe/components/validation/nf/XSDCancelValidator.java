package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.common.NfCancelValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

final class XSDCancelValidator implements NfCancelValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/envEventoCancNFe_v1.00.xsd", o.getXml()));
    }
}

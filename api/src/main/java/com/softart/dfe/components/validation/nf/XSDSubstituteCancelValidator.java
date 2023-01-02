package com.softart.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import com.softart.dfe.components.internal.xml.validation.XMLValidatorFactory;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.validation.nf.NfceSubstituteCancelValidator;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.xml.XMLValidation;

public final class XSDSubstituteCancelValidator implements NfceSubstituteCancelValidator {
    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/envEventoCancSubst_v1.00.xsd", o.getXml()));
    }
}

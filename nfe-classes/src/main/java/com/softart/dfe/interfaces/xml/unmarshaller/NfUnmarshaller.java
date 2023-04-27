package com.softart.dfe.interfaces.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.send.*;

import javax.xml.bind.JAXBElement;

public interface NfUnmarshaller {
    JAXBElement<TEnvEvento> cancelNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento> substituteCancelNfe(String xml);

    JAXBElement<TEnviNFe> enviNfe(String xml);

    JAXBElement<TInutNFe> inutNfe(String xml);

    JAXBElement<TConsReciNFe> queryReceiptNfe(String xml);

    JAXBElement<TConsSitNFe> queryProtocolNfe(String xml);

    JAXBElement<TDistDFeInt> distributionNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento> manifestationNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> epecNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> correctionLetterNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> interestedActorNfe(String xml);

    JAXBElement<TNFe> nfe(String xml);

    JAXBElement<TNfeProc> nfeProc(String xmlProc);

    JAXBElement<TConsCad> queryRegister(String xml);

    JAXBElement<TRetConsCad> returnQueryRegister(String xml);
}

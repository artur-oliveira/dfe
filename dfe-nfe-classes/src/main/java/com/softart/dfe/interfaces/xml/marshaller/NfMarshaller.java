package com.softart.dfe.interfaces.xml.marshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;

@SuppressWarnings("unused")
public interface NfMarshaller {

    String eventNfe(br.inf.portalfiscal.nfe.event_generic.TEnvEvento o);

    default String eventNfe(JAXBElement<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> o) {
        return eventNfe(o.getValue());
    }

    String returnEventNfe(br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento o);

    default String returnEventNfe(JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> o) {
        return returnEventNfe(o.getValue());
    }

    String procEventNfe(br.inf.portalfiscal.nfe.event_generic.TProcEvento o);

    default String procEventNfe(JAXBElement<br.inf.portalfiscal.nfe.event_generic.TProcEvento> o) {
        return procEventNfe(o.getValue());
    }

    String cancelNfe(br.inf.portalfiscal.nfe.event_cancel.TEnvEvento o);

    default String cancelNfe(JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> o) {
        return cancelNfe(o.getValue());
    }

    String returnCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento o);

    default String returnCancelNfe(JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> o) {
        return returnCancelNfe(o.getValue());
    }

    String procCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TProcEvento o);

    default String procCancelNfe(JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> o) {
        return procCancelNfe(o.getValue());
    }

    String substituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento o);

    default String substituteCancelNfe(JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento> o) {
        return substituteCancelNfe(o.getValue());
    }

    String returnSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento o);

    default String returnSubstituteCancelNfe(JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento> o) {
        return returnSubstituteCancelNfe(o.getValue());
    }

    String procSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento o);

    default String procSubstituteCancelNfe(JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento> o) {
        return procSubstituteCancelNfe(o.getValue());
    }

    default String inutNfe(JAXBElement<TInutNFe> o) {
        return inutNfe(o.getValue());
    }

    String inutNfe(TInutNFe o);

    default String returnInutNfe(JAXBElement<TRetInutNFe> o) {
        return returnInutNfe(o.getValue());
    }

    String returnInutNfe(TRetInutNFe o);

    default String procInutNfe(JAXBElement<TProcInutNFe> o) {
        return procInutNfe(o.getValue());
    }

    String procInutNfe(TProcInutNFe o);

    default String sendNfe(JAXBElement<TEnviNFe> o) {
        return sendNfe(o.getValue());
    }

    String sendNfe(TEnviNFe o);

    default String procNfe(JAXBElement<TNfeProc> o) {
        return procNfe(o.getValue());
    }

    String procNfe(TNfeProc o);

    default String nfe(JAXBElement<TNFe> o) {
        return nfe(o.getValue());
    }

    String nfe(TNFe o);

    default String returnEnviNfe(JAXBElement<TRetEnviNFe> o) {
        return returnEnviNfe(o.getValue());
    }

    String returnEnviNfe(TRetEnviNFe o);

    default String queryReceiptNfe(JAXBElement<TConsReciNFe> o) {
        return queryReceiptNfe(o.getValue());
    }

    String queryReceiptNfe(TConsReciNFe o);

    default String returnQueryReceiptNfe(JAXBElement<TRetConsReciNFe> o) {
        return returnQueryReceiptNfe(o.getValue());
    }

    String returnQueryReceiptNfe(TRetConsReciNFe o);

    default String queryProcotolNfe(JAXBElement<TConsSitNFe> o) {
        return queryProcotolNfe(o.getValue());
    }

    String queryProcotolNfe(TConsSitNFe o);

    default String queryStatusServiceNfe(JAXBElement<TConsStatServ> o) {
        return queryStatusServiceNfe(o.getValue());
    }

    String queryStatusServiceNfe(TConsStatServ o);

    default String returnQueryStatusServiceNfe(JAXBElement<TRetConsStatServ> o) {
        return returnQueryStatusServiceNfe(o.getValue());
    }

    String returnQueryStatusServiceNfe(TRetConsStatServ o);

    default String queryGtinNf(JAXBElement<TConsGTIN> o) {
        return queryGtinNf(o.getValue());
    }

    String queryGtinNf(TConsGTIN o);

    default String returnQueryGtinNf(JAXBElement<TRetConsGTIN> o) {
        return returnQueryGtinNf(o.getValue());
    }

    String returnQueryGtinNf(TRetConsGTIN o);

    default String returnQueryProtocolNfe(JAXBElement<TRetConsSitNFe> o) {
        return returnQueryProtocolNfe(o.getValue());
    }

    String returnQueryProtocolNfe(TRetConsSitNFe o);

    default String distributionNfe(JAXBElement<TDistDFeInt> o) {
        return distributionNfe(o.getValue());
    }

    String distributionNfe(TDistDFeInt o);

    default String returnDistributionNfe(JAXBElement<TRetDistDFeInt> o) {
        return returnDistributionNfe(o.getValue());
    }

    String returnDistributionNfe(TRetDistDFeInt data);

    String manifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento o);

    default String manifestationNfe(JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento> o) {
        return manifestationNfe(o.getValue());
    }

    String procManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TProcEvento o);

    default String procManifestationNfe(JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TProcEvento> o) {
        return procManifestationNfe(o.getValue());
    }

    String returnManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento o);

    default String returnManifestationNfe(JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento> o) {
        return returnManifestationNfe(o.getValue());
    }

    String epecNfe(br.inf.portalfiscal.nfe.event_epec.TEnvEvento o);

    default String epecNfe(JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> o) {
        return epecNfe(o.getValue());
    }

    String returnEpecNfe(br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento o);

    default String returnEpecNfe(JAXBElement<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> o) {
        return returnEpecNfe(o.getValue());
    }

    String procEpecNfe(br.inf.portalfiscal.nfe.event_epec.TProcEvento o);

    default String procEpecNfe(JAXBElement<br.inf.portalfiscal.nfe.event_epec.TProcEvento> o) {
        return procEpecNfe(o.getValue());
    }

    String correctionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento o);

    default String correctionLetterNfe(JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> o) {
        return correctionLetterNfe(o.getValue());
    }

    String returnCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento o);

    default String returnCorrectionLetterNfe(JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> o) {
        return returnCorrectionLetterNfe(o.getValue());
    }

    String procCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento o);

    default String procCorrectionLetterNfe(JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento> o) {
        return procCorrectionLetterNfe(o.getValue());
    }

    String interestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento o);

    default String interestedActorNfe(JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> o) {
        return interestedActorNfe(o.getValue());
    }

    String returnInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento o);

    default String returnInterestedActorNfe(JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> o) {
        return returnInterestedActorNfe(o.getValue());
    }

    String procInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento o);

    default String procInterestedActorNfe(JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento> o) {
        return procInterestedActorNfe(o.getValue());
    }

    String queryRegister(TConsCad data);

    default String queryRegister(JAXBElement<TConsCad> o) {
        return queryRegister(o.getValue());
    }

    String returnQueryRegister(TRetConsCad data);

    default String returnQueryRegister(JAXBElement<TRetConsCad> o) {
        return returnQueryRegister(o.getValue());
    }
}

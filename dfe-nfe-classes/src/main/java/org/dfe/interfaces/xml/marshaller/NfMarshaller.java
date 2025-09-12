package org.dfe.interfaces.xml.marshaller;

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

    String queryRegister(TConsCad data);

    default String queryRegister(JAXBElement<TConsCad> o) {
        return queryRegister(o.getValue());
    }

    String returnQueryRegister(TRetConsCad data);

    default String returnQueryRegister(JAXBElement<TRetConsCad> o) {
        return returnQueryRegister(o.getValue());
    }
}

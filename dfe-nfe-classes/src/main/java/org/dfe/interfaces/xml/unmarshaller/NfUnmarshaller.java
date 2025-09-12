package org.dfe.interfaces.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;
import org.w3c.dom.Element;

public interface NfUnmarshaller {
    JAXBElement<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> eventNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> returnEventNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_generic.TProcEvento> procEventNfe(String xml);

    JAXBElement<TEnviNFe> enviNfe(String xml);

    JAXBElement<TInutNFe> inutNfe(String xml);

    JAXBElement<TRetInutNFe> retInutNfe(String xml);

    JAXBElement<TProcInutNFe> procInutNfe(String xml);

    JAXBElement<TConsReciNFe> queryReceiptNfe(String xml);

    JAXBElement<TConsSitNFe> queryProtocolNfe(String xml);

    JAXBElement<TDistDFeInt> distributionNfe(String xml);

    JAXBElement<TNFe> nfe(String xml);

    JAXBElement<TNfeProc> nfeProc(String xmlProc);

    JAXBElement<TConsCad> queryRegister(String xml);

    JAXBElement<TRetConsCad> returnQueryRegister(String xml);

    JAXBElement<?> anySendNfe(Element el);

    JAXBElement<?> anySendNfe(String xml);

    JAXBElement<?> anyEventNfe(String xml);

    JAXBElement<?> anyDistributionNfe(Element el);

    JAXBElement<?> anyDistributionNfe(String xml);

}

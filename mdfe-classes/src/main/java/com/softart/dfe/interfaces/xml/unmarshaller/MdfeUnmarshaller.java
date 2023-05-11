package com.softart.dfe.interfaces.xml.unmarshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import org.w3c.dom.Element;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;

public interface MdfeUnmarshaller {
    JAXBElement<TDistDFe> sendDistribution(String xml);

    JAXBElement<TEvento> sendEvent(String xml);

    JAXBElement<TConsReciMDFe> sendQueryReceipt(String xml);

    JAXBElement<TConsSitMDFe> sendQuerySituation(String xml);

    JAXBElement<TConsMDFeNaoEnc> sendQueryUnclosed(String xml);

    JAXBElement<TEnviMDFe> sendReception(String xml);

    JAXBElement<TMDFe> sendReceptionSync(String xml);

    JAXBElement<TConsStatServ> sendStatusService(String xml);

    JAXBElement<TRetEvento> returnEvent(Element el);

    JAXBElement<TProtMDFe> protMdfe(Element el);

    JAXBElement<EvCancMDFe> evCancMDFe(Element el);

    Element toElement(EvCancMDFe element) throws JAXBException;

    Element toElement(Rodo element) throws JAXBException;

    Element toElement(Aquav element) throws JAXBException;

    Element toElement(Aereo element) throws JAXBException;

    Element toElement(Ferrov element) throws JAXBException;

    JAXBElement<?> any(Element element);

    JAXBElement<EvAlteracaoPagtoServMDFe> evAlteracaoPagtoServMDFe(Element el);

    Element toElement(EvAlteracaoPagtoServMDFe element) throws JAXBException;

    JAXBElement<EvConfirmaServMDFe> evConfirmaServMDFe(Element el);

    Element toElement(EvConfirmaServMDFe element) throws JAXBException;

    JAXBElement<EvEncMDFe> evEncMDFe(Element el);

    Element toElement(EvEncMDFe element) throws JAXBException;

    JAXBElement<EvIncCondutorMDFe> evIncCondutorMDFe(Element el);

    Element toElement(EvIncCondutorMDFe element) throws JAXBException;

    JAXBElement<EvIncDFeMDFe> evIncDFeMDFe(Element el);

    Element toElement(EvIncDFeMDFe element) throws JAXBException;

    JAXBElement<EvPagtoOperMDFe> evPagtoOperMDFe(Element el);

    Element toElement(EvPagtoOperMDFe element) throws JAXBException;
}

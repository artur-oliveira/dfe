package com.softart.dfe.interfaces.xml.unmarshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import jakarta.xml.bind.JAXBElement;
import org.w3c.dom.Element;

public interface MdfeUnmarshaller {
    JAXBElement<TDistDFe> sendDistribution(String xml);

    JAXBElement<DistDFeInt> sendDistributionOld(String xml);

    JAXBElement<TEvento> sendEvent(String xml);

    JAXBElement<TConsReciMDFe> sendQueryReceipt(String xml);

    JAXBElement<TConsSitMDFe> sendQuerySituation(String xml);

    JAXBElement<TConsMDFeNaoEnc> sendQueryUnclosed(String xml);

    JAXBElement<TEnviMDFe> sendReception(String xml);

    JAXBElement<TMDFe> sendReceptionSync(String xml);

    JAXBElement<TMdfeProc> mdfeProc(String xml);

    JAXBElement<TConsStatServ> sendStatusService(String xml);

    JAXBElement<TRetEvento> returnEvent(Element el);

    JAXBElement<TRetEvento> returnEvent(String xml);

    JAXBElement<TProtMDFe> protMdfe(String xml);

    JAXBElement<TProtMDFe> protMdfe(Element el);

    JAXBElement<?> any(Element element);

    JAXBElement<?> any(String xml);

    JAXBElement<?> anyDistribution(String xml);

    JAXBElement<EvCancMDFe> evCancMDFe(Element el);

    JAXBElement<EvCancMDFe> evCancMDFe(String xml);

    JAXBElement<EvAlteracaoPagtoServMDFe> evAlteracaoPagtoServMDFe(Element el);

    JAXBElement<EvAlteracaoPagtoServMDFe> evAlteracaoPagtoServMDFe(String xml);

    JAXBElement<EvConfirmaServMDFe> evConfirmaServMDFe(Element el);

    JAXBElement<EvConfirmaServMDFe> evConfirmaServMDFe(String xml);

    JAXBElement<EvEncMDFe> evEncMDFe(Element el);

    JAXBElement<EvEncMDFe> evEncMDFe(String xml);

    JAXBElement<EvIncCondutorMDFe> evIncCondutorMDFe(Element el);

    JAXBElement<EvIncCondutorMDFe> evIncCondutorMDFe(String xml);

    JAXBElement<EvIncDFeMDFe> evIncDFeMDFe(Element el);

    JAXBElement<EvIncDFeMDFe> evIncDFeMDFe(String xml);

    JAXBElement<EvPagtoOperMDFe> evPagtoOperMDFe(Element el);

    JAXBElement<EvPagtoOperMDFe> evPagtoOperMDFe(String xml);

}

package com.softart.dfe.interfaces.xml.unmarshaller;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Element;

public interface CteUnmarshaller {
    JAXBElement<br.inf.portalfiscal.cte.distribution.DistDFeInt> distributionCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.distribution.RetDistDFeInt> returnDistributionCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TEvento> eventCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TInutCTe> inutCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TConsSitCTe> querySituationCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TEnviCTe> receptionCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TGTVe> receptionGtve(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TCTeOS> receptionCteOs(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TCTe> receptionCteSync(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TConsReciCTe> queryReceipt(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TConsStatServ> statusService(String xml);

    JAXBElement<?> any300(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCancCTe> evCancCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCancCECTe> evCancCECTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCCeCTe> evCCeCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCECTe> evCECTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvEPECCTe> evEPECCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvGTV> evGTV(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvPrestDesacordo> evPrestDesacordo(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvRegMultimodal> evRegMultimodal(Element element);

    Element toElement(br.inf.portalfiscal.cte.send.EvCancCTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.RodoOS o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.EvCCeCTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.EvCECTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.EvCancCECTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.EvEPECCTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.EvGTV o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.EvRegMultimodal o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.EvPrestDesacordo o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.Rodo o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.Aereo o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.Aquav o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.Duto o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.Ferrov o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send.Multimodal o) throws JAXBException;

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTe> protCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTe> protCTe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTeOS> protCTeOS(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTeOS> protCTeOS(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtGTVe> protGTVe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtGTVe> protGTVe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TEnviCTe> enviCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TEvento> eventCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TInutCTe> inutCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TConsSitCTe> querySituationCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TGTVe> receptionGtve400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCTeOS> receptionCteOs400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCTe> receptionCteSync400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TConsStatServ> statusService400(String xml);

    JAXBElement<?> any400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCTe> evCancCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCECTe> evCancCECTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCCeCTe> evCCeCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCECTe> evCECTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvEPECCTe> evEPECCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvGTV> evGTV400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvPrestDesacordo> evPrestDesacordo400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo> evCancPrestDesacordo400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvRegMultimodal> evRegMultimodal400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvIECTe> evIECTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancIECTe> evCancIECTe400(Element element);

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancCTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.RodoOS o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvCCeCTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvCECTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancCECTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvEPECCTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvGTV o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvRegMultimodal o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvPrestDesacordo o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvIECTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancIECTe o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.Rodo o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.Aereo o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.Aquav o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.Duto o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.Ferrov o) throws JAXBException;

    Element toElement(br.inf.portalfiscal.cte.send400.Multimodal o) throws JAXBException;

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(String xml);
}

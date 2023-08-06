package com.softart.dfe.interfaces.xml.unmarshaller;

import jakarta.xml.bind.JAXBElement;
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

    JAXBElement<?> any300(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCancCTe> evCancCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCancCTe> evCancCTe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCancCECTe> evCancCECTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCancCECTe> evCancCECTe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCCeCTe> evCCeCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCCeCTe> evCCeCTe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCECTe> evCECTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvCECTe> evCECTe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvEPECCTe> evEPECCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvEPECCTe> evEPECCTe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvGTV> evGTV(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvGTV> evGTV(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvPrestDesacordo> evPrestDesacordo(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvPrestDesacordo> evPrestDesacordo(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.EvRegMultimodal> evRegMultimodal(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.EvRegMultimodal> evRegMultimodal(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.Rodo> rodo(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.Rodo> rodo(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send.Aereo> aereo(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.Aereo> aereo(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send.Aquav> aquav(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.Aquav> aquav(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send.Duto> duto(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.Duto> duto(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send.Ferrov> ferrov(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.Ferrov> ferrov(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send.Multimodal> multimodal(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.Multimodal> multimodal(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTe> protCTe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTe> protCTe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTeOS> protCTeOS(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtCTeOS> protCTeOS(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtGTVe> protGTVe(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send.TProtGTVe> protGTVe(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TEnviCTe> enviCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TCteProc> cteProc(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TCteOSProc> cteOsProc(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send.TGTVeProc> gtveProc(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TEvento> eventCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TInutCTe> inutCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TConsSitCTe> querySituationCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TGTVe> receptionGtve400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCTeOS> receptionCteOs400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCTe> receptionCteSync400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TConsStatServ> statusService400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TRetConsStatServ> returnStatusService400(String xml);

    JAXBElement<?> any400(Element element);

    JAXBElement<?> any400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCTe> evCancCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCTe> evCancCTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCECTe> evCancCECTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCECTe> evCancCECTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCCeCTe> evCCeCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCCeCTe> evCCeCTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCECTe> evCECTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCECTe> evCECTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvEPECCTe> evEPECCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvEPECCTe> evEPECCTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvGTV> evGTV400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvGTV> evGTV400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvPrestDesacordo> evPrestDesacordo400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvPrestDesacordo> evPrestDesacordo400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo> evCancPrestDesacordo400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo> evCancPrestDesacordo400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvRegMultimodal> evRegMultimodal400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvRegMultimodal> evRegMultimodal400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvIECTe> evIECTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvIECTe> evIECTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancIECTe> evCancIECTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.EvCancIECTe> evCancIECTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.Rodo> rodo400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.Rodo> rodo400(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send400.Aereo> aereo400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.Aereo> aereo400(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send400.Aquav> aquav400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.Aquav> aquav400(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send400.Duto> duto400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.Duto> duto400(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send400.Ferrov> ferrov400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.Ferrov> ferrov400(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send400.Multimodal> multimodal400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.Multimodal> multimodal400(Element el);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(Element element);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCteProc> cteProc400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCteOSProc> cteOsProc400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TGTVeProc> gtveProc400(String xml);

}

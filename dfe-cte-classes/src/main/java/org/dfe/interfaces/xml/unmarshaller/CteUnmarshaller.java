package org.dfe.interfaces.xml.unmarshaller;

import jakarta.xml.bind.JAXBElement;
import org.w3c.dom.Element;

public interface CteUnmarshaller {
    JAXBElement<br.inf.portalfiscal.cte.distribution.DistDFeInt> distributionCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.distribution.RetDistDFeInt> returnDistributionCte(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TEvento> eventCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TProcEvento> procEventCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TInutCTe> inutCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TConsSitCTe> querySituationCte400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TGTVe> receptionGtve400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCTeOS> receptionCteOs400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCTe> receptionCteSync400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TCteProc> cteProc400(String xml);

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

    JAXBElement<br.inf.portalfiscal.cte.send400.TCteOSProc> cteOsProc400(String xml);

    JAXBElement<br.inf.portalfiscal.cte.send400.TGTVeProc> gtveProc400(String xml);

}

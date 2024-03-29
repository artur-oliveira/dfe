package org.dfe.interfaces.xml.marshaller;

import org.w3c.dom.Element;

public interface CteMarshaller {

    String distributionCte(br.inf.portalfiscal.cte.distribution.DistDFeInt data);

    String returnDistributionCte(br.inf.portalfiscal.cte.distribution.RetDistDFeInt data);

    String eventCte(br.inf.portalfiscal.cte.send400.TEvento data);

    String returnEventCte(br.inf.portalfiscal.cte.send400.TRetEvento data);

    String procEventCte(br.inf.portalfiscal.cte.send400.TProcEvento data);

    String inutilizationCte(br.inf.portalfiscal.cte.send400.TInutCTe data);

    String returnInutilizationCte(br.inf.portalfiscal.cte.send400.TRetInutCTe data);

    String procInutilizationCte(br.inf.portalfiscal.cte.send400.TProcInutCTe data);

    String querySituationCte(br.inf.portalfiscal.cte.send400.TConsSitCTe data);

    String returnQuerySituationCte(br.inf.portalfiscal.cte.send400.TRetConsSitCTe data);

    String cteProc(br.inf.portalfiscal.cte.send400.TCteProc data);

    String receptionGtve(br.inf.portalfiscal.cte.send400.TGTVe data);

    String returnReceptionGtve(br.inf.portalfiscal.cte.send400.TRetGTVe data);

    String gtveProc(br.inf.portalfiscal.cte.send400.TGTVeProc data);

    String receptionCteOs(br.inf.portalfiscal.cte.send400.TCTeOS data);

    String returnReceptionCteOs(br.inf.portalfiscal.cte.send400.TRetCTeOS data);

    String cteOsProc(br.inf.portalfiscal.cte.send400.TCteOSProc data);

    String receptionCteSync(br.inf.portalfiscal.cte.send400.TCTe data);

    String returnReceptionCteSync(br.inf.portalfiscal.cte.send400.TRetCTe data);

    String cteProcSync(br.inf.portalfiscal.cte.send400.TCteProc data);

    String statusService(br.inf.portalfiscal.cte.send400.TConsStatServ data);

    String returnStatusService(br.inf.portalfiscal.cte.send400.TRetConsStatServ data);

    String any(Element element);

    String any400(Element element);

    String protCte(Element element);

    String protCte400(Element element);

    String protCteOs(Element element);

    String protCteOs400(Element element);

    String protGtve(Element element);

    String protGtve400(Element element);

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancCTe o);

    Element toElement(br.inf.portalfiscal.cte.send400.RodoOS o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvCCeCTe o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvCECTe o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancCECTe o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvEPECCTe o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvGTV o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvRegMultimodal o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvPrestDesacordo o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvIECTe o);

    Element toElement(br.inf.portalfiscal.cte.send400.EvCancIECTe o);

    Element toElement(br.inf.portalfiscal.cte.send400.Rodo o);

    Element toElement(br.inf.portalfiscal.cte.send400.Aereo o);

    Element toElement(br.inf.portalfiscal.cte.send400.Aquav o);

    Element toElement(br.inf.portalfiscal.cte.send400.Duto o);

    Element toElement(br.inf.portalfiscal.cte.send400.Ferrov o);

    Element toElement(br.inf.portalfiscal.cte.send400.Multimodal o);
}

package org.dfe.interfaces.xml.marshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import org.w3c.dom.Element;

public interface MdfeMarshaller {

    String rodo(Rodo data);

    String aereo(Aereo data);

    String ferrov(Ferrov data);

    String aquav(Aquav data);

    String any(Element element);

    String sendDistribution(TDistDFe data);

    String returnDistribution(TRetDistDFe data);

    String sendDistributionOld(DistDFeInt data);

    String returnDistributionOld(RetDistDFeInt data);

    String returnEvent(TRetEvento data);

    String sendQueryUnclosed(TConsMDFeNaoEnc data);

    String returnQueryUnclosed(TRetConsMDFeNaoEnc data);

    String sendEvent(TEvento data);

    String procEvent(TProcEvento data);

    String sendQueryReceipt(TConsReciMDFe data);

    String returnQueryReceipt(TRetConsReciMDFe data);

    String returnQuerySituation(TRetConsSitMDFe data);

    String sendQuerySituation(TConsSitMDFe data);

    String sendReception(TEnviMDFe data);

    String returnReception(TRetEnviMDFe data);

    String sendReceptionSync(TMDFe data);

    String returnReceptionSync(TRetMDFe data);

    String procMdfe(TMdfeProc mdfeProc);

    String sendStatusService(TConsStatServ data);

    String returnStatusService(TRetConsStatServ data);

    Element toElement(Rodo element);

    Element toElement(Aquav element);

    Element toElement(Aereo element);

    Element toElement(Ferrov element);

    Element toElement(EvCancMDFe element);

    Element toElement(EvAlteracaoPagtoServMDFe element);

    Element toElement(EvConfirmaServMDFe element);

    Element toElement(EvEncMDFe element);

    Element toElement(EvIncCondutorMDFe element);

    Element toElement(EvIncDFeMDFe element);

    Element toElement(EvPagtoOperMDFe element);
}

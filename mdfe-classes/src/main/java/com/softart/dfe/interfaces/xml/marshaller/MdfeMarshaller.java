package com.softart.dfe.interfaces.xml.marshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import org.w3c.dom.Element;

public interface MdfeMarshaller {
    String any(Element element);

    String returnDistribution(TRetDistDFe data);

    String returnEvent(TRetEvento data);

    String returnQueryReceipt(TRetConsReciMDFe data);

    String returnQuerySituation(TRetConsSitMDFe data);

    String returnQueryUnclosed(TRetConsMDFeNaoEnc data);

    String returnReception(TRetEnviMDFe data);

    String returnReceptionSync(TRetMDFe data);

    String returnStatusService(TRetConsStatServ data);

    String sendDistribution(TDistDFe data);

    String sendEvent(TEvento data);

    String procEvent(TProcEvento data);

    String sendQueryReceipt(TConsReciMDFe data);

    String sendQuerySituation(TConsSitMDFe data);

    String sendQueryUnclosed(TConsMDFeNaoEnc data);

    String sendReception(TEnviMDFe data);

    String sendReceptionSync(TMDFe data);

    String procMdfe(TMdfeProc mdfeProc);

    String sendStatusService(TConsStatServ data);
}

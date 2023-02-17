package com.softart.dfe.interfaces.xml.marshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import org.w3c.dom.Element;

public interface CteMarshaller {
    String distributionCte(DistDFeInt data);

    String returnDistributionCte(RetDistDFeInt data);

    String eventCte(TEvento data);

    String returnEventCte(TRetEvento data);

    String procEventCte(TProcEvento data);

    String inutilizationCte(TInutCTe data);

    String returnInutilizationCte(TRetInutCTe data);

    String procInutilizationCte(TProcInutCTe data);

    String querySituationCte(TConsSitCTe data);

    String returnQuerySituationCte(TRetConsSitCTe data);

    String receptionCte(TEnviCTe data);

    String returnReceptionCte(TRetEnviCTe data);

    String cteProc(TCteProc data);

    String receptionGtve(TGTVe data);

    String returnReceptionGtve(TRetGTVe data);

    String gtveProc(TGTVeProc data);

    String receptionCteOs(TCTeOS data);

    String returnReceptionCteOs(TRetCTeOS data);

    String cteOsProc(TCteOSProc data);

    String receptionCteSync(TCTe data);

    String returnReceptionCteSync(TRetCTe data);

    String cteProcSync(TCteProc data);

    String queryReceipt(TConsReciCTe data);

    String returnQueryReceipt(TRetConsReciCTe data);

    String statusService(TConsStatServ data);

    String returnStatusService(TRetConsStatServ data);

    String any(Element element);

    String protCte(Element element);

    String protCteOs(Element element);

    String protGtve(Element element);
}

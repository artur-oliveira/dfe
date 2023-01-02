package com.softart.dfe.interfaces.sefaz.cte;

import com.softart.dfe.interfaces.internal.allow.CteServiceAllow;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;

public interface CteService extends CteDistribution, CteServiceAllow, CteEvent, CteInutilization, CteQuerySituation, CteReception, CteReceptionGtve, CteReceptionOs, CteReceptionSync, CteQueryReceipt, CteStatusService {

    CteSoapService getSoapService();

    CteService withSoapService(CteSoapService nfeSoapService);

}

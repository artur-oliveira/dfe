package com.softart.dfe.interfaces.sefaz.mdfe;

import com.softart.dfe.interfaces.internal.allow.MdfeServiceAllow;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;

public interface MdfeService extends MdfeServiceAllow, MdfeDistribution, MdfeEvent, MdfeQueryReceipt, MdfeQuerySituation, MdfeQueryUnclosed, MdfeReception, MdfeReceptionSync, MdfeStatusService {

    MdfeSoapService getSoapService();

    MdfeService withSoapService(MdfeSoapService soapService);

}

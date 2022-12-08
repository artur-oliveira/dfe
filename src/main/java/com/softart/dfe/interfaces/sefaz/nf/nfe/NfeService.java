package com.softart.dfe.interfaces.sefaz.nf.nfe;

import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;

public interface NfeService extends NfCommonService, NfeManifestation, NfeDistribution, NfeEpec, NfeManifestation.NfeCorrectionLetter, NfeInterestedActor, NfeQueryGtin {

    NfeSoapService getSoapService();

    NfeService withSoapService(NfeSoapService nfeSoapService);

}

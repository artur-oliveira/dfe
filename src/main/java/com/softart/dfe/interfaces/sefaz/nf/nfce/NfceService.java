package com.softart.dfe.interfaces.sefaz.nf.nfce;

import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;

public interface NfceService extends NfCommonService, NfceSubstituteCancel {

    NfceSoapService getSoapService();

    NfceService withSoapService(NfceSoapService soapService);

}

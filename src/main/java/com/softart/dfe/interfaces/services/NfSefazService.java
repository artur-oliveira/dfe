package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.process.nf.NfProcess;

public interface NfSefazService extends SefazService {

    NfConfig getConfig();

    NfProcess getProcess();

}

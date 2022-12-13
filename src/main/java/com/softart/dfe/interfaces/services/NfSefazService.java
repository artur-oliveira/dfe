package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.process.nf.NfProcessService;

public interface NfSefazService extends SefazService {

    /**
     * > Returns the current configuration of the NF
     *
     * @return The NfConfig object.
     */
    NfConfig getConfig();

    /**
     * Returns the process service.
     *
     * @return A reference to the process service.
     */
    NfProcessService getProcess();

}

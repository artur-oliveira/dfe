package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.process.mdfe.MdfeProcessService;

public interface MdfeSefazService extends SefazService {

    /**
     * > Returns the configuration object used by the MDF-e library
     *
     * @return The configuration object.
     */
    MdfeConfig getConfig();

    /**
     * Returns the process service
     *
     * @return The MdfeProcessService object.
     */
    MdfeProcessService getProcess();

}

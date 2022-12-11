package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.process.mdfe.MdfeProcess;

public interface MdfeSefazService extends SefazService {

    MdfeConfig getConfig();

    MdfeProcess getProcess();

}

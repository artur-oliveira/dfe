package com.softart.dfe.interfaces.security;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;

public interface CertificateChain {

    Environment getEnvironment();

    UF getUf();

    Model getModel();

    String fileName();

}

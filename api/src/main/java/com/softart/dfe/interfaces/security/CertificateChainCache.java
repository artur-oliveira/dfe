package com.softart.dfe.interfaces.security;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;

import java.io.IOException;

public interface CertificateChainCache {

    byte[] getFromCache(CertificateChain certificateChain) throws IOException;

    void addToCache(CertificateChain generate, byte[] bytes) throws IOException;


}

package com.softart.dfe.interfaces.security;

import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.interfaces.internal.config.Config;

import javax.net.ssl.SSLContext;

public interface SocketFactoryService {
    SSLContext context(Config config) throws SSLContextException;
}

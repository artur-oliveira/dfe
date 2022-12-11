package com.softart.dfe.components.security.socket;

import com.softart.dfe.interfaces.security.SocketFactoryService;

public abstract class SocketFactory implements SocketFactoryService {
    public static SocketFactory getInstance() {
        return SocketFactoryHolder.INSTANCE;
    }

    private static class SocketFactoryHolder {
        static final SocketFactory INSTANCE = new SocketFactoryServiceImpl();
    }
}

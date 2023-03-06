package com.softart.dfe.components.security.socket;

import com.softart.dfe.interfaces.security.SocketFactoryService;

public abstract class SocketFactory implements SocketFactoryService {
    /**
     * If the instance is null, create it. If it's not null, return it.
     *
     * @return A singleton instance of the SocketFactory class.
     */
    public static SocketFactory getInstance() {
        return SocketFactoryHolder.INSTANCE;
    }

    private static class SocketFactoryHolder {
        static final SocketFactory INSTANCE = new SocketFactoryServiceImpl();
    }
}

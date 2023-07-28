package com.softart.dfe.components.security.keystore;

import com.softart.dfe.interfaces.security.KeyStoreParserService;

public abstract class KeyStoreParserFactory implements KeyStoreParserService {

    public static KeyStoreParserFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final KeyStoreParserFactory INSTANCE = new KeyStoreParserServiceImpl();
    }
}

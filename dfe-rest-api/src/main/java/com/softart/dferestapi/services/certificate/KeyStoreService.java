package com.softart.dferestapi.services.certificate;

import com.softart.dfe.interfaces.internal.KeyStoreInfo;

public interface KeyStoreService {

    KeyStoreInfo getKeyStore(final String certificateMd5, final String certificatePassword);

    void addKeyStore(final String certificateMd5, final byte[] bytes);

}

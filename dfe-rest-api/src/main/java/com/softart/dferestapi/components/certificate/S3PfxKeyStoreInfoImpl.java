package com.softart.dferestapi.components.certificate;

import com.softart.dfe.components.internal.certificate.PfxKeyStoreInfoImpl;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.util.S3Utils;

public final class S3PfxKeyStoreInfoImpl extends PfxKeyStoreInfoImpl {

    public S3PfxKeyStoreInfoImpl(String bucket, String key, String certificatePassword) throws CertificateException {
        super(S3Utils.clientInstance().getObject(bucket, key).getObjectContent(), certificatePassword);
    }


}

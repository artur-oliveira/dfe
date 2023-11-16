package org.dfe.components.internal.certificate;

import org.dfe.exceptions.security.CertificateException;
import org.dfe.util.S3Utils;

public final class S3PfxKeyStoreInfoImpl extends PfxKeyStoreInfoImpl {

    public S3PfxKeyStoreInfoImpl(String bucket, String key, String certificatePassword) throws CertificateException {
        super(S3Utils.clientInstance().getObject(bucket, key).getObjectContent(), certificatePassword);
    }


}

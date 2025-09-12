package org.dfe.components.internal.certificate;

import org.dfe.util.RequireUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class S3PfxKeyStoreInfoImplTest {

    @Test
    void testS3PfxKeyStoreInfoImplTest() throws Exception {
        PfxKeyStoreInfoImpl keyStoreInfo = new S3PfxKeyStoreInfoImpl(System.getProperty("org.dfe.certificate.bucket"), System.getProperty("org.dfe.certificate.key"), RequireUtils.nonNull(System.getProperty("org.dfe.certificate.password"), "The password of default certificate must be set with property org.dfe.certificate.password"));
        assertNotNull(keyStoreInfo.getAlias());
    }

}
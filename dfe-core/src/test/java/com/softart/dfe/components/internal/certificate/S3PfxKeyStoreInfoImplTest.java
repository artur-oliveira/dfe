package com.softart.dfe.components.internal.certificate;

import com.softart.dfe.util.RequireUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class S3PfxKeyStoreInfoImplTest {

    @Test
    void testS3PfxKeyStoreInfoImplTest() throws Exception {
        PfxKeyStoreInfoImpl keyStoreInfo = new S3PfxKeyStoreInfoImpl(System.getProperty("com.softart.dfe.certificate.bucket"), System.getProperty("com.softart.dfe.certificate.key"), RequireUtils.nonNull(System.getProperty("com.softart.dfe.certificate.password"), "The password of default certificate must be set with property com.softart.dfe.certificate.password"));
        assertEquals("tartigrado tecnologia ltda11520224000140", keyStoreInfo.getAlias());
    }

}
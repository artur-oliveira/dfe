package com.softart.dfe.components.internal.nfe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QrCodeGeneratorFactoryTest {

    @Test
    void testGetInstance() {
        assertEquals(QrCodeV2UrlGenerator.class, QrCodeGeneratorFactory.getInstance().getClass());
    }
}
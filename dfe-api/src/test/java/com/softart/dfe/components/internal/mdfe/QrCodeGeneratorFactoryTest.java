package com.softart.dfe.components.internal.mdfe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QrCodeGeneratorFactoryTest {

    @Test
    void testGetInstance() {
        assertEquals(QrCodeUrlGenerator.class, QrCodeGeneratorFactory.getInstance().getClass());
    }
}
package org.dfe.components.internal.xml.objectfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultNfObjectFactoryWrapperTest {

    @Test
    void testGetSendNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getSendNfeObjectFactory());
    }

    @Test
    void testGetGtinNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getGtinNfeObjectFactory());
    }

    @Test
    void testGetDistributionNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getDistributionNfeObjectFactory());
    }
}
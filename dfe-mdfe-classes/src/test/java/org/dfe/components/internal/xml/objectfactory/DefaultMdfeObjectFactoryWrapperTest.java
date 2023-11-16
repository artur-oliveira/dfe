package org.dfe.components.internal.xml.objectfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultMdfeObjectFactoryWrapperTest {

    @Test
    void testGetObjectFactory() {
        assertNotNull(new DefaultMdfeObjectFactoryWrapper().getObjectFactory());
    }

    @Test
    void testGetDistributionObjectFactory() {
        assertNotNull(new DefaultMdfeObjectFactoryWrapper().getDistributionObjectFactory());
    }
}
package com.softart.dfe.components.internal.xml.objectfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultNfObjectFactoryWrapperTest {

    @Test
    void testGetSendNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getSendNfeObjectFactory());
    }

    @Test
    void testGetEventNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getEventNfeObjectFactory());
    }

    @Test
    void testGetCancelNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getCancelNfeObjectFactory());
    }

    @Test
    void testGetSubstituteCancelNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getSubstituteCancelNfeObjectFactory());
    }

    @Test
    void testGetCorrectionLetterNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getCorrectionLetterNfeObjectFactory());
    }

    @Test
    void testGetEpecNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getEpecNfeObjectFactory());
    }

    @Test
    void testGetManifestationNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getManifestationNfeObjectFactory());
    }

    @Test
    void testGetInterestedActorNfeObjectFactory() {
        assertNotNull(new DefaultNfObjectFactoryWrapper().getInterestedActorNfeObjectFactory());
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
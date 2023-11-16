package org.dfe.components.internal.xml.context;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultNfContextTest {

    @Test
    void testGetNfeCancelContext() {
        assertNotNull(new DefaultNfContext().getNfeCancelContext());
    }

    @Test
    void testGetNfeSubstituteCancelContext() {
        assertNotNull(new DefaultNfContext().getNfeSubstituteCancelContext());
    }

    @Test
    void testGetNfeSendContext() {
        assertNotNull(new DefaultNfContext().getNfeSendContext());
    }

    @Test
    void testGetNfeDistributionContext() {
        assertNotNull(new DefaultNfContext().getNfeDistributionContext());
    }

    @Test
    void testGetNfeManifestationContext() {
        assertNotNull(new DefaultNfContext().getNfeManifestationContext());
    }

    @Test
    void testGetNfeEpecContext() {
        assertNotNull(new DefaultNfContext().getNfeEpecContext());
    }

    @Test
    void testGetNfeCorrectionLetterContext() {
        assertNotNull(new DefaultNfContext().getNfeCorrectionLetterContext());
    }

    @Test
    void testGetNfeInterestedActorContext() {
        assertNotNull(new DefaultNfContext().getNfeInterestedActorContext());
    }

    @Test
    void testGetNfeGtinContext() {
        assertNotNull(new DefaultNfContext().getNfeGtinContext());
    }
}
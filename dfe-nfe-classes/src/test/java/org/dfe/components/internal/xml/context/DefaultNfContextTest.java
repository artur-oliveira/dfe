package org.dfe.components.internal.xml.context;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultNfContextTest {

    @Test
    void testGetNfeSendContext() {
        assertNotNull(new DefaultNfContext().getNfeSendContext());
    }

    @Test
    void testGetNfeDistributionContext() {
        assertNotNull(new DefaultNfContext().getNfeDistributionContext());
    }


    @Test
    void testGetNfeGtinContext() {
        assertNotNull(new DefaultNfContext().getNfeGtinContext());
    }
}
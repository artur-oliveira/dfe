package org.dfe.components.internal.xml.context;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultCteContextTest {

    @Test
    void testGetCte400SendContext() {
        assertNotNull(new DefaultCteContext().getCte400SendContext());
    }

    @Test
    void testGetCteDistributionContext() {
        assertNotNull(new DefaultCteContext().getCteDistributionContext());
    }
}
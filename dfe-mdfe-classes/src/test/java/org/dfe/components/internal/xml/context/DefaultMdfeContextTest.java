package org.dfe.components.internal.xml.context;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultMdfeContextTest {

    @Test
    void testGetMdfeContext() {
        Assertions.assertNotNull(new DefaultMdfeContext().getMdfeContext());
    }
}
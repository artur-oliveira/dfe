package org.dfe.components.internal.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessKeyParserFactoryTest {

    @Test
    void testNfe() {
        assertEquals(NfAccessKeyParser.class, AccessKeyParserFactory.nfe().getClass());
    }

    @Test
    void testCte() {
        assertEquals(CteAccessKeyParser.class, AccessKeyParserFactory.cte().getClass());
    }

    @Test
    void testMdfe() {
        assertEquals(MdfeAccessKeyParser.class, AccessKeyParserFactory.mdfe().getClass());
    }
}
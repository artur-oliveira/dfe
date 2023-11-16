package org.dfe.components.internal.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MdfeAccessKeyParserTest {

    @Test
    void testIdPrefix() {
        assertEquals("MDFe", new MdfeAccessKeyParser().idPrefix());
    }

    @Test
    void testFromId() {
        assertEquals("99999999999999999999999999999999999999999999", new MdfeAccessKeyParser().fromId("MDFe99999999999999999999999999999999999999999999"));
    }
}
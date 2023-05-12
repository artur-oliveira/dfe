package com.softart.dfe.components.internal.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CteAccessKeyParserTest {

    @Test
    void testIdPrefix() {
        assertEquals("CTe", new CteAccessKeyParser().idPrefix());
    }

    @Test
    void testFromId() {
        assertEquals("99999999999999999999999999999999999999999999", new CteAccessKeyParser().fromId("CTe99999999999999999999999999999999999999999999"));
    }
}
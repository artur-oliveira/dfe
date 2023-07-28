package com.softart.dfe.components.internal.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NfAccessKeyParserTest {

    @Test
    void testIdPrefix() {
        assertEquals("NFe", new NfAccessKeyParser().idPrefix());
    }


    @Test
    void testFromId() {
        assertEquals("99999999999999999999999999999999999999999999", new NfAccessKeyParser().fromId("NFe99999999999999999999999999999999999999999999"));
    }
}
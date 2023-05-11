package com.softart.dfe.components.internal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessKeyGeneratorTest {

    @Test
    void testAccessKeyWithoutDV() {
        assertEquals("2223011152022400014022001000000001112345678", AccessKeyGenerator.accessKeyWithoutDV("22", "2023-01-01T00:00:00-03:00", "11520224000140", "55", "1", "1", "1", "12345678"));
    }

    @Test
    void testAccessKey() {
        assertEquals("22230111520224000140220010000000011123456786", AccessKeyGenerator.accessKey("22", "2023-01-01T00:00:00-03:00", "11520224000140", "55", "1", "1", "1", "12345678"));
    }

    @Test
    void testDigit() {
        assertEquals("6", AccessKeyGenerator.digit("22", "2023-01-01T00:00:00-03:00", "11520224000140", "55", "1", "1", "1", "12345678"));
    }
}
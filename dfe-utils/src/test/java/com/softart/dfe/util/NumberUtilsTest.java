package com.softart.dfe.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberUtilsTest {

    @Test
    void testRandom() {
        assertEquals(15, String.valueOf(NumberUtils.random()).length());
    }

    @Test
    void testRandomWithDigCount() {
        assertEquals(12, String.valueOf(NumberUtils.random(12)).length());
    }
}
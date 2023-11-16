package org.dfe.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringUtilsTest {

    @Test
    void testExtractDigits() {
        assertNull(StringUtils.extractDigits(null));
        assertEquals("12344", StringUtils.extractDigits("123abcd44"));
    }

    @Test
    void testEmpty() {
        assertEquals("", StringUtils.empty());
    }

    @Test
    void testConcat() {
        assertEquals("123456abc", StringUtils.concat("123", "456", "abc"));
    }

    @Test
    void testPadZeroStart() {
        assertEquals("00001", StringUtils.padZeroStart("1", 5));
        assertEquals("0000000001", StringUtils.padZeroStart("1", 10));
    }

    @Test
    void zero() {
        assertEquals("0", StringUtils.zero());
    }

    @Test
    void testZeroWithScale() {
        assertEquals("0.000000", StringUtils.zero(6));
    }

    @Test
    void testUpper() {
        assertNull(StringUtils.upper(null));
        assertEquals("ABCD", StringUtils.upper("ABCD"));
    }

    @Test
    void testLower() {
        assertNull(StringUtils.lower(null));
        assertEquals("abcd", StringUtils.lower("ABCD"));
    }

    @Test
    void testRandom() {
        assertEquals(15, StringUtils.random().length());
    }

    @Test
    void testRandomWithLength() {
        assertEquals(12, StringUtils.random(12).length());
    }

    @Test
    void padStart() {
        assertEquals("TTTTTA", StringUtils.padStart("A", 6, 'T'));
    }

    @Test
    void toAscii() {
        assertEquals("AAAAEEEEIIIIOOOOUUUUC", StringUtils.toAscii("ÁÀÃÂÉÈẼÊÍÌĨÎÓÒÕÔÚÙŨÛÇ"));
    }
}
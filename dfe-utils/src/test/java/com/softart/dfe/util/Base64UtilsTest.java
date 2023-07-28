package com.softart.dfe.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Base64UtilsTest {

    @Test
    void testDecodeBinary() {
        assertEquals("ZPapSkkw+aqPgxMRw601rFYUt3Q=", Base64Utils.decodeBinary(new byte[]{100, -10, -87, 74, 73, 48, -7, -86, -113, -125, 19, 17, -61, -83, 53, -84, 86, 20, -73, 116}));
    }

}
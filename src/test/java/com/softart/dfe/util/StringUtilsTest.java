package com.softart.dfe.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void padZeroStart() {
        Assertions.assertEquals("DD1", StringUtils.padStart("1", 3, 'D'));
    }

    @Test
    void padStart() {
        Assertions.assertEquals("001", StringUtils.padZeroStart("1", 3));
    }
}
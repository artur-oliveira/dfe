package com.softart.dfe.util;

import com.softart.dfe.exceptions.RequiredException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequireUtilsTest {

    @Test
    void testNonNull() {
        RequiredException ex = assertThrows(RequiredException.class, () -> RequireUtils.nonNull(null, "null obj"));
        assertEquals("null obj", ex.getMessage());
    }
}
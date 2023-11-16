package org.dfe.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FunctionsTest {

    @Test
    void testIsNullOrEmpty() {
        assertTrue(Functions.isNullOrEmpty(""));
        assertTrue(Functions.isNullOrEmpty(null));
        assertTrue(Functions.isNullOrEmpty(new ArrayList<>()));
        assertTrue(Functions.isNullOrEmpty(new HashMap<>()));
        assertTrue(Functions.isNullOrEmpty(new int[]{}));
        assertTrue(Functions.isNullOrEmpty(new float[]{}));
        assertTrue(Functions.isNullOrEmpty(new double[]{}));
    }

    @Test
    void testCoalesce() {
        assertEquals("12", Functions.coalesce(null, null, "12", "13"));
    }
}
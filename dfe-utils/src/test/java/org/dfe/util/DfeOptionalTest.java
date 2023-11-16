package org.dfe.util;

import org.dfe.exceptions.DfeOptionalException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DfeOptionalTest {

    @Test
    void testOfEmpty() {
        assertFalse(DfeOptional.ofEmpty(new ArrayList<>()).isPresent());
        assertFalse(DfeOptional.ofEmpty(new HashMap<>()).isPresent());
        assertFalse(DfeOptional.ofEmpty("").isPresent());
        assertTrue(DfeOptional.ofEmpty("1").isPresent());
    }

    @Test
    void testOfCondition() {
        assertTrue(DfeOptional.ofCondition(true, "1").isPresent());
        assertFalse(DfeOptional.ofCondition(false, "1").isPresent());
    }

    @Test
    void testOfLengthRange() {
        assertTrue(DfeOptional.ofRange("123", 1, 3).isPresent());
        assertFalse(DfeOptional.ofRange("123", 1, 2).isPresent());
        assertThrows(DfeOptionalException.class, () -> DfeOptional.ofRange(0, 1, 1).orElseThrow(DfeOptionalException::new));
    }

    @Test
    void testOfLengthEq() {
        assertTrue(DfeOptional.ofLengthEq("1", 1).isPresent());
        assertFalse(DfeOptional.ofLengthEq("11", 1).isPresent());
    }

    @Test
    void testOfLengthGt() {
        assertTrue(DfeOptional.ofLengthGt("11", 1).isPresent());
        assertFalse(DfeOptional.ofLengthGt("1", 1).isPresent());
    }

    @Test
    void testOfLengthGte() {
        assertTrue(DfeOptional.ofLengthGte("1", 1).isPresent());
        assertTrue(DfeOptional.ofLengthGte("11", 1).isPresent());
        assertFalse(DfeOptional.ofLengthGte("", 1).isPresent());
    }

    @Test
    void testOfLengthLt() {
        assertTrue(DfeOptional.ofLengthLt("123", 4).isPresent());
        assertFalse(DfeOptional.ofLengthLt("123", 3).isPresent());
    }

    @Test
    void testOfLengthLte() {
        assertTrue(DfeOptional.ofLengthLte("123", 3).isPresent());
        assertFalse(DfeOptional.ofLengthLte("123", 2).isPresent());
    }
}
package org.dfe.util;

import org.dfe.exceptions.DfeOptionalException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RequireUtilsTest {

    @Test
    void testNonNull() {
        DfeOptionalException ex = assertThrows(DfeOptionalException.class, () -> RequireUtils.nonNull(null, "null obj"));
        assertEquals("null obj", ex.getMessage());
    }
}
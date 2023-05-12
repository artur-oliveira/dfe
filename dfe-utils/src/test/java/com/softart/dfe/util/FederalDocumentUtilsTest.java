package com.softart.dfe.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FederalDocumentUtilsTest {

    @Test
    void testIsValidCnpj() {
        Assertions.assertTrue(FederalDocumentUtils.isValidCnpj("97185385000140"));
        Assertions.assertFalse(FederalDocumentUtils.isValidCnpj("99999999999999"));
    }

    @Test
    void testIsValidCpf() {
        Assertions.assertFalse(FederalDocumentUtils.isValidCpf("99999999999"));
        Assertions.assertFalse(FederalDocumentUtils.isValidCpf("00099999999999"));
        Assertions.assertTrue(FederalDocumentUtils.isValidCpf("86130278063"));
        Assertions.assertTrue(FederalDocumentUtils.isValidCpf("00086130278063"));
    }
}
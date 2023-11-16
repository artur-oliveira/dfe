package org.dfe.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class IOUtilsTest {

    @Test
    void testGetFileNamePreffix() {
        assertEquals("20222", IOUtils.getFileNamePreffix("kek/sakksdak/lsladlsa/20222.xml"));
        assertEquals("20222", IOUtils.getFileNamePreffix("kek/sakksdak/lsladlsa/20222"));
        assertEquals("20222", IOUtils.getFileNamePreffix("////lsladlsa/20222.xml"));
        assertEquals("20222", IOUtils.getFileNamePreffix("20222.xml"));
        assertEquals("20222", IOUtils.getFileNamePreffix("20222"));
    }

    @Test
    void getFileNameSuffix() {
        assertEquals(".xml", IOUtils.getFileNameSuffix("kek/sakksdak/lsladlsa/20222.xml"));
        assertNull(IOUtils.getFileNameSuffix("kek/sakksdak/lsladlsa/20222"));
    }
}
package org.dfe.models.internal.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

class RootPathTest {

    @Test
    @DisplayName("Test RootPath: Should return only one path for a nf with a 44 character xml name")
    void testXmlNameWithoutExtension() {
        Assertions.assertEquals("29240505384877000147550010000162381230765852", RootPath.builder().xmlName("29240505384877000147550010000162381230765852.xml").build().xmlNameWithoutExtension());
    }

    @Test
    @DisplayName("Test RootPath: Should return only one path for a nf with a 44 character xml name")
    void testGetAllPathsForNfeProc() {
        Collection<RootPath> rootPaths = RootPath
                .builder()
                .key("nfeProc")
                .xmlName("29240505384877000147550010000162381230765852.xml")
                .build()
                .getAllPaths();

        Assertions.assertEquals(1, rootPaths.size());
    }

    @Test
    @DisplayName("Test RootPath: Should return two paths for nf with event in xml Name")
    void testGetAllPathsForNfeEvent() {
        Collection<RootPath> rootPaths = RootPath
                .builder()
                .key("nfeProc")
                .xmlName("29240505384877000147550010000162381230765852-110110-1.xml")
                .build()
                .getAllPaths();

        Assertions.assertEquals(2, rootPaths.size());
    }

    @Test
    @DisplayName("Test RootPath: Should return one path other actions")
    void testGetAllPathsForInutilizationEvent() {
        Collection<RootPath> rootPaths = RootPath
                .builder()
                .key("nfeProc")
                .xmlName("55_1_55000_55000.xml")
                .build()
                .getAllPaths();

        Assertions.assertEquals(1, rootPaths.size());
    }
}
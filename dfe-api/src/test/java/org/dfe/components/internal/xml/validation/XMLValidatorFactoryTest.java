package org.dfe.components.internal.xml.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLValidatorFactoryTest {

    @Test
    void testGetInstance() {
        assertEquals(DefaultXMLValidator.class, XMLValidatorFactory.getInstance().getClass());
    }
}
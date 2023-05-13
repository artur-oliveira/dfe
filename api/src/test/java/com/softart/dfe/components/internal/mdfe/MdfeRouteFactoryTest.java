package com.softart.dfe.components.internal.mdfe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MdfeRouteFactoryTest {

    @Test
    void testGetInstance() {
        assertEquals(MdfeRouteServiceImpl.class, MdfeRouteFactory.getInstance().getClass());
    }
}
package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.enums.internal.UF;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MdfeRouteServiceImplTest {

    @Test
    void testGetRouteBetweenPiAndPa() {
        List<UF> route = new MdfeRouteServiceImpl().getRoute(UF.PI, UF.PA);
        assertEquals(1, route.size());
        assertEquals(UF.MA, route.get(0));
    }
}
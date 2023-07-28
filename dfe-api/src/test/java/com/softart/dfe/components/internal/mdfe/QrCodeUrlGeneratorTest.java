package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.enums.internal.UF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QrCodeUrlGeneratorTest {

    @Test
    void testGenerateProd() throws Exception {
        for (UF uf : UF.states()) {
            assertEquals("https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode?chMDFe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generateNormal(uf.getCode(), "99999999999999999999999999999999999999999999", "1"));
        }
    }

    @Test
    void testGenerateHom() throws Exception {
        for (UF uf : UF.states()) {
            assertEquals("https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode?chMDFe=99999999999999999999999999999999999999999999&tpAmb=2", new QrCodeUrlGenerator().generateNormal(uf.getCode(), "99999999999999999999999999999999999999999999", "2"));
        }
    }
}
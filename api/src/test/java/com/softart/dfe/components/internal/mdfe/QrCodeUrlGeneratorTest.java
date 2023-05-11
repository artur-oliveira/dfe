package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QrCodeUrlGeneratorTest {

    @Test
    void testGenerateProd() throws NoProviderFound {
        for (UF uf : UF.states()) {
            assertEquals("https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode?chMDFe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(uf.getCode(), "99999999999999999999999999999999999999999999", "1"));
        }
    }

    @Test
    void testGenerateHom() throws NoProviderFound {
        for (UF uf : UF.states()) {
            assertEquals("https://dfe-portal.svrs.rs.gov.br/mdfe/qrCode?chMDFe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(uf.getCode(), "99999999999999999999999999999999999999999999", "1"));
        }
    }
}
package com.softart.dfe.components.internal.cte;

import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QrCodeUrlGeneratorTest {


    @Test
    void testGenerateSvrsHom() throws NoProviderFound {
        for (UF uf : Arrays.asList(UF.AC, UF.AL, UF.AM, UF.BA, UF.CE, UF.DF, UF.ES, UF.GO, UF.MA, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RS, UF.RO, UF.SC, UF.SE, UF.TO)) {
            assertEquals("https://dfe-portal.svrs.rs.gov.br/cte/qrCode?chCTe=99999999999999999999999999999999999999999999&tpAmb=2", new QrCodeUrlGenerator().generate(uf.getCode(), "99999999999999999999999999999999999999999999", "2"));
        }
    }

    @Test
    void testGenerateSvrsProd() throws NoProviderFound {
        for (UF uf : Arrays.asList(UF.AC, UF.AL, UF.AM, UF.BA, UF.CE, UF.DF, UF.ES, UF.GO, UF.MA, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RS, UF.RO, UF.SC, UF.SE, UF.TO)) {
            assertEquals("https://dfe-portal.svrs.rs.gov.br/cte/qrCode?chCTe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(uf.getCode(), "99999999999999999999999999999999999999999999", "1"));
        }
    }

    @Test
    void testGenerateSvspHom() throws NoProviderFound {
        for (UF uf : Arrays.asList(UF.AP, UF.PE, UF.RR, UF.SP)) {
            assertEquals("https://homologacao.nfe.fazenda.sp.gov.br/CTeConsulta/qrCode?chCTe=99999999999999999999999999999999999999999999&tpAmb=2", new QrCodeUrlGenerator().generate(uf.getCode(), "99999999999999999999999999999999999999999999", "2"));
        }
    }

    @Test
    void testGenerateSvspProd() throws NoProviderFound {
        for (UF uf : Arrays.asList(UF.AP, UF.PE, UF.RR, UF.SP)) {
            assertEquals("https://nfe.fazenda.sp.gov.br/CTeConsulta/qrCode?chCTe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(uf.getCode(), "99999999999999999999999999999999999999999999", "1"));
        }
    }

    @Test
    void testGenerateMgHom() throws NoProviderFound {
        assertEquals("https://cte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml?chCTe=99999999999999999999999999999999999999999999&tpAmb=2", new QrCodeUrlGenerator().generate(UF.MG.getCode(), "99999999999999999999999999999999999999999999", "2"));
    }

    @Test
    void testGenerateMgProd() throws NoProviderFound {
        assertEquals("https://cte.fazenda.mg.gov.br/portalcte/sistema/qrcode.xhtml?chCTe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(UF.MG.getCode(), "99999999999999999999999999999999999999999999", "1"));
    }

    @Test
    void testGenerateMsHom() throws NoProviderFound {
        assertEquals("https://www.dfe.ms.gov.br/cte/qrcode?chCTe=99999999999999999999999999999999999999999999&tpAmb=2", new QrCodeUrlGenerator().generate(UF.MS.getCode(), "99999999999999999999999999999999999999999999", "2"));
    }

    @Test
    void testGenerateMsProd() throws NoProviderFound {
        assertEquals("https://www.dfe.ms.gov.br/cte/qrcode?chCTe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(UF.MS.getCode(), "99999999999999999999999999999999999999999999", "1"));
    }

    @Test
    void testGenerateMtHom() throws NoProviderFound {
        assertEquals("https://homologacao.sefaz.mt.gov.br/cte/qrcode?chCTe=99999999999999999999999999999999999999999999&tpAmb=2", new QrCodeUrlGenerator().generate(UF.MT.getCode(), "99999999999999999999999999999999999999999999", "2"));
    }

    @Test
    void testGenerateMtProd() throws NoProviderFound {
        assertEquals("https://www.sefaz.mt.gov.br/cte/qrcode?chCTe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(UF.MT.getCode(), "99999999999999999999999999999999999999999999", "1"));
    }

    @Test
    void testGeneratePrHom() throws NoProviderFound {
        assertEquals("https://www.fazenda.pr.gov.br/cte/qrcode?chCTe=99999999999999999999999999999999999999999999&tpAmb=2", new QrCodeUrlGenerator().generate(UF.PR.getCode(), "99999999999999999999999999999999999999999999", "2"));
    }

    @Test
    void testGeneratePrProd() throws NoProviderFound {
        assertEquals("https://www.fazenda.pr.gov.br/cte/qrcode?chCTe=99999999999999999999999999999999999999999999&tpAmb=1", new QrCodeUrlGenerator().generate(UF.PR.getCode(), "99999999999999999999999999999999999999999999", "1"));
    }

}
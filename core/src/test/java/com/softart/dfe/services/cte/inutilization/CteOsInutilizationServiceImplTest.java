package com.softart.dfe.services.cte.inutilization;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.enums.cte.CteReturnCode;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CteOsInutilizationServiceImplTest {
    public CteOsInutilizationServiceImplTest() {
        System.setProperty("com.softart.dfe.ws.timeout", "60");
    }

    @Test
    void testInutilizarWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsProductionAndAuthorizerSvsp() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(UF.MS.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(UF.MT.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(UF.PR.getCode(), o.getInfInut().getCuf());
    }

    @Test
    void testInutilizarWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        CteOsInutilizationService service = new CteOsInutilizationServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnInutilization o = service.inutilizar(1L, 1L);
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfInut().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfInut().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfInut().getCuf());
    }
}
package org.dfe.services.nf.inutilization;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.inut.ReturnNfeInut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfeInutilizationServiceImplTest {
    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.BA.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.BA.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.GO.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.GO.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PE.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PE.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MA.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MA.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeInutilizationService service = new NfeInutilizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }
}
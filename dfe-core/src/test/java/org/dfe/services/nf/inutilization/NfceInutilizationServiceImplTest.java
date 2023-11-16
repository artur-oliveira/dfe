package org.dfe.services.nf.inutilization;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfceConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.inut.ReturnNfeInut;
import jakarta.xml.ws.WebServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfceInutilizationServiceImplTest {
    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        try {
            ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
            assertNotNull(o);
            assertEquals(UF.GO.getCode(), o.getInfInut().getCuf());
            assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
        } catch (WebServiceException ignored) {

        }
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.GO.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfInut().getTpAmb());
    }

    @Test
    void testInutilizationWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceInutilizationService service = new NfceInutilizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340")
        );
        ReturnNfeInut o = service.inutilization(1, 1, 1, NFEvent.INUTILIZATION.getDefaultMessage());
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getInfInut().getCuf());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfInut().getTpAmb());
    }
}
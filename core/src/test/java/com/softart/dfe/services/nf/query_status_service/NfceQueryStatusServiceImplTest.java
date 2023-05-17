package com.softart.dfe.services.nf.query_status_service;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfceConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfceQueryStatusServiceImplTest {
    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceQueryStatusService service = new NfceQueryStatusServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }
}
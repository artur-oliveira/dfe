package org.dfe.services.nf.query_protocol;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfceConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfceQueryProtocolServiceImplTest {
    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceQueryProtocolService service = new NfceQueryProtocolServiceImpl(
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
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140650010001701561960954681");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }
}
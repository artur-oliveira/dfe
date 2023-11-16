package org.dfe.services.nf.query_protocol;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfeQueryProtocolServiceImplTest {
    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeQueryProtocolService service = new NfeQueryProtocolServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryProtocolNfe o = service.queryProtocol("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }
}
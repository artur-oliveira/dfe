package com.softart.dfe.services.nf.query_status_service;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfeQueryStatusServiceImplTest {
    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryStatusServiceWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeQueryStatusService service = new NfeQueryStatusServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryStatusServiceNf o = service.queryStatusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }
}
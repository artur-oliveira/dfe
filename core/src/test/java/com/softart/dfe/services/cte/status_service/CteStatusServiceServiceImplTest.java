package com.softart.dfe.services.cte.status_service;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.enums.cte.CteReturnCode;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.cte.status_service.CteReturnStatusService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CteStatusServiceServiceImplTest {
    @Test
    void testStatusServiceEnvironmentHomologationAndAuthorizerSvrs() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentProductionAndAuthorizerSvrs() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentHomologationAndAuthorizerSvsp() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentProductionAndAuthorizerSvsp() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentHomologationAndAuthorizerMg() throws Exception {
         CteStatusServiceService service = new CteStatusServiceServiceImpl(
                 new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
         );
         CteReturnStatusService o = service.statusService();
         assertNotNull(o);
         assertEquals(service.getConfig().uf().getCode(), o.getCuf());
         assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
         assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentProductionAndAuthorizerMg() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentHomologationAndAuthorizerMt() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentProductionAndAuthorizerMt() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentHomologationAndAuthorizerMs() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentProductionAndAuthorizerMs() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentHomologationAndAuthorizerPr() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

    @Test
    void testStatusServiceEnvironmentProductionAndAuthorizerPr() throws Exception {
        CteStatusServiceService service = new CteStatusServiceServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnStatusService o = service.statusService();
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(CteReturnCode.CODE_107.getCode(), o.getCStat());
    }

}
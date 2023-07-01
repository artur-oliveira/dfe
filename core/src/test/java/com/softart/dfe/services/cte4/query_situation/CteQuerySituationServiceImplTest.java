package com.softart.dfe.services.cte4.query_situation;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.enums.cte.CteReturnCode;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.cte4.query_situation.CteReturnQuerySituation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CteQuerySituationServiceImplTest {

    @Test
    void testQuerySituationWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22230511520224000140570010000005381308657638");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
    }

    @Test
    void testQuerySituationWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22210711520224000140570010000000011019130939");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
    }

    @Test
    void testQuerySituationWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22230511520224000140570010000005381308657638");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
    }

    @Test
    void testQuerySituationWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22210711520224000140570010000000011019130939");
        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
    }


    @Test
    void testQuerySituationWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22230511520224000140570010000005381308657638");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
    }

    @Test
    void testQuerySituationWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22210711520224000140570010000000011019130939");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
    }

    @Test
    void testQuerySituationWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22230511520224000140570010000005381308657638");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("22230511520224000140570010000005381308657638", o.getProtCTe().getInfProt().getChCTe());
    }

    @Test
    void testQuerySituationWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("22210711520224000140570010000000011019130939");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(CteReturnCode.CODE_731.getCode(), o.getCStat());
    }

    @Test
    void testQuerySituationWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("31230520008462000162570010000010661454325837");
        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(CteReturnCode.CODE_217.getCode(), o.getCStat());
    }

    @Test
    void testQuerySituationWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("31230520008462000162570010000010661454325837");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("31230520008462000162570010000010661454325837", o.getProtCTe().getInfProt().getChCTe());
    }

    @Test
    void testQuerySituationWithEnvironmentIsHomologationAndAuthorizerSvsp() throws Exception {
        com.softart.dfe.services.cte4.query_situation.CteQuerySituationService service = new com.softart.dfe.services.cte4.query_situation.CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("35230408172088000130570010000045131224664092");

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(CteReturnCode.CODE_217.getCode(), o.getCStat());
    }

    @Test
    void testQuerySituationWithEnvironmentIsProductionAndAuthorizerSvsp() throws Exception {
        CteQuerySituationService service = new CteQuerySituationServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        CteReturnQuerySituation o = service.querySituation("35230408172088000130570010000045131224664092");
        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("35230408172088000130570010000045131224664092", o.getProtCTe().getInfProt().getChCTe());
    }

}
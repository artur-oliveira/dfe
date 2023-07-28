package com.softart.dfe.services.cte.query_receipt;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.cte.query_receipt.ReturnQueryReceipt;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CteQueryReceiptServiceImplTest {

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("310999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("310999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("310999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("310999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("510999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("510999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("510999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("510999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("400999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("400999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertTrue(Objects.equals("106", o.getCStat()) || Objects.equals("999", o.getCStat()));
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("400999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("400999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertTrue(Objects.equals("106", o.getCStat()) || Objects.equals("999", o.getCStat()));
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("500999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("500999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("500999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("500999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsHomologationAndAuthorizerSvsp() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("350999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("350999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsProductionAndAuthorizerSvsp() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("350999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertTrue(Objects.equals("350999999999999", o.getNRec()) || Objects.equals("000000000000000", o.getNRec()));
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertTrue(Objects.equals("106", o.getCStat()) || Objects.equals("678", o.getCStat()));
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("223999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("223999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        CteQueryReceiptService service = new CteQueryReceiptServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );
        ReturnQueryReceipt o = service.queryReceipt("223999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals("223999999999999", o.getNRec());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
        assertEquals("106", o.getCStat());
    }
}
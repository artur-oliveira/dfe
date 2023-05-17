package com.softart.dfe.services.nf.query_register;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.query_register.ReturnQueryRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NfeQueryRegisterServiceImplTest {
    @Test
    void testQueryRegisterWithUfAc() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("84308980000184", UF.AC);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("84308980000184", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfAl() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("12229415000110", UF.AL);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("12229415000110", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfAp() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("05965546000109", UF.AP);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("05965546000109", o.getInfCons().getCnpj());
    }

    @Test
    void testQueryRegisterWithUfBa() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("15139629000194", UF.BA);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("15139629000194", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfCe() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("12361267000193", UF.CE);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("12361267000193", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfDf() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("17457404000101", UF.DF);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("17457404000101", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfEs() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("00827783000181", UF.ES);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("00827783000181", o.getInfCons().getCnpj());
    }

    @Test
    void testQueryRegisterWithUfGo() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("01543032000104", UF.GO);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("01543032000104", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfMg() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("01928075000108", UF.MG);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("01928075000108", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfMs() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("29059865000105", UF.MS);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("29059865000105", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfMt() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("17356474000173", UF.MT);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("17356474000173", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfPa() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("12094570000177", UF.PA);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("12094570000177", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfPb() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("09095183000140", UF.PB);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("09095183000140", o.getInfCons().getCnpj());
    }


    @Test
    void testQueryRegisterWithUfPe() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("10835932000108", UF.PE);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("10835932000108", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfPi() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("11520224000140", UF.PI);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("11520224000140", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfPr() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("61082962000121", UF.PR);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("61082962000121", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfRj() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("33592510000154", UF.RJ);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("33592510000154", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfRn() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("23314594000100", UF.RN);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("23314594000100", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfRs() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("02016440000162", UF.RS);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("2016440000162", o.getInfCons().getCnpj());
    }

    @Test
    void testQueryRegisterWithUfRo() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("05802757000112", UF.RO);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("05802757000112", o.getInfCons().getCnpj());
    }

    @Test
    void testQueryRegisterWithUfRr() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("07573569000195", UF.RR);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("07573569000195", o.getInfCons().getCnpj());
    }

    @Test
    void testQueryRegisterWithUfSc() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("81611931000128", UF.SC);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("81611931000128", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfSe() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("13017462000163", UF.SE);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("13017462000163", o.getInfCons().getInfCad().get(0).getCnpj());
    }

    @Test
    void testQueryRegisterWithUfTo() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("09067572000162", UF.TO);
        assertNotNull(o);
        assertNotNull(o.getInfCons());
        assertTrue(o.getInfCons().getInfCad().size() >= 1);
        assertEquals("09067572000162", o.getInfCons().getCnpj());
    }
}
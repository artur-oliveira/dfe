package com.softart.dfe.services.nf.cancel;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.NFReturnCode;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NfeCancelServiceImplTest {
    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.BA.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.BA.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(0, o.getRetEvento().size());
        assertEquals(UF.GO.getCode(), o.getCOrgao());
        assertEquals(NFReturnCode.CODE_217.getCode(), o.getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(0, o.getRetEvento().size());
        assertEquals(UF.GO.getCode(), o.getCOrgao());
        assertEquals(NFReturnCode.CODE_217.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
//        NfeCancelService service = new NfeCancelServiceImpl(
//                new PfxNfeConfigImpl(
//                        UF.MG,
//                        "11520224000140",
//                        Environment.HOMOLOGATION,
//                        KeyStoreFactory.getInstance(),
//                        NFEmissionType.NORMAL,
//                        NFSend.SYNC
//                )
//        );
//        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
//        assertNotNull(o);
//        assertEquals(1, o.getRetEvento().size());
//        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
//        assertEquals(UF.MG.getCode(), o.getCOrgao());
//        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MG.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertTrue(1 == o.getRetEvento().size() || o.getRetEvento().isEmpty());
        if (o.getRetEvento().size() == 1) {
            assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
            assertEquals(UF.MT.getCode(), o.getCOrgao());
            assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        } else {
            assertEquals(UF.MT.getCode(), o.getCOrgao());
            assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
            assertEquals(NFReturnCode.CODE_656.getCode(), o.getCStat());
        }
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PE.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PE.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PR.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PR.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MA.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_250.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MA.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_250.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeCancelService service = new NfeCancelServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCancel o = service.cancel("22230511520224000140550010000450661287506862", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }
}
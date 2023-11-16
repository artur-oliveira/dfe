package org.dfe.services.nf.cancel;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfceConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.NFReturnCode;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.cancel.ReturnNfeCancel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfceCancelServiceImplTest {
    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(NFReturnCode.CODE_217.getCode(), o.getCStat());
        assertEquals(UF.GO.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.GO.getCode(), o.getCOrgao());
        assertEquals(NFReturnCode.CODE_217.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_222.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCancelWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceCancelService service = new NfceCancelServiceImpl(
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
        ReturnNfeCancel o = service.cancel("22230511520224000140650010001701561960954681", "999999999999999", NFEvent.CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }
}
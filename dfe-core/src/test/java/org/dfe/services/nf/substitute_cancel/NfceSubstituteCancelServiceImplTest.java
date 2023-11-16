package org.dfe.services.nf.substitute_cancel;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfceConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.NFReturnCode;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.substitute_cancel.ReturnNfceSubstituteCancel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfceSubstituteCancelServiceImplTest {
    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());
        assertNotNull(o);
        assertEquals(NFReturnCode.CODE_128.getCode(), o.getCStat());
        assertEquals(UF.GO.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.GO.getCode(), o.getCOrgao());
        assertEquals(NFReturnCode.CODE_128.getCode(), o.getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MG.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PR.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_614.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_491.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_491.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_222.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testSubstituteCancelWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(
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
        ReturnNfceSubstituteCancel o = service.substituteCancel("22230511520224000140650010001701561960954681", "22230511520224000140650010001701561960954681", "999999999999999", NFEvent.SUBSTITUTE_CANCEL.getDefaultMessage());

        assertNotNull(o);
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.SUBSTITUTE_CANCEL.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }
}
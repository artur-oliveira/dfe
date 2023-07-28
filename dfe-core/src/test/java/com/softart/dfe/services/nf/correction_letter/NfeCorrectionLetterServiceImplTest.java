package com.softart.dfe.services.nf.correction_letter;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.NFReturnCode;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;
import jakarta.xml.ws.WebServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NfeCorrectionLetterServiceImplTest {
    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.AM.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.BA.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.BA.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        try {
            ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
            assertNotNull(o);
            assertEquals(1, o.getRetEvento().size());
            assertEquals(UF.GO.getCode(), o.getCOrgao());
            assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
        } catch (WebServiceException ex) {
            if (!ex.getMessage().contains("https://homolog.sefaz.go.gov.br/nfe/services/NFeRecepcaoEvento4?wsdl"))
                throw ex;
        }
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(UF.GO.getCode(), o.getCOrgao());
        assertEquals(NFReturnCode.CODE_494.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
//        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
//                new PfxNfeConfigImpl(
//                        UF.MG,
//                        "11520224000140",
//                        Environment.HOMOLOGATION,
//                        KeyStoreFactory.getInstance(),
//                        NFEmissionType.NORMAL,
//                        NFSend.SYNC
//                )
//        );
//        ReturnNfeCorrectionLetter o = service.correctionLetter()("22230511520224000140550010000450661287506862", "99999999999999922230511520224000140550010000450661287506862, N"1);
//        assertNotNull(o);
//        assertEquals(1, o.getRetEvento().size());
//        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
//        assertEquals(UF.MG.getCode(), o.getCOrgao());
//        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MG.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MS.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
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
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PE.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PE.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PR.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertTrue(1 == o.getRetEvento().size() || o.getRetEvento().isEmpty());
        if (o.getRetEvento().size() == 1) {
            assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
            assertEquals(UF.PR.getCode(), o.getCOrgao());
            assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
        } else {
            assertEquals(UF.PR.getCode(), o.getCOrgao());
            assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
            assertEquals(NFReturnCode.CODE_656.getCode(), o.getCStat());
        }

    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.RS.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.SP.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MA.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MA.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_249.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_491.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getRetEvento().get(0).getInfEvento().getCOrgao());
        assertEquals(NFReturnCode.CODE_491.getCode(), o.getRetEvento().get(0).getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.MT.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getTpAmb());
    }

    @Test
    void testCorrectionLetterWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnNfeCorrectionLetter o = service.correctionLetter("22230511520224000140550010000450661287506862", "22230511520224000140550010000450661287506862", "1");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.CORRECTION_LETTER.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(UF.PI.getCode(), o.getCOrgao());
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }
}
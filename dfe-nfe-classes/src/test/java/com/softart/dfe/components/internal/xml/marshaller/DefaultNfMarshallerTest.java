package com.softart.dfe.components.internal.xml.marshaller;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultNfMarshallerTest {

    @Test
    void testCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().cancelNfe(new br.inf.portalfiscal.nfe.event_cancel.TEnvEvento()));
    }

    @Test
    void testReturnCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().returnCancelNfe(new br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento()));
    }

    @Test
    void testProcCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().procCancelNfe(new br.inf.portalfiscal.nfe.event_cancel.TProcEvento()));
    }

    @Test
    void testSubstituteCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().substituteCancelNfe(new br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento()));
    }

    @Test
    void testReturnSubstituteCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().returnSubstituteCancelNfe(new br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento()));
    }

    @Test
    void testProcSubstituteCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().procSubstituteCancelNfe(new br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento()));
    }

    @Test
    void testInutNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><inutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().inutNfe(new br.inf.portalfiscal.nfe.send.TInutNFe()));
    }

    @Test
    void testReturnInutNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retInutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().returnInutNfe(new br.inf.portalfiscal.nfe.send.TRetInutNFe()));
    }

    @Test
    void testProcInutNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ProcInutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().procInutNfe(new br.inf.portalfiscal.nfe.send.TProcInutNFe()));
    }

    @Test
    void testSendNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().sendNfe(new br.inf.portalfiscal.nfe.send.TEnviNFe()));
    }

    @Test
    void testProcNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><nfeProc xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().procNfe(new br.inf.portalfiscal.nfe.send.TNfeProc()));
    }

    @Test
    void testNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().nfe(new br.inf.portalfiscal.nfe.send.TNFe()));
    }

    @Test
    void testReturnEnviNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().returnEnviNfe(new br.inf.portalfiscal.nfe.send.TRetEnviNFe()));
    }

    @Test
    void testQueryReceiptNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().queryReceiptNfe(new br.inf.portalfiscal.nfe.send.TConsReciNFe()));
    }

    @Test
    void testReturnQueryReceiptNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnQueryReceiptNfe(new br.inf.portalfiscal.nfe.send.TRetConsReciNFe()));
    }

    @Test
    void testQueryProcotolNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().queryProcotolNfe(new br.inf.portalfiscal.nfe.send.TConsSitNFe()));
    }

    @Test
    void testQueryStatusServiceNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().queryStatusServiceNfe(new br.inf.portalfiscal.nfe.send.TConsStatServ()));
    }

    @Test
    void testReturnQueryStatusServiceNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnQueryStatusServiceNfe(new br.inf.portalfiscal.nfe.send.TRetConsStatServ()));
    }

    @Test
    void testQueryGtinNf() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consGTIN xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().queryGtinNf(new br.inf.portalfiscal.nfe.gtin.TConsGTIN()));
    }

    @Test
    void testReturnQueryGtinNf() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsGTIN xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnQueryGtinNf(new br.inf.portalfiscal.nfe.gtin.TRetConsGTIN()));
    }

    @Test
    void testReturnQueryProtocolNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnQueryProtocolNfe(new br.inf.portalfiscal.nfe.send.TRetConsSitNFe()));
    }

    @Test
    void testDistributionNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><distDFeInt xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().distributionNfe(new br.inf.portalfiscal.nfe.distribution.TDistDFeInt()));
    }

    @Test
    void testReturnDistributionNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retDistDFeInt xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnDistributionNfe(new br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt()));
    }

    @Test
    void testManifestationNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().manifestationNfe(new br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento()));
    }

    @Test
    void testProcManifestationNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().procManifestationNfe(new br.inf.portalfiscal.nfe.event_manifestation.TProcEvento()));
    }

    @Test
    void testReturnManifestationNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnManifestationNfe(new br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento()));
    }

    @Test
    void testEpecNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().epecNfe(new br.inf.portalfiscal.nfe.event_epec.TEnvEvento()));
    }

    @Test
    void testReturnEpecNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnEpecNfe(new br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento()));
    }

    @Test
    void testProcEpecNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().procEpecNfe(new br.inf.portalfiscal.nfe.event_epec.TProcEvento()));
    }

    @Test
    void testCorrectionLetterNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().correctionLetterNfe(new br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento()));
    }

    @Test
    void testReturnCorrectionLetterNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnCorrectionLetterNfe(new br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento()));
    }

    @Test
    void testProcCorrectionLetterNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().procCorrectionLetterNfe(new br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento()));
    }

    @Test
    void testInterestedActorNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().interestedActorNfe(new br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento()));
    }

    @Test
    void testReturnInterestedActorNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnInterestedActorNfe(new br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento()));

    }

    @Test
    void testProcInterestedActorNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().procInterestedActorNfe(new br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento()));
    }

    @Test
    void testQueryRegister() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ConsCad xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().queryRegister(new br.inf.portalfiscal.nfe.send.TConsCad()));
    }

    @Test
    void testReturnQueryRegister() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsCad xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnQueryRegister(new br.inf.portalfiscal.nfe.send.TRetConsCad()));
    }
}
package org.dfe.components.internal.xml.unmarshaller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DefaultNfUnmarshallerTest {

    @Test
    void testCancelNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().eventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnCancelNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcCancelNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testEventNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().eventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnEventNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcEventNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testSubstituteCancelNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().eventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnSubstituteCancelNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcSubstituteCancelNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testEnviNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().enviNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testInutNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().inutNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><inutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testRetInutNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().retInutNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retInutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcInutNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procInutNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ProcInutNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testQueryReceiptNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().queryReceiptNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testQueryProtocolNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().queryProtocolNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testDistributionNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().distributionNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><distDFeInt xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testManifestationNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().eventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnManifestationNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcManifestationNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }


    @Test
    void testEpecNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().eventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnEpecNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcEpecNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }


    @Test
    void testCorrectionLetterNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().eventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnCorrectionLetterNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcCorrectionLetterNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }


    @Test
    void testInterestedActorNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().eventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnInterestedActorNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testProcInterestedActorNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().procEventNfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }


    @Test
    void testNfe() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().nfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testNfeProc() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().nfeProc("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><nfeProc xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testQueryRegister() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().queryRegister("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ConsCad xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }

    @Test
    void testReturnQueryRegister() {
        assertDoesNotThrow(() -> new DefaultNfUnmarshaller().returnQueryRegister("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsCad xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>"));
    }
}
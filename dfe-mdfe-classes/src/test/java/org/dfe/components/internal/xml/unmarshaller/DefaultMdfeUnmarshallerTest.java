package org.dfe.components.internal.xml.unmarshaller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultMdfeUnmarshallerTest {

    @Test
    void testSendDistribution() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendDistribution("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><distMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testSendEvent() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendEvent("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><eventoMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testSendQueryReceipt() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendQueryReceipt("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consReciMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testSendQuerySituation() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendQuerySituation("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testSendQueryUnclosed() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendQueryUnclosed("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consMDFeNaoEnc xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testSendReception() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendReception("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><enviMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testSendReceptionSync() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendReceptionSync("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><MDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testMdfeProc() {
        assertNotNull(new DefaultMdfeUnmarshaller().mdfeProc("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><mdfeProc xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testSendStatusService() {
        assertNotNull(new DefaultMdfeUnmarshaller().sendStatusService("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consStatServMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testReturnEvent() {
        assertNotNull(new DefaultMdfeUnmarshaller().returnEvent("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEventoMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testProtMdfe() {
        assertNotNull(new DefaultMdfeUnmarshaller().protMdfe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><protMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testEvCancMDFe() {
        assertNotNull(new DefaultMdfeUnmarshaller().evCancMDFe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCancMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testEvAlteracaoPagtoServMDFe() {
        assertNotNull(new DefaultMdfeUnmarshaller().evAlteracaoPagtoServMDFe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evAlteracaoPagtoServMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testEvConfirmaServMDFe() {
        assertNotNull(new DefaultMdfeUnmarshaller().evConfirmaServMDFe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evConfirmaServMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testEvEncMDFe() {
        assertNotNull(new DefaultMdfeUnmarshaller().evEncMDFe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evEncMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testEvIncCondutorMDFe() {
        assertNotNull(new DefaultMdfeUnmarshaller().evIncCondutorMDFe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evIncCondutorMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testEvIncDFeMDFe() {
        assertNotNull(new DefaultMdfeUnmarshaller().evIncDFeMDFe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evIncDFeMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }

    @Test
    void testEvPagtoOperMDFe() {
        assertNotNull(new DefaultMdfeUnmarshaller().evPagtoOperMDFe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evPagtoOperMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>"));
    }
}
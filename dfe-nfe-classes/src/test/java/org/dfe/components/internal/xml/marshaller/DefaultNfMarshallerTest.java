package org.dfe.components.internal.xml.marshaller;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultNfMarshallerTest {

    @Test
    void testCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().eventNfe(new br.inf.portalfiscal.nfe.event_generic.TEnvEvento()));
    }

    @Test
    void testReturnCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().returnEventNfe(new br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento()));
    }

    @Test
    void testProcCancelNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().procEventNfe(new br.inf.portalfiscal.nfe.event_generic.TProcEvento()));
    }

    @Test
    void testEventNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().eventNfe(new br.inf.portalfiscal.nfe.event_generic.TEnvEvento()));
    }

    @Test
    void testReturnEventNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnvEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().returnEventNfe(new br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento()));
    }

    @Test
    void testProcEventNfe() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>",
                new DefaultNfMarshaller().procEventNfe(new br.inf.portalfiscal.nfe.event_generic.TProcEvento()));
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
    void testQueryRegister() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ConsCad xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().queryRegister(new br.inf.portalfiscal.nfe.send.TConsCad()));
    }

    @Test
    void testReturnQueryRegister() {
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsCad xmlns=\"http://www.portalfiscal.inf.br/nfe\"/>", new DefaultNfMarshaller().returnQueryRegister(new br.inf.portalfiscal.nfe.send.TRetConsCad()));
    }
}
package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultMdfeMarshallerTest {

    @Test
    void testRodo() {
        Rodo o = new Rodo();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><rodo xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().rodo(o));
    }

    @Test
    void testAereo() {
        Aereo o = new Aereo();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><aereo xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().aereo(o));
    }

    @Test
    void testFerrov() {
        Ferrov o = new Ferrov();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ferrov xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().ferrov(o));
    }

    @Test
    void testAquav() {
        Aquav o = new Aquav();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><aquav xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().aquav(o));
    }

    @Test
    void testReturnDistribution() {
        TRetDistDFe o = new TRetDistDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retDistMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnDistribution(o));
    }

    @Test
    void testReturnEvent() {
        TRetEvento o = new TRetEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEventoMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnEvent(o));
    }

    @Test
    void testReturnQueryReceipt() {
        TRetConsReciMDFe o = new TRetConsReciMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsReciMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnQueryReceipt(o));
    }

    @Test
    void testReturnQuerySituation() {
        TRetConsSitMDFe o = new TRetConsSitMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsSitMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnQuerySituation(o));
    }

    @Test
    void testReturnQueryUnclosed() {
        TRetConsMDFeNaoEnc o = new TRetConsMDFeNaoEnc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsMDFeNaoEnc xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnQueryUnclosed(o));
    }

    @Test
    void testReturnReception() {
        TRetEnviMDFe o = new TRetEnviMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnviMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnReception(o));
    }

    @Test
    void testReturnReceptionSync() {
        TRetMDFe o = new TRetMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnReceptionSync(o));
    }

    @Test
    void testReturnStatusService() {
        TRetConsStatServ o = new TRetConsStatServ();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsStatServMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().returnStatusService(o));
    }

    @Test
    void testSendDistribution() {
        TDistDFe o = new TDistDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><distMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"><indDFe>0</indDFe><indCompRet>0</indCompRet></distMDFe>", new DefaultMdfeMarshaller().sendDistribution(o));
    }

    @Test
    void testSendEvent() {
        TEvento o = new TEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><eventoMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().sendEvent(o));
    }

    @Test
    void testProcEvent() {
        TProcEvento o = new TProcEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().procEvent(o));
    }

    @Test
    void testSendQueryReceipt() {
        TConsReciMDFe o = new TConsReciMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consReciMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().sendQueryReceipt(o));
    }

    @Test
    void testSendQuerySituation() {
        TConsSitMDFe o = new TConsSitMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().sendQuerySituation(o));
    }

    @Test
    void testSendQueryUnclosed() {
        TConsMDFeNaoEnc o = new TConsMDFeNaoEnc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consMDFeNaoEnc xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().sendQueryUnclosed(o));
    }

    @Test
    void testSendReception() {
        TEnviMDFe o = new TEnviMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><enviMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().sendReception(o));
    }

    @Test
    void testSendReceptionSync() {
        TMDFe o = new TMDFe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><MDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().sendReceptionSync(o));
    }

    @Test
    void testProcMdfe() {
        TMdfeProc o = new TMdfeProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><mdfeProc xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().procMdfe(o));
    }

    @Test
    void testSendStatusService() {
        TConsStatServ o = new TConsStatServ();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consStatServMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\"/>", new DefaultMdfeMarshaller().sendStatusService(o));
    }
}
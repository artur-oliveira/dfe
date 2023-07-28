package com.softart.dfe.components.internal.xml.marshaller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultCteMarshallerTest {

    @Test
    void testToElement() {
        br.inf.portalfiscal.cte.send.EvCancCTe o = new br.inf.portalfiscal.cte.send.EvCancCTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement1() {
        br.inf.portalfiscal.cte.send.RodoOS o = new br.inf.portalfiscal.cte.send.RodoOS();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement2() {
        br.inf.portalfiscal.cte.send.EvCCeCTe o = new br.inf.portalfiscal.cte.send.EvCCeCTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement3() {
        br.inf.portalfiscal.cte.send.EvCECTe o = new br.inf.portalfiscal.cte.send.EvCECTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement4() {
        br.inf.portalfiscal.cte.send.EvCancCECTe o = new br.inf.portalfiscal.cte.send.EvCancCECTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement5() {
        br.inf.portalfiscal.cte.send.EvEPECCTe o = new br.inf.portalfiscal.cte.send.EvEPECCTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement6() {
        br.inf.portalfiscal.cte.send.EvGTV o = new br.inf.portalfiscal.cte.send.EvGTV();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement7() {
        br.inf.portalfiscal.cte.send.EvRegMultimodal o = new br.inf.portalfiscal.cte.send.EvRegMultimodal();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement8() {
        br.inf.portalfiscal.cte.send.EvPrestDesacordo o = new br.inf.portalfiscal.cte.send.EvPrestDesacordo();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement9() {
        br.inf.portalfiscal.cte.send.Rodo o = new br.inf.portalfiscal.cte.send.Rodo();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement10() {
        br.inf.portalfiscal.cte.send.Aereo o = new br.inf.portalfiscal.cte.send.Aereo();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement11() {
        br.inf.portalfiscal.cte.send.Aquav o = new br.inf.portalfiscal.cte.send.Aquav();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement12() {
        br.inf.portalfiscal.cte.send.Duto o = new br.inf.portalfiscal.cte.send.Duto();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement13() {
        br.inf.portalfiscal.cte.send.Ferrov o = new br.inf.portalfiscal.cte.send.Ferrov();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement14() {
        br.inf.portalfiscal.cte.send.Multimodal o = new br.inf.portalfiscal.cte.send.Multimodal();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement15() {
        br.inf.portalfiscal.cte.send400.EvCancCTe o = new br.inf.portalfiscal.cte.send400.EvCancCTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement16() {
        br.inf.portalfiscal.cte.send400.RodoOS o = new br.inf.portalfiscal.cte.send400.RodoOS();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement17() {
        br.inf.portalfiscal.cte.send400.EvCCeCTe o = new br.inf.portalfiscal.cte.send400.EvCCeCTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement18() {
        br.inf.portalfiscal.cte.send400.EvCECTe o = new br.inf.portalfiscal.cte.send400.EvCECTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement19() {
        br.inf.portalfiscal.cte.send400.EvCancCECTe o = new br.inf.portalfiscal.cte.send400.EvCancCECTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement20() {
        br.inf.portalfiscal.cte.send400.EvEPECCTe o = new br.inf.portalfiscal.cte.send400.EvEPECCTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement21() {
        br.inf.portalfiscal.cte.send400.EvGTV o = new br.inf.portalfiscal.cte.send400.EvGTV();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement22() {
        br.inf.portalfiscal.cte.send400.EvRegMultimodal o = new br.inf.portalfiscal.cte.send400.EvRegMultimodal();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement23() {
        br.inf.portalfiscal.cte.send400.EvPrestDesacordo o = new br.inf.portalfiscal.cte.send400.EvPrestDesacordo();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement24() {
        br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo o = new br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement25() {
        br.inf.portalfiscal.cte.send400.EvIECTe o = new br.inf.portalfiscal.cte.send400.EvIECTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement26() {
        br.inf.portalfiscal.cte.send400.EvCancIECTe o = new br.inf.portalfiscal.cte.send400.EvCancIECTe();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement27() {
        br.inf.portalfiscal.cte.send400.Rodo o = new br.inf.portalfiscal.cte.send400.Rodo();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement28() {
        br.inf.portalfiscal.cte.send400.Aereo o = new br.inf.portalfiscal.cte.send400.Aereo();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement29() {
        br.inf.portalfiscal.cte.send400.Aquav o = new br.inf.portalfiscal.cte.send400.Aquav();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement30() {
        br.inf.portalfiscal.cte.send400.Duto o = new br.inf.portalfiscal.cte.send400.Duto();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testToElement31() {
        br.inf.portalfiscal.cte.send400.Ferrov o = new br.inf.portalfiscal.cte.send400.Ferrov();
        assertNotNull(new DefaultCteMarshaller().toElement(o));
    }

    @Test
    void testDistributionCte() {
        br.inf.portalfiscal.cte.distribution.DistDFeInt o = new br.inf.portalfiscal.cte.distribution.DistDFeInt();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><distDFeInt xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().distributionCte(o));
    }

    @Test
    void testReturnDistributionCte() {
        br.inf.portalfiscal.cte.distribution.RetDistDFeInt o = new br.inf.portalfiscal.cte.distribution.RetDistDFeInt();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retDistDFeInt xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnDistributionCte(o));
    }

    @Test
    void testEventCte() {
        br.inf.portalfiscal.cte.send.TEvento o = new br.inf.portalfiscal.cte.send.TEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><eventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().eventCte(o));
    }

    @Test
    void testReturnEventCte() {
        br.inf.portalfiscal.cte.send.TRetEvento o = new br.inf.portalfiscal.cte.send.TRetEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnEventCte(o));
    }

    @Test
    void testProcEventCte() {
        br.inf.portalfiscal.cte.send.TProcEvento o = new br.inf.portalfiscal.cte.send.TProcEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().procEventCte(o));
    }

    @Test
    void testInutilizationCte() {
        br.inf.portalfiscal.cte.send.TInutCTe o = new br.inf.portalfiscal.cte.send.TInutCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><inutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().inutilizationCte(o));
    }

    @Test
    void testReturnInutilizationCte() {
        br.inf.portalfiscal.cte.send.TRetInutCTe o = new br.inf.portalfiscal.cte.send.TRetInutCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retInutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnInutilizationCte(o));
    }

    @Test
    void testProcInutilizationCte() {
        br.inf.portalfiscal.cte.send.TProcInutCTe o = new br.inf.portalfiscal.cte.send.TProcInutCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procInutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().procInutilizationCte(o));
    }

    @Test
    void testQuerySituationCte() {
        br.inf.portalfiscal.cte.send.TConsSitCTe o = new br.inf.portalfiscal.cte.send.TConsSitCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().querySituationCte(o));
    }

    @Test
    void testReturnQuerySituationCte() {
        br.inf.portalfiscal.cte.send.TRetConsSitCTe o = new br.inf.portalfiscal.cte.send.TRetConsSitCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsSitCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnQuerySituationCte(o));
    }

    @Test
    void testReceptionCte() {
        br.inf.portalfiscal.cte.send.TEnviCTe o = new br.inf.portalfiscal.cte.send.TEnviCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><enviCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().receptionCte(o));
    }

    @Test
    void testReturnReceptionCte() {
        br.inf.portalfiscal.cte.send.TRetEnviCTe o = new br.inf.portalfiscal.cte.send.TRetEnviCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEnviCte xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnReceptionCte(o));
    }

    @Test
    void testCteProc() {
        br.inf.portalfiscal.cte.send.TCteProc o = new br.inf.portalfiscal.cte.send.TCteProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cteProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().cteProc(o));
    }

    @Test
    void testReceptionGtve() {
        br.inf.portalfiscal.cte.send.TGTVe o = new br.inf.portalfiscal.cte.send.TGTVe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GTVe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().receptionGtve(o));
    }

    @Test
    void testReturnReceptionGtve() {
        br.inf.portalfiscal.cte.send.TRetGTVe o = new br.inf.portalfiscal.cte.send.TRetGTVe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retGTVe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnReceptionGtve(o));
    }

    @Test
    void testGtveProc() {
        br.inf.portalfiscal.cte.send.TGTVeProc o = new br.inf.portalfiscal.cte.send.TGTVeProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GTVeProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().gtveProc(o));
    }

    @Test
    void testReceptionCteOs() {
        br.inf.portalfiscal.cte.send.TCTeOS o = new br.inf.portalfiscal.cte.send.TCTeOS();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().receptionCteOs(o));
    }

    @Test
    void testReturnReceptionCteOs() {
        br.inf.portalfiscal.cte.send.TRetCTeOS o = new br.inf.portalfiscal.cte.send.TRetCTeOS();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retCTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnReceptionCteOs(o));
    }

    @Test
    void testCteOsProc() {
        br.inf.portalfiscal.cte.send.TCteOSProc o = new br.inf.portalfiscal.cte.send.TCteOSProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cteOSProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().cteOsProc(o));
    }

    @Test
    void testReceptionCteSync() {
        br.inf.portalfiscal.cte.send.TCTe o = new br.inf.portalfiscal.cte.send.TCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().receptionCteSync(o));
    }

    @Test
    void testReturnReceptionCteSync() {
        br.inf.portalfiscal.cte.send.TRetCTe o = new br.inf.portalfiscal.cte.send.TRetCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnReceptionCteSync(o));
    }

    @Test
    void testCteProcSync() {
        br.inf.portalfiscal.cte.send.TCteProc o = new br.inf.portalfiscal.cte.send.TCteProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cteProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().cteProcSync(o));
    }

    @Test
    void testQueryReceipt() {
        br.inf.portalfiscal.cte.send.TConsReciCTe o = new br.inf.portalfiscal.cte.send.TConsReciCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consReciCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().queryReceipt(o));
    }

    @Test
    void testReturnQueryReceipt() {
        br.inf.portalfiscal.cte.send.TRetConsReciCTe o = new br.inf.portalfiscal.cte.send.TRetConsReciCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsReciCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnQueryReceipt(o));
    }

    @Test
    void testStatusService() {
        br.inf.portalfiscal.cte.send.TConsStatServ o = new br.inf.portalfiscal.cte.send.TConsStatServ();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consStatServCte xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().statusService(o));
    }

    @Test
    void testReturnStatusService() {
        br.inf.portalfiscal.cte.send.TRetConsStatServ o = new br.inf.portalfiscal.cte.send.TRetConsStatServ();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsStatServCte xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnStatusService(o));
    }

    @Test
    void testEventCte400() {
        br.inf.portalfiscal.cte.send400.TEvento o = new br.inf.portalfiscal.cte.send400.TEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><eventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().eventCte(o));
    }

    @Test
    void testReturnEventCte400() {
        br.inf.portalfiscal.cte.send400.TRetEvento o = new br.inf.portalfiscal.cte.send400.TRetEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retEventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnEventCte(o));
    }

    @Test
    void testProcEventCte400() {
        br.inf.portalfiscal.cte.send400.TProcEvento o = new br.inf.portalfiscal.cte.send400.TProcEvento();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procEventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().procEventCte(o));
    }

    @Test
    void testInutilizationCte400() {
        br.inf.portalfiscal.cte.send400.TInutCTe o = new br.inf.portalfiscal.cte.send400.TInutCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><inutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().inutilizationCte(o));
    }

    @Test
    void testReturnInutilizationCte400() {
        br.inf.portalfiscal.cte.send400.TRetInutCTe o = new br.inf.portalfiscal.cte.send400.TRetInutCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retInutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnInutilizationCte(o));
    }

    @Test
    void testProcInutilizationCte400() {
        br.inf.portalfiscal.cte.send400.TProcInutCTe o = new br.inf.portalfiscal.cte.send400.TProcInutCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><procInutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().procInutilizationCte(o));
    }

    @Test
    void testQuerySituationCte400() {
        br.inf.portalfiscal.cte.send400.TConsSitCTe o = new br.inf.portalfiscal.cte.send400.TConsSitCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().querySituationCte(o));
    }

    @Test
    void testReturnQuerySituationCte400() {
        br.inf.portalfiscal.cte.send400.TRetConsSitCTe o = new br.inf.portalfiscal.cte.send400.TRetConsSitCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsSitCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnQuerySituationCte(o));
    }

    @Test
    void testCteProc400() {
        br.inf.portalfiscal.cte.send400.TCteProc o = new br.inf.portalfiscal.cte.send400.TCteProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cteProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().cteProc(o));
    }

    @Test
    void testReceptionGtve400() {
        br.inf.portalfiscal.cte.send400.TGTVe o = new br.inf.portalfiscal.cte.send400.TGTVe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GTVe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().receptionGtve(o));
    }

    @Test
    void testReturnReceptionGtve400() {
        br.inf.portalfiscal.cte.send400.TRetGTVe o = new br.inf.portalfiscal.cte.send400.TRetGTVe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retGTVe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnReceptionGtve(o));
    }

    @Test
    void testGtveProc400() {
        br.inf.portalfiscal.cte.send400.TGTVeProc o = new br.inf.portalfiscal.cte.send400.TGTVeProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GTVeProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().gtveProc(o));
    }

    @Test
    void testReceptionCteOs400() {
        br.inf.portalfiscal.cte.send400.TCTeOS o = new br.inf.portalfiscal.cte.send400.TCTeOS();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().receptionCteOs(o));
    }

    @Test
    void testReturnReceptionCteOs400() {
        br.inf.portalfiscal.cte.send400.TRetCTeOS o = new br.inf.portalfiscal.cte.send400.TRetCTeOS();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retCTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnReceptionCteOs(o));
    }

    @Test
    void testCteOsProc400() {
        br.inf.portalfiscal.cte.send400.TCteOSProc o = new br.inf.portalfiscal.cte.send400.TCteOSProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cteOSProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().cteOsProc(o));
    }

    @Test
    void testReceptionCteSync400() {
        br.inf.portalfiscal.cte.send400.TCTe o = new br.inf.portalfiscal.cte.send400.TCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().receptionCteSync(o));
    }

    @Test
    void testReturnReceptionCteSync400() {
        br.inf.portalfiscal.cte.send400.TRetCTe o = new br.inf.portalfiscal.cte.send400.TRetCTe();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnReceptionCteSync(o));
    }

    @Test
    void testCteProcSync400() {
        br.inf.portalfiscal.cte.send400.TCteProc o = new br.inf.portalfiscal.cte.send400.TCteProc();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cteProc xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().cteProcSync(o));
    }

    @Test
    void testStatusService400() {
        br.inf.portalfiscal.cte.send400.TConsStatServ o = new br.inf.portalfiscal.cte.send400.TConsStatServ();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consStatServCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().statusService(o));
    }

    @Test
    void testReturnStatusService400() {
        br.inf.portalfiscal.cte.send400.TRetConsStatServ o = new br.inf.portalfiscal.cte.send400.TRetConsStatServ();
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retConsStatServCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>", new DefaultCteMarshaller().returnStatusService(o));
    }
}
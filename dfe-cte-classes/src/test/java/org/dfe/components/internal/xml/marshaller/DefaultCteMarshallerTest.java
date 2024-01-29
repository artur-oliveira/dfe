package org.dfe.components.internal.xml.marshaller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultCteMarshallerTest {

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
package com.softart.dfe.components.internal.xml.unmarshaller;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultCteUnmarshallerTest {

    @Test
    void testDistributionCte() {
        JAXBElement<br.inf.portalfiscal.cte.distribution.DistDFeInt> o = new DefaultCteUnmarshaller().distributionCte("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><distDFeInt xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testReturnDistributionCte() {
        JAXBElement<br.inf.portalfiscal.cte.distribution.RetDistDFeInt> o = new DefaultCteUnmarshaller().returnDistributionCte("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><retDistDFeInt xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testEnviCte() {
        JAXBElement<br.inf.portalfiscal.cte.send.TEnviCTe> o = new DefaultCteUnmarshaller().enviCte("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><enviCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }


    @Test
    void testEventCte() {
        JAXBElement<br.inf.portalfiscal.cte.send.TEvento> o = new DefaultCteUnmarshaller().eventCte("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><eventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testInutCte() {
        JAXBElement<br.inf.portalfiscal.cte.send.TInutCTe> o = new DefaultCteUnmarshaller().inutCte("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><inutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testQuerySituationCte() {
        JAXBElement<br.inf.portalfiscal.cte.send.TConsSitCTe> o = new DefaultCteUnmarshaller().querySituationCte("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testReceptionCte() {
        JAXBElement<br.inf.portalfiscal.cte.send.TEnviCTe> o = new DefaultCteUnmarshaller().receptionCte("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><enviCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testReceptionGtve() {
        JAXBElement<br.inf.portalfiscal.cte.send.TGTVe> o = new DefaultCteUnmarshaller().receptionGtve("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GTVe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testReceptionCteOs() {
        JAXBElement<br.inf.portalfiscal.cte.send.TCTeOS> o = new DefaultCteUnmarshaller().receptionCteOs("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testReceptionCteSync() {
        JAXBElement<br.inf.portalfiscal.cte.send.TCTe> o = new DefaultCteUnmarshaller().receptionCteSync("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testQueryReceipt() {
        JAXBElement<br.inf.portalfiscal.cte.send.TConsReciCTe> o = new DefaultCteUnmarshaller().queryReceipt("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consReciCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testStatusService() {
        JAXBElement<br.inf.portalfiscal.cte.send.TConsStatServ> o = new DefaultCteUnmarshaller().statusService("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consStatServCte xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testProtCTe() {
        JAXBElement<br.inf.portalfiscal.cte.send.TProtCTe> o = new DefaultCteUnmarshaller().protCTe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><protCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(o);
        assertNotNull(o.getValue());
    }

    @Test
    void testAny300() throws JAXBException {
        JAXBElement<?> rodo = new DefaultCteUnmarshaller().any300(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.Rodo()));
        assertNotNull(rodo);
        assertTrue(rodo.getValue() instanceof br.inf.portalfiscal.cte.send.Rodo);
        JAXBElement<?> rodoos = new DefaultCteUnmarshaller().any300(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.RodoOS()));
        assertNotNull(rodoos);
        assertTrue(rodoos.getValue() instanceof br.inf.portalfiscal.cte.send.RodoOS);
        JAXBElement<?> duto = new DefaultCteUnmarshaller().any300(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.Duto()));
        assertNotNull(duto);
        assertTrue(duto.getValue() instanceof br.inf.portalfiscal.cte.send.Duto);
        JAXBElement<?> aquav = new DefaultCteUnmarshaller().any300(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.Aquav()));
        assertNotNull(aquav);
        assertTrue(aquav.getValue() instanceof br.inf.portalfiscal.cte.send.Aquav);
        JAXBElement<?> aereo = new DefaultCteUnmarshaller().any300(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.Aereo()));
        assertNotNull(aereo);
        assertTrue(aereo.getValue() instanceof br.inf.portalfiscal.cte.send.Aereo);
        JAXBElement<?> ferrov = new DefaultCteUnmarshaller().any300(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.Ferrov()));
        assertNotNull(ferrov);
        assertTrue(ferrov.getValue() instanceof br.inf.portalfiscal.cte.send.Ferrov);
        JAXBElement<?> multimodal = new DefaultCteUnmarshaller().any300(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.Multimodal()));
        assertNotNull(multimodal);
        assertTrue(multimodal.getValue() instanceof br.inf.portalfiscal.cte.send.Multimodal);
    }

    @Test
    void testEvCancCTe() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCancCTe(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvCancCTe())));
    }

    @Test
    void testEvCancCECTe() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCancCECTe(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvCancCECTe())));
    }

    @Test
    void testEvCCeCTe() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCCeCTe(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvCCeCTe())));
    }

    @Test
    void testEvCECTe() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCECTe(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvCECTe())));
    }

    @Test
    void testEvEPECCTe() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evEPECCTe(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvEPECCTe())));
    }

    @Test
    void testEvGTV() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evGTV(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvGTV())));
    }

    @Test
    void testEvPrestDesacordo() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evPrestDesacordo(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvPrestDesacordo())));
    }

    @Test
    void testEvRegMultimodal() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evRegMultimodal(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send.EvRegMultimodal())));
    }

    @Test
    void testToElement() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvCancCTe o = new br.inf.portalfiscal.cte.send.EvCancCTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement1() throws JAXBException {
        br.inf.portalfiscal.cte.send.RodoOS o = new br.inf.portalfiscal.cte.send.RodoOS();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement2() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvCCeCTe o = new br.inf.portalfiscal.cte.send.EvCCeCTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement3() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvCECTe o = new br.inf.portalfiscal.cte.send.EvCECTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement4() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvCancCECTe o = new br.inf.portalfiscal.cte.send.EvCancCECTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement5() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvEPECCTe o = new br.inf.portalfiscal.cte.send.EvEPECCTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement6() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvGTV o = new br.inf.portalfiscal.cte.send.EvGTV();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement7() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvRegMultimodal o = new br.inf.portalfiscal.cte.send.EvRegMultimodal();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement8() throws JAXBException {
        br.inf.portalfiscal.cte.send.EvPrestDesacordo o = new br.inf.portalfiscal.cte.send.EvPrestDesacordo();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement9() throws JAXBException {
        br.inf.portalfiscal.cte.send.Rodo o = new br.inf.portalfiscal.cte.send.Rodo();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement10() throws JAXBException {
        br.inf.portalfiscal.cte.send.Aereo o = new br.inf.portalfiscal.cte.send.Aereo();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement11() throws JAXBException {
        br.inf.portalfiscal.cte.send.Aquav o = new br.inf.portalfiscal.cte.send.Aquav();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement12() throws JAXBException {
        br.inf.portalfiscal.cte.send.Duto o = new br.inf.portalfiscal.cte.send.Duto();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement13() throws JAXBException {
        br.inf.portalfiscal.cte.send.Ferrov o = new br.inf.portalfiscal.cte.send.Ferrov();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testEventCte400() {
        assertNotNull(new DefaultCteUnmarshaller().eventCte400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><eventoCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testInutCte400() {
        assertNotNull(new DefaultCteUnmarshaller().inutCte400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><inutCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testQuerySituationCte400() {
        assertNotNull(new DefaultCteUnmarshaller().querySituationCte400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consSitCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testReceptionGtve400() {
        assertNotNull(new DefaultCteUnmarshaller().receptionGtve400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GTVe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testReceptionCteOs400() {
        assertNotNull(new DefaultCteUnmarshaller().receptionCteOs400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testReceptionCteSync400() {
        assertNotNull(new DefaultCteUnmarshaller().receptionCteSync400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testStatusService400() {
        assertNotNull(new DefaultCteUnmarshaller().statusService400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><consStatServCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testProtCTe400() {
        assertNotNull(new DefaultCteUnmarshaller().protCTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><protCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testAny400() throws JAXBException {
        JAXBElement<?> rodo = new DefaultCteUnmarshaller().any400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.Rodo()));
        assertNotNull(rodo);
        assertTrue(rodo.getValue() instanceof br.inf.portalfiscal.cte.send400.Rodo);
        JAXBElement<?> rodoos = new DefaultCteUnmarshaller().any400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.RodoOS()));
        assertNotNull(rodoos);
        assertTrue(rodoos.getValue() instanceof br.inf.portalfiscal.cte.send400.RodoOS);
        JAXBElement<?> duto = new DefaultCteUnmarshaller().any400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.Duto()));
        assertNotNull(duto);
        assertTrue(duto.getValue() instanceof br.inf.portalfiscal.cte.send400.Duto);
        JAXBElement<?> aquav = new DefaultCteUnmarshaller().any400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.Aquav()));
        assertNotNull(aquav);
        assertTrue(aquav.getValue() instanceof br.inf.portalfiscal.cte.send400.Aquav);
        JAXBElement<?> aereo = new DefaultCteUnmarshaller().any400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.Aereo()));
        assertNotNull(aereo);
        assertTrue(aereo.getValue() instanceof br.inf.portalfiscal.cte.send400.Aereo);
        JAXBElement<?> ferrov = new DefaultCteUnmarshaller().any400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.Ferrov()));
        assertNotNull(ferrov);
        assertTrue(ferrov.getValue() instanceof br.inf.portalfiscal.cte.send400.Ferrov);
        JAXBElement<?> multimodal = new DefaultCteUnmarshaller().any400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.Multimodal()));
        assertNotNull(multimodal);
        assertTrue(multimodal.getValue() instanceof br.inf.portalfiscal.cte.send400.Multimodal);
    }

    @Test
    void testEvCancCTe400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCancCTe400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvCancCTe())));
    }

    @Test
    void testEvCancCECTe400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCancCECTe400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvCancCECTe())));
    }

    @Test
    void testEvCCeCTe400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCCeCTe400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvCCeCTe())));
    }

    @Test
    void testEvCECTe400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCECTe400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvCECTe())));
    }

    @Test
    void testEvEPECCTe400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evEPECCTe400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvEPECCTe())));
    }

    @Test
    void testEvGTV400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evGTV400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvGTV())));
    }

    @Test
    void testEvPrestDesacordo400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evPrestDesacordo400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvPrestDesacordo())));
    }

    @Test
    void testEvCancPrestDesacordo400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCancPrestDesacordo400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo())));
    }

    @Test
    void testEvIECTe400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evIECTe400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvIECTe())));
    }

    @Test
    void testEvCancIECTe400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evCancIECTe400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvCancIECTe())));
    }

    @Test
    void testEvRegMultimodal400() throws JAXBException {
        assertNotNull(new DefaultCteUnmarshaller().evRegMultimodal400(new DefaultCteUnmarshaller().toElement(new br.inf.portalfiscal.cte.send400.EvRegMultimodal())));
    }

    @Test
    void testToElement14() throws JAXBException {
        br.inf.portalfiscal.cte.send.Multimodal o = new br.inf.portalfiscal.cte.send.Multimodal();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement15() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvCancCTe o = new br.inf.portalfiscal.cte.send400.EvCancCTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement16() throws JAXBException {
        br.inf.portalfiscal.cte.send400.RodoOS o = new br.inf.portalfiscal.cte.send400.RodoOS();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement17() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvCCeCTe o = new br.inf.portalfiscal.cte.send400.EvCCeCTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement18() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvCECTe o = new br.inf.portalfiscal.cte.send400.EvCECTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement19() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvCancCECTe o = new br.inf.portalfiscal.cte.send400.EvCancCECTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement20() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvEPECCTe o = new br.inf.portalfiscal.cte.send400.EvEPECCTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement21() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvGTV o = new br.inf.portalfiscal.cte.send400.EvGTV();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement22() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvRegMultimodal o = new br.inf.portalfiscal.cte.send400.EvRegMultimodal();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement23() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvPrestDesacordo o = new br.inf.portalfiscal.cte.send400.EvPrestDesacordo();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement24() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo o = new br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement25() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvIECTe o = new br.inf.portalfiscal.cte.send400.EvIECTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement26() throws JAXBException {
        br.inf.portalfiscal.cte.send400.EvCancIECTe o = new br.inf.portalfiscal.cte.send400.EvCancIECTe();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement27() throws JAXBException {
        br.inf.portalfiscal.cte.send400.Rodo o = new br.inf.portalfiscal.cte.send400.Rodo();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement28() throws JAXBException {
        br.inf.portalfiscal.cte.send400.Aereo o = new br.inf.portalfiscal.cte.send400.Aereo();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement29() throws JAXBException {
        br.inf.portalfiscal.cte.send400.Aquav o = new br.inf.portalfiscal.cte.send400.Aquav();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement30() throws JAXBException {
        br.inf.portalfiscal.cte.send400.Duto o = new br.inf.portalfiscal.cte.send400.Duto();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testToElement31() throws JAXBException {
        br.inf.portalfiscal.cte.send400.Ferrov o = new br.inf.portalfiscal.cte.send400.Ferrov();
        assertNotNull(new DefaultCteUnmarshaller().toElement(o));
    }

    @Test
    void testProtCTeOS400() {
        assertNotNull(new DefaultCteUnmarshaller().protCTeOS400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><protCTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testProtGTVe400() {
        assertNotNull(new DefaultCteUnmarshaller().protGTVe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><protGTVe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }
}
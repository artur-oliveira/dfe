package org.dfe.components.internal.xml.unmarshaller;

import jakarta.xml.bind.JAXBElement;
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
    void testEvCancCTe() {
        assertNotNull(new DefaultCteUnmarshaller().evCancCTe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCancCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCancCECTe() {
        assertNotNull(new DefaultCteUnmarshaller().evCancCECTe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCancCECTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCCeCTe() {
        assertNotNull(new DefaultCteUnmarshaller().evCCeCTe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCCeCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCECTe() {
        assertNotNull(new DefaultCteUnmarshaller().evCECTe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCECTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvEPECCTe() {
        assertNotNull(new DefaultCteUnmarshaller().evEPECCTe("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evEPECCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvGTV() {
        assertNotNull(new DefaultCteUnmarshaller().evGTV("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evGTV xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvPrestDesacordo() {
        assertNotNull(new DefaultCteUnmarshaller().evPrestDesacordo("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evPrestDesacordo xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvRegMultimodal() {
        assertNotNull(new DefaultCteUnmarshaller().evRegMultimodal("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evRegMultimodal xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
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
    void testAny400() {
        JAXBElement<?> rodo = new DefaultCteUnmarshaller().any400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><rodo xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(rodo);
        assertTrue(rodo.getValue() instanceof br.inf.portalfiscal.cte.send400.Rodo);
        JAXBElement<?> rodoos = new DefaultCteUnmarshaller().any400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><rodoOS xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(rodoos);
        assertTrue(rodoos.getValue() instanceof br.inf.portalfiscal.cte.send400.RodoOS);
        JAXBElement<?> duto = new DefaultCteUnmarshaller().any400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><duto xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(duto);
        assertTrue(duto.getValue() instanceof br.inf.portalfiscal.cte.send400.Duto);
        JAXBElement<?> aquav = new DefaultCteUnmarshaller().any400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><aquav xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(aquav);
        assertTrue(aquav.getValue() instanceof br.inf.portalfiscal.cte.send400.Aquav);
        JAXBElement<?> aereo = new DefaultCteUnmarshaller().any400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><aereo xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(aereo);
        assertTrue(aereo.getValue() instanceof br.inf.portalfiscal.cte.send400.Aereo);
        JAXBElement<?> ferrov = new DefaultCteUnmarshaller().any400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ferrov xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(ferrov);
        assertTrue(ferrov.getValue() instanceof br.inf.portalfiscal.cte.send400.Ferrov);
        JAXBElement<?> multimodal = new DefaultCteUnmarshaller().any400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><multimodal xmlns=\"http://www.portalfiscal.inf.br/cte\"/>");
        assertNotNull(multimodal);
        assertTrue(multimodal.getValue() instanceof br.inf.portalfiscal.cte.send400.Multimodal);
    }

    @Test
    void testEvCancCTe400() {
        assertNotNull(new DefaultCteUnmarshaller().evCancCTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCancCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCancCECTe400() {
        assertNotNull(new DefaultCteUnmarshaller().evCancCECTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCancCECTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCCeCTe400() {
        assertNotNull(new DefaultCteUnmarshaller().evCCeCTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCCeCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCECTe400() {
        assertNotNull(new DefaultCteUnmarshaller().evCECTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCECTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvEPECCTe400() {
        assertNotNull(new DefaultCteUnmarshaller().evEPECCTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evEPECCTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvGTV400() {
        assertNotNull(new DefaultCteUnmarshaller().evGTV400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evGTV xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvPrestDesacordo400() {
        assertNotNull(new DefaultCteUnmarshaller().evPrestDesacordo400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evPrestDesacordo xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCancPrestDesacordo400() {
        assertNotNull(new DefaultCteUnmarshaller().evCancPrestDesacordo400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCancPrestDesacordo xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvIECTe400() {
        assertNotNull(new DefaultCteUnmarshaller().evIECTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evIECTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvCancIECTe400() {
        assertNotNull(new DefaultCteUnmarshaller().evCancIECTe400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evCancIECTe xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
    }

    @Test
    void testEvRegMultimodal400() {
        assertNotNull(new DefaultCteUnmarshaller().evRegMultimodal400("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><evRegMultimodal xmlns=\"http://www.portalfiscal.inf.br/cte\"/>"));
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
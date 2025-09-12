package org.dfe.models.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.models.nf.event.DetCancelEvent;
import org.dfe.models.nf.event.NfEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NfEventTest {

    @Test
    @DisplayName("Test NfeCancel: Should convert object into Jaxb Element and reverse")
    void testNfeConvertToJaxbElement() {
        NfEvent cancel = NfEvent
                .builder()
                .infEvento(NfEvent
                        .InfEvento
                        .builder()
                        .chNFe("99999999999999999999999999999999999999999999")
                        .cOrgao("99")
                        .tpAmb("9")
                        .cnpj("99999999999999")
                        .dhEvento("2025-09-11T11:27:58-03:00")
                        .tpEvento("110111")
                        .nSeqEvento("1")
                        .detEvento(DetCancelEvent
                                .builder()
                                .xJust("Test Cancel Nfe object")
                                .nProt("322250000038360")
                                .build())
                        .build())
                .build();

        TEvento event = cancel.toObject();
        TEnvEvento envEvento = new TEnvEvento();
        envEvento.getEvento().add(event);
        envEvento.setIdLote("123456789");
        envEvento.setVersao("1.00");

        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.00\"><idLote>123456789</idLote><evento versao=\"1.00\"><infEvento Id=\"ID1101119999999999999999999999999999999999999999999901\"><cOrgao>99</cOrgao><tpAmb>9</tpAmb><CNPJ>99999999999999</CNPJ><chNFe>99999999999999999999999999999999999999999999</chNFe><dhEvento>2025-09-11T11:27:58-03:00</dhEvento><tpEvento>110111</tpEvento><nSeqEvento>1</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Cancelamento</descEvento><nProt>322250000038360</nProt><xJust>Test Cancel Nfe object</xJust></detEvento></infEvento></evento></envEvento>";
        Assertions.assertEquals(expectedXml, NfMarshallerFactory.getInstance().eventNfe(envEvento));

        NfEvent sameObjectReverser = new NfEvent().fromObject(event);

        Assertions.assertNotNull(sameObjectReverser.getInfEvento());
        Assertions.assertNotNull(sameObjectReverser.getInfEvento().getDetEvento());
        Assertions.assertEquals("1.00", sameObjectReverser.getVersao());
        Assertions.assertEquals("Cancelamento", ((DetCancelEvent) sameObjectReverser.getInfEvento().getDetEvento()).getDescEvento());
        Assertions.assertEquals("322250000038360", ((DetCancelEvent) sameObjectReverser.getInfEvento().getDetEvento()).getNProt());
        Assertions.assertEquals("Test Cancel Nfe object", ((DetCancelEvent) sameObjectReverser.getInfEvento().getDetEvento()).getXJust());


        NfEvent unmarshallerObject = new NfEvent().fromObject(NfUnmarshallerFactory.getInstance().eventNfe(expectedXml).getValue().getEvento().getFirst());

        Assertions.assertNotNull(unmarshallerObject.getInfEvento());
        Assertions.assertNotNull(unmarshallerObject.getInfEvento().getDetEvento());
        Assertions.assertEquals("1.00", unmarshallerObject.getVersao());
        Assertions.assertEquals("Cancelamento", ((DetCancelEvent) unmarshallerObject.getInfEvento().getDetEvento()).getDescEvento());
        Assertions.assertEquals("322250000038360", ((DetCancelEvent) unmarshallerObject.getInfEvento().getDetEvento()).getNProt());
        Assertions.assertEquals("Test Cancel Nfe object", ((DetCancelEvent) unmarshallerObject.getInfEvento().getDetEvento()).getXJust());


    }

}

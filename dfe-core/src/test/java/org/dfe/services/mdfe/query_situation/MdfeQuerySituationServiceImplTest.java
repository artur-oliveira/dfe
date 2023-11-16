package org.dfe.services.mdfe.query_situation;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxMdfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.mdfe.MdfeEvent;
import org.dfe.exceptions.xml.XSDValidationException;
import org.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MdfeQuerySituationServiceImplTest {
    MdfeQuerySituationService service = new MdfeQuerySituationServiceImpl(
            new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    MdfeQuerySituationServiceImplTest() throws Exception {
        System.setProperty("org.dfe.handler.log.request", "true");
        System.setProperty("org.dfe.handler.log.response", "true");
    }

    @Test
    void testQuerySituationWithInvalidAccessKey() throws Exception {
        Collection<String> invalids = List.of("1", "22", "333");
        for (String invalid : invalids) {
            XSDValidationException ex = assertThrows(XSDValidationException.class, () -> service.querySituation(invalid));
        }


    }

    @Test
    void testQuerySituationWithAccessKeyDoesNotExistsWithInvalidDigitAndEnvironmentIsDefault() throws Exception {

        MdfeReturnQuerySituation querySituation = service.querySituation("99999999999999999999999999999999999999999999");
        assertNotNull(querySituation);
        assertEquals(service.getConfig().environment().getCode(), querySituation.getTpAmb());
        assertEquals("99", querySituation.getCuf());
    }

    @Test
    void testQuerySituationWithAccessKeyDoesNotExistsWithInvalidDigitAndEnvironmentIsNotDefault() throws Exception {

        MdfeReturnQuerySituation querySituation = service.querySituation("99999999999999999999999999999999999999999999", Environment.PRODUCTION);
        assertNotNull(querySituation);
        assertEquals("1", querySituation.getTpAmb());
        assertEquals("99", querySituation.getCuf());
    }

    @Test
    void testQuerySituationWithAccessKeyExistsAndHomologation() throws Exception {

        MdfeReturnQuerySituation querySituation = service.querySituation("22230511520224000140580010000007211035974624");
        assertNotNull(querySituation);
        assertNotNull(querySituation.getProtMDFe());
        assertEquals("2", querySituation.getTpAmb());
        assertEquals("22", querySituation.getCuf());

    }

    @Test
    void testQuerySituationWithAccessKeyExistsWithIncorrectEnvironment() throws Exception {

        MdfeReturnQuerySituation querySituation = service.querySituation("22230511520224000140580010000007211035974624", Environment.PRODUCTION);
        assertNotNull(querySituation);
        assertEquals("1", querySituation.getTpAmb());
        assertEquals("22", querySituation.getCuf());
        assertEquals("217", querySituation.getCStat());
        assertEquals("Rejeição: MDF-e não consta na base de dados da SEFAZ", querySituation.getXMotivo());

    }

    @Test
    void testQuerySituationWithAccessKeyExistsAndProduction() throws Exception {

        MdfeReturnQuerySituation querySituation = service.querySituation("22230273815060000136580010000005551532933651", Environment.PRODUCTION);
        assertNotNull(querySituation);
        assertNotNull(querySituation.getProtMDFe());
        assertEquals("1", querySituation.getTpAmb());
        assertEquals("22", querySituation.getCuf());

    }

    @Test
    void testGetLastSequenceNumber() throws Exception {
        assertEquals(1L, service.getLastSequenceNumber("22230511520224000140580010000007211035974624", MdfeEvent.CANCEL));
        assertEquals(2L, service.getLastSequenceNumber("22230511520224000140580010000007211035974624", MdfeEvent.CLOSE));
    }


    @Test
    void testGetLastSequenceNumberWithEventAsString() throws Exception {
        assertEquals(1L, service.getLastSequenceNumber("22230511520224000140580010000007211035974624", "110111"));
        assertEquals(2L, service.getLastSequenceNumber("22230511520224000140580010000007211035974624", "110112"));
    }


    @Test
    void testGetLastSequenceNumberAsString() throws Exception {
        assertEquals("1", service.getLastSequenceNumberAsString("22230511520224000140580010000007211035974624", MdfeEvent.CANCEL));
        assertEquals("2", service.getLastSequenceNumberAsString("22230511520224000140580010000007211035974624", MdfeEvent.CLOSE));
    }


    @Test
    void testGetLastSequenceNumberAsStringWithEventAsString() throws Exception {
        assertEquals("1", service.getLastSequenceNumberAsString("22230511520224000140580010000007211035974624", "110111"));
        assertEquals("2", service.getLastSequenceNumberAsString("22230511520224000140580010000007211035974624", "110112"));
    }
}
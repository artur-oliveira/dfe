package com.softart.dfe.services.mdfe.query_receipt;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.xml.XSDValidationException;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.models.mdfe.query_receipt.MdfeReturnQueryReceipt;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MdfeQueryReceiptServiceImplTest {

    MdfeConfig config = new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance());

    MdfeQueryReceiptServiceImplTest() throws Exception {
        System.setProperty("com.softart.dfe.handler.log.request", "true");
        System.setProperty("com.softart.dfe.handler.log.response", "true");
    }

    @Test
    void testQueryReceiptWithInvalidReceipts() throws Exception {
        Collection<String> invalidReceipts = List.of("9", "99", "999", "999");

        MdfeQueryReceiptServiceImpl service = new MdfeQueryReceiptServiceImpl(
                config
        );

        for (String invalidReceipt : invalidReceipts) {
            XSDValidationException ex = assertThrows(XSDValidationException.class, () -> service.queryReceipt(invalidReceipt));
            assertTrue(ex.getMessage().endsWith("cvc-pattern-valid: Value '" + invalidReceipt + "' is not facet-valid with respect to pattern '[0-9]{15}' for type 'TRec'."));
        }
    }


    @Test
    void testQueryReceiptWithOnlyReceipt() throws Exception {
        MdfeReturnQueryReceipt returnQueryReceipt = new MdfeQueryReceiptServiceImpl(
                config
        ).queryReceipt("999999999999999");

        assertNotNull(returnQueryReceipt);
        assertEquals(returnQueryReceipt.getCuf(), "99");
        assertEquals(returnQueryReceipt.getNRec(), "999999999999999");
        assertEquals(config.environment().getCode(), returnQueryReceipt.getTpAmb());
        assertEquals(returnQueryReceipt.getCStat(), "106");
        assertEquals(returnQueryReceipt.getXMotivo(), "Arquivo nao localizado");
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsProduction() throws Exception {
        MdfeReturnQueryReceipt returnQueryReceipt = new MdfeQueryReceiptServiceImpl(
                config
        ).queryReceipt("999999999999999", Environment.PRODUCTION);

        assertNotNull(returnQueryReceipt);
        assertEquals(returnQueryReceipt.getCuf(), "99");
        assertEquals(returnQueryReceipt.getNRec(), "999999999999999");
        assertEquals(returnQueryReceipt.getTpAmb(), "1");
        assertEquals(returnQueryReceipt.getCStat(), "106");
        assertEquals(returnQueryReceipt.getXMotivo(), "Arquivo nao localizado");
    }

    @Test
    void testQueryReceiptWithReceiptAndEnvironmentIsHomologation() throws Exception {
        MdfeReturnQueryReceipt returnQueryReceipt = new MdfeQueryReceiptServiceImpl(
                config
        ).queryReceipt("999999999999999", Environment.HOMOLOGATION);

        assertNotNull(returnQueryReceipt);
        assertEquals(returnQueryReceipt.getCuf(), "99");
        assertEquals(returnQueryReceipt.getNRec(), "999999999999999");
        assertEquals(returnQueryReceipt.getTpAmb(), "2");
        assertEquals(returnQueryReceipt.getCStat(), "106");
        assertEquals(returnQueryReceipt.getXMotivo(), "Arquivo nao localizado");
    }
}
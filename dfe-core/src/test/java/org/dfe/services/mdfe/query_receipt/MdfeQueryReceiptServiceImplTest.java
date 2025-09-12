package org.dfe.services.mdfe.query_receipt;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxMdfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.xml.XSDValidationException;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MdfeQueryReceiptServiceImplTest {

    MdfeConfig config = new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance());

    MdfeQueryReceiptServiceImplTest() throws Exception {
        System.setProperty("org.dfe.handler.log.request", "true");
        System.setProperty("org.dfe.handler.log.response", "true");
    }

    @Test
    void testQueryReceiptWithInvalidReceipts() throws Exception {
        Collection<String> invalidReceipts = List.of("9", "99", "999", "999");

        MdfeQueryReceiptServiceImpl service = new MdfeQueryReceiptServiceImpl(
                config
        );

        for (String invalidReceipt : invalidReceipts) {
            XSDValidationException ex = assertThrows(XSDValidationException.class, () -> service.queryReceipt(invalidReceipt));
        }
    }

}
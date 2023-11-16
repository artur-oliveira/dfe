package org.dfe.services.nf.query_gtin;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.query_gtin.ReturnQueryGtinNf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfQueryGtinServiceImplTest {
    @Test
    void testQueryGtin() throws Exception {
        NfQueryGtinService service = new NfQueryGtinServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );

        ReturnQueryGtinNf o = service.queryGtin("7894900530001");
        assertNotNull(o);
    }
}
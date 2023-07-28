package com.softart.dfe.services.nf.query_gtin;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.query_gtin.ReturnQueryGtinNf;
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
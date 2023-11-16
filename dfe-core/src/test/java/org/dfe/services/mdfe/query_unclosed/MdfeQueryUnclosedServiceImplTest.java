package org.dfe.services.mdfe.query_unclosed;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxMdfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.models.mdfe.query_unclosed.MdfeReturnQueryUnclosed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeQueryUnclosedServiceImplTest {

    MdfeQueryUnclosedService service = new MdfeQueryUnclosedServiceImpl(
            new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    MdfeQueryUnclosedServiceImplTest() throws Exception {
        System.setProperty("org.dfe.handler.log.request", "true");
        System.setProperty("org.dfe.handler.log.response", "true");
    }


    @Test
    void queryUnclosedWithDefaultEnvironment() throws Exception {
        MdfeReturnQueryUnclosed o = service.queryUnclosed();
        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void queryUnclosedWithOtherEnvironment() throws Exception {
        MdfeReturnQueryUnclosed o = service.queryUnclosed(Environment.PRODUCTION);
        assertNotNull(o);
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }
}
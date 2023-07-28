package com.softart.dfe.services.mdfe.query_unclosed;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.mdfe.query_unclosed.MdfeReturnQueryUnclosed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeQueryUnclosedServiceImplTest {

    MdfeQueryUnclosedService service = new MdfeQueryUnclosedServiceImpl(
            new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    MdfeQueryUnclosedServiceImplTest() throws Exception {
        System.setProperty("com.softart.dfe.handler.log.request", "true");
        System.setProperty("com.softart.dfe.handler.log.response", "true");
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
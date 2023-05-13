package com.softart.dfe.services.mdfe.status_service;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.security.CertificateException;
import com.softart.dfe.exceptions.security.SSLContextException;
import com.softart.dfe.models.mdfe.status_service.MdfeReturnStatusService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeStatusServiceServiceImplTest {
    MdfeStatusServiceService service = new MdfeStatusServiceServiceImpl(
            new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    MdfeStatusServiceServiceImplTest() throws SSLContextException, CertificateException {
        System.setProperty("com.softart.dfe.handler.log.request", "true");
        System.setProperty("com.softart.dfe.handler.log.response", "true");
    }


    @Test
    void testStatusServiceWithDefaultEnvironmentAndUf() throws Exception {
        MdfeReturnStatusService o = service.statusService();

        assertNotNull(o);
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testStatusServiceWithEnvironmentProduction() throws Exception {
        MdfeReturnStatusService o = service.statusService(Environment.PRODUCTION);

        assertNotNull(o);
        assertEquals(Environment.PRODUCTION.getCode(), o.getTpAmb());
    }
}
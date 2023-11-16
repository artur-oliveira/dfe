package org.dfe.services.mdfe.status_service;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxMdfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.security.CertificateException;
import org.dfe.exceptions.security.SSLContextException;
import org.dfe.models.mdfe.status_service.MdfeReturnStatusService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeStatusServiceServiceImplTest {
    MdfeStatusServiceService service = new MdfeStatusServiceServiceImpl(
            new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    MdfeStatusServiceServiceImplTest() throws SSLContextException, CertificateException {
        System.setProperty("org.dfe.handler.log.request", "true");
        System.setProperty("org.dfe.handler.log.response", "true");
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
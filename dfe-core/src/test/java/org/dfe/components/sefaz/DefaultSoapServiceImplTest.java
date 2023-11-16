package org.dfe.components.sefaz;

import org.dfe.components.sefaz.port.nfe.impl.NfeSvcanSoapService;
import org.dfe.components.sefaz.port.nfe.impl.NfeSvrsSoapService;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultSoapServiceImplTest {

    @Test
    void getNfeSoapService() throws Exception {
        for (UF uf : NfeAuthorizer.SVRS.allowedUfsHomologation()) {
            assertEquals(NfeSvrsSoapService.class, new DefaultSoapServiceImpl().getNfeSoapService(uf, Environment.PRODUCTION, NFEmissionType.NORMAL).getClass());
        }
        for (UF uf : NfeAuthorizer.SVRS.allowedUfsHomologation()) {
            assertEquals(NfeSvrsSoapService.class, new DefaultSoapServiceImpl().getNfeSoapService(uf, Environment.HOMOLOGATION, NFEmissionType.NORMAL).getClass());
        }
        for (UF uf : NfeAuthorizer.SVRS.allowedUfsHomologation()) {
            assertEquals(NfeSvrsSoapService.class, new DefaultSoapServiceImpl().getNfeSoapService(uf, Environment.PRODUCTION, NFEmissionType.EPEC).getClass());
        }
        for (UF uf : NfeAuthorizer.SVRS.allowedUfsHomologation()) {
            assertEquals(NfeSvrsSoapService.class, new DefaultSoapServiceImpl().getNfeSoapService(uf, Environment.HOMOLOGATION, NFEmissionType.EPEC).getClass());
        }
        for (UF uf : NfeAuthorizer.SVCAN.allowedUfsHomologation()) {
            assertEquals(NfeSvcanSoapService.class, new DefaultSoapServiceImpl().getNfeSoapService(uf, Environment.PRODUCTION, NFEmissionType.SVCAN).getClass());
        }
        for (UF uf : NfeAuthorizer.SVCAN.allowedUfsHomologation()) {
            assertEquals(NfeSvcanSoapService.class, new DefaultSoapServiceImpl().getNfeSoapService(uf, Environment.HOMOLOGATION, NFEmissionType.SVCAN).getClass());
        }
    }

    @Test
    void getNfceSoapService() {
    }

    @Test
    void getCteSoapService() {
    }

    @Test
    void getCte4SoapService() {
    }

    @Test
    void getMdfeSoapService() {
    }
}
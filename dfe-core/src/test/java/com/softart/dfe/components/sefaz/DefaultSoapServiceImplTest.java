package com.softart.dfe.components.sefaz;

import com.softart.dfe.components.sefaz.port.nfe.impl.NfeSvcanSoapService;
import com.softart.dfe.components.sefaz.port.nfe.impl.NfeSvrsSoapService;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
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
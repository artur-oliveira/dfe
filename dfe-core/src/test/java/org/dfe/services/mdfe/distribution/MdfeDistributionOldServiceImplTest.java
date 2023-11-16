package org.dfe.services.mdfe.distribution;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxMdfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.models.mdfe.distribution.MdfeReturnDistributionOld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeDistributionOldServiceImplTest {

    MdfeConfig config = new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance());

    MdfeDistributionOldServiceImplTest() throws Exception {
        System.setProperty("org.dfe.handler.log.request", "true");
        System.setProperty("org.dfe.handler.log.response", "true");
    }

    @Test
    void testDistributionUniqueNsuAndEnvironmentHom() throws Exception {
        MdfeReturnDistributionOld distribution = new MdfeDistributionOldServiceImpl(config).distributionUniqueNsu(0L, Environment.HOMOLOGATION);
        assertNotNull(distribution);
        assertEquals("2", distribution.getTpAmb());
    }

    @Test
    void testDistributionUniqueNsuAndEnvironmentProd() throws Exception {
        MdfeReturnDistributionOld distribution = new MdfeDistributionOldServiceImpl(config).distributionUniqueNsu(0L, Environment.PRODUCTION);
        assertNotNull(distribution);
        assertEquals("1", distribution.getTpAmb());
    }

    @Test
    void testDistributionUniqueNsu() throws Exception {
    }

    @Test
    void testDistributionUltNsuAndEnvironment() throws Exception {
    }

    @Test
    void testDistributionUltNsu() throws Exception {
    }
}
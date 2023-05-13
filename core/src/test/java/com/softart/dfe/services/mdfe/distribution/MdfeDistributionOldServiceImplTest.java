package com.softart.dfe.services.mdfe.distribution;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.models.mdfe.distribution.MdfeReturnDistributionOld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeDistributionOldServiceImplTest {

    MdfeConfig config = new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance());

    MdfeDistributionOldServiceImplTest() throws Exception {
        System.setProperty("com.softart.dfe.handler.log.request", "true");
        System.setProperty("com.softart.dfe.handler.log.response", "true");
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
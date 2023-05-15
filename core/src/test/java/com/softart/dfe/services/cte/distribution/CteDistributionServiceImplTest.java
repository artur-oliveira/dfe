package com.softart.dfe.services.cte.distribution;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.cte.distribution.CteReturnDistribution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CteDistributionServiceImplTest {
    CteDistributionService service = new CteDistributionServiceImpl(
            new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    public CteDistributionServiceImplTest() throws Exception {
        System.setProperty("com.softart.dfe.handler.log.request", "true");
        System.setProperty("com.softart.dfe.handler.log.response", "true");
    }

    @Test
    void testDistributionUniqueNsuAndDefaultEnvironment() throws Exception {
        CteReturnDistribution o = new CteDistributionServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        ).distributionUniqueNsu(0L);
        assertNotNull(o);
        assertEquals("2", o.getTpAmb());
    }

    @Test
    void testDistributionUltNsuAndDefaultEnvironment() throws Exception {
        CteReturnDistribution o = new CteDistributionServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        ).distributionUltNsu(0L);
        assertNotNull(o);
        assertEquals("2", o.getTpAmb());
    }

    @Test
    void testDistributionUniqueNsuAndDefaultEnvironmentIsProduction() throws Exception {
        CteReturnDistribution o = new CteDistributionServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        ).distributionUniqueNsu(0L);
        assertNotNull(o);
        assertEquals("1", o.getTpAmb());
    }

    @Test
    void testDistributionUltNsuAndDefaultEnvironmentIsProduction() throws Exception {
        CteReturnDistribution o = new CteDistributionServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        ).distributionUltNsu(0L);
        assertNotNull(o);
        assertEquals("1", o.getTpAmb());
    }
}
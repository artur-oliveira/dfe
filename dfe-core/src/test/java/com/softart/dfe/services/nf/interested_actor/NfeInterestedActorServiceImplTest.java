package com.softart.dfe.services.nf.interested_actor;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import com.softart.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfeInterestedActorServiceImplTest {
    @Test
    void testInterestedActorWithEnvironmentHomologation() throws Exception {
        NfeInterestedActorService service = new NfeInterestedActorServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        ReturnNfeInterestedActor o = service.interestedActor("22230511520224000140550010000450661287506862", "05213730345", "", NFDownloadAuthorization.YES);
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testInterestedActorWithEnvironmentProduction() throws Exception {
        NfeInterestedActorService service = new NfeInterestedActorServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        ReturnNfeInterestedActor o = service.interestedActor("22230511520224000140550010000450661287506862", "05213730345", "", NFDownloadAuthorization.YES);
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(Environment.PRODUCTION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }
}
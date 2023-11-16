package org.dfe.services.nf.interested_actor;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import org.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;
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
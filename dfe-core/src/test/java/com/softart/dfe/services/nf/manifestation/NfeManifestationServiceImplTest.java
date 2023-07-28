package com.softart.dfe.services.nf.manifestation;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfeManifestationServiceImplTest {
    @Test
    void testNotPerformedWithEnvironmentHomologation() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.notPerformed("22230511520224000140550010000450661287506862", NFEvent.OPERATION_NOT_PERFORMED.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_NOT_PERFORMED.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testNotPerformedWithEnvironmentProduction() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.notPerformed("22230511520224000140550010000450661287506862", NFEvent.OPERATION_NOT_PERFORMED.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_NOT_PERFORMED.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.PRODUCTION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testIgnoranceWithEnvironmentHomologation() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.ignorance("22230511520224000140550010000450661287506862", NFEvent.OPERATION_IGNORANCE.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_IGNORANCE.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testIgnoranceWithEnvironmentProduction() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.ignorance("22230511520224000140550010000450661287506862", NFEvent.OPERATION_IGNORANCE.getDefaultMessage());
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_IGNORANCE.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.PRODUCTION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testConfirmationWithEnvironmentHomologation() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.confirmation("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_CONFIRMATION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testConfirmationWithEnvironmentProduction() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.confirmation("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_CONFIRMATION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.PRODUCTION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testScienceWithEnvironmentHomologation() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.science("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_SCIENCE.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }

    @Test
    void testScienceWithEnvironmentProduction() throws Exception {
        NfeManifestationService service = new NfeManifestationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC)
        );
        NfeReturnManifestation o = service.science("22230511520224000140550010000450661287506862");
        assertNotNull(o);
        assertEquals(1, o.getRetEvento().size());
        assertEquals(NFEvent.OPERATION_SCIENCE.getCode(), o.getRetEvento().get(0).getInfEvento().getTpEvento());
        assertEquals(Environment.PRODUCTION.getCode(), o.getRetEvento().get(0).getInfEvento().getTpAmb());
    }
}
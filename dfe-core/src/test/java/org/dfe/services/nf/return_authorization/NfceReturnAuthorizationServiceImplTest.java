package org.dfe.services.nf.return_authorization;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfceConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfceReturnAuthorizationServiceImplTest {
    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        // TODO: Erro no WebService
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        // TODO: Erro no WebService
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testReturnAuthorizationWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfceReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(
                new PfxNfceConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC,
                        "1",
                        "115202241607220426225340"
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

}
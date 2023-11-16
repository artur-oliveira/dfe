package org.dfe.services.nf.return_authorization;

import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxNfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFSend;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfeReturnAuthorizationServiceImplTest {
    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerAm() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerAm() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.AM,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerBa() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerBa() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.BA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerGo() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerGo() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.GO,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMg() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MG,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMg() throws Exception {
        // TODO: Erro no WebService
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerMt() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerMt() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerPe() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerPe() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PE,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerPr() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerPr() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PR,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerRs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerRs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.RS,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(UF.RS.getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSp() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSp() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.SP,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvan() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvan() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MA,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvcan() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvcan() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCAN,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvcrs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvcrs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.MT,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.SVCRS,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsHomologationAndAuthorizerSvrs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.HOMOLOGATION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }

    @Test
    void testQueryProtocolWithEnvironmentIsProductionAndAuthorizerSvrs() throws Exception {
        NfeReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                )
        );
        ReturnQueryReceiptNfe o = service.queryReceipt(service.getConfig().uf().getCode() + "3" + "999999999999");
        assertNotNull(o);
        assertEquals(service.getConfig().uf().getCode(), o.getCuf());
        assertEquals(service.getConfig().environment().getCode(), o.getTpAmb());
    }
}
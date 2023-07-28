package com.softart.dfe.services.mdfe.event;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.city.CityPI;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.enums.mdfe.event.MdfePaymentOperationShippingType;
import com.softart.dfe.enums.mdfe.event.MdfePaymentOperationTypeIndicator;
import com.softart.dfe.models.mdfe.event.MdfeDfeInclusion;
import com.softart.dfe.models.mdfe.event.MdfePaymentModification;
import com.softart.dfe.models.mdfe.event.MdfePaymentOperation;
import com.softart.dfe.models.mdfe.event.MdfeReturnEvent;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeEventServiceImplTest {
    MdfeEventService service = new MdfeEventServiceImpl(
            new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    MdfeEventServiceImplTest() throws Exception {
        System.setProperty("com.softart.dfe.handler.log.request", "true");
        System.setProperty("com.softart.dfe.handler.log.response", "true");
    }


    @Test
    void testTransportConfirmation() throws Exception {
        MdfeReturnEvent event = service.transportConfirmation("22999999999999999999999999999999999999999999", "999999999999999");
        assertNotNull(event);
        assertNotNull(event.getInfEvento());
        assertEquals(service.getConfig().environment().getCode(), event.getInfEvento().getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), event.getInfEvento().getCOrgao());

    }

    @Test
    void testDriverInclusion() throws Exception {
        MdfeReturnEvent event = service.driverInclusion("22999999999999999999999999999999999999999999", "Teste", "99999999999");
        assertNotNull(event);
        assertNotNull(event.getInfEvento());
        assertEquals(service.getConfig().environment().getCode(), event.getInfEvento().getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), event.getInfEvento().getCOrgao());
    }

    @Test
    void testPaymentModification() throws Exception {
        MdfeReturnEvent event = service.paymentModification("22999999999999999999999999999999999999999999", "999999999999999",
                Collections.singletonList(MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag
                        .builder().cpf("99999999999")
                        .xNome("Teste")
                        .vContrato("100.00")
                        .indPag(MdfePaymentOperationTypeIndicator.IN_CASH.getCode())
                        .infBanc(MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag.InfBanc
                                .builder()
                                .codBanco("260")
                                .codAgencia("12345678")
                                .build())
                        .vContrato("1000")
                        .cpf("05213730345")
                        .comp(Collections.singletonList(MdfePaymentModification.InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag.Comp
                                .builder()
                                .tpComp(MdfePaymentOperationShippingType.CODE_99.getCode())
                                .vComp("1000")
                                .xComp("KEK")
                                .build())).build()),
                "1");
        assertNotNull(event);
        assertNotNull(event.getInfEvento());
        assertEquals(service.getConfig().environment().getCode(), event.getInfEvento().getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), event.getInfEvento().getCOrgao());
    }

    @Test
    void testPaymentOperation() throws Exception {
        MdfeReturnEvent event = service.paymentOperation("22999999999999999999999999999999999999999999", "999999999999999",
                MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfViagens
                        .builder()
                        .nroViagem("12345")
                        .qtdViagens("12345")
                        .build(),
                Collections.singletonList(MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag
                        .builder().cpf("99999999999")
                        .xNome("Teste")
                        .vContrato("100.00")
                        .indPag(MdfePaymentOperationTypeIndicator.IN_CASH.getCode())
                        .infBanc(MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag.InfBanc
                                .builder()
                                .codBanco("260")
                                .codAgencia("12345678")
                                .build())
                        .vContrato("1000")
                        .cpf("05213730345")
                        .comp(Collections.singletonList(MdfePaymentOperation.InfEvento.DetEvento.EvPagtoOperMDFe.InfPag.Comp
                                .builder()
                                .tpComp(MdfePaymentOperationShippingType.CODE_99.getCode())
                                .vComp("1000")
                                .xComp("KEK")
                                .build())).build()),
                "1");
        assertNotNull(event);
        assertNotNull(event.getInfEvento());
        assertEquals(service.getConfig().environment().getCode(), event.getInfEvento().getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), event.getInfEvento().getCOrgao());
    }

    @Test
    void testDfeInclusion() throws Exception {
        MdfeReturnEvent event = service.dfeInclusion(
                "22999999999999999999999999999999999999999999",
                "999999999999999",
                CityPI.PI_TERESINA.getCode(),
                CityPI.PI_TERESINA.getDescription(),
                Collections.singletonList(MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc
                        .builder()
                        .chNFe("22221211520224000140550010000036611779691887")
                        .cMunDescarga(CityPI.PI_TERESINA.getCode())
                        .xMunDescarga(CityPI.PI_TERESINA.getCode())
                        .build()),
                "1");
        assertNotNull(event);
        assertNotNull(event.getInfEvento());
        assertEquals(service.getConfig().environment().getCode(), event.getInfEvento().getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), event.getInfEvento().getCOrgao());
    }

    @Test
    void testClose() throws Exception {
        MdfeReturnEvent event = service.close("22999999999999999999999999999999999999999999", "999999999999999", CityPI.PI_TERESINA.getUf().getCode(),
                CityPI.PI_TERESINA.getCode());
        assertNotNull(event);
        assertNotNull(event.getInfEvento());
        assertEquals(service.getConfig().environment().getCode(), event.getInfEvento().getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), event.getInfEvento().getCOrgao());
    }

    @Test
    void testCancel() throws Exception {
        MdfeReturnEvent event = service.cancel("22999999999999999999999999999999999999999999", "999999999999999", MdfeEvent.CANCEL.getDefaultMessage());
        assertNotNull(event);
        assertNotNull(event.getInfEvento());
        assertEquals(service.getConfig().environment().getCode(), event.getInfEvento().getTpAmb());
        assertEquals(service.getConfig().uf().getCode(), event.getInfEvento().getCOrgao());
    }

}
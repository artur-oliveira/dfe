package com.softart.dfe.services.cte4.event;

import br.inf.portalfiscal.cte.send400.TUf;
import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.cte.CteReturnCode;
import com.softart.dfe.enums.cte.info.kind.CteGtvKindType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.cte4.event.CteCorrectionLetter;
import com.softart.dfe.models.cte4.event.CteEpec;
import com.softart.dfe.models.cte4.event.CteGtv;
import com.softart.dfe.models.cte4.event.CteReturnEvent;
import com.softart.dfe.util.DateUtils;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CteEventServiceImplTest {

    public CteEventServiceImplTest() {

    }

    @Test
    void testCancelWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("22230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("22230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "22230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("22220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "22230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "35230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.PI)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.PI)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.PI)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "22230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "22230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentHomologationAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "22230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("22230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("22230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "22230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("22220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "22230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "22230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.PI)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.PI)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.PI)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "22230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "22230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentProductionAndAuthorizerSvrs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PI, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "22230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PI.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("35230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("35230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "35230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("35220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "35230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "35230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.SP)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.SP)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.SP)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "35230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "35230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentHomologationAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "35230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("35230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("35230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "35230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("35220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "35230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "35230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.SP)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.SP)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.SP)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "35230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "35230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentProductionAndAuthorizerSvsp() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "35230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.SP.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("31230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("31230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "31230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("31220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "31230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "31230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.MG)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.MG)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.MG)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "31230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "31230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentHomologationAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "31230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MG.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("31230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testCorrectionLetterWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("31230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testDeliveryReceiptWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "31230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("31220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "31230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testEpecWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "31230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.MG)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.MG)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.MG)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testGtvWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "31230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testProvisionDisagreementWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "31230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testMultimodalWithEnviromentProductionAndAuthorizerMg() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MG, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "31230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
    }

    @Test
    void testCancelWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("50230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("50230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "50230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("50220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "50230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "50230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.MS)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.MS)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.MS)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "50230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "50230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentHomologationAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "50230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("50230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("50230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "50230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("50220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "50230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "50230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.MS)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.MS)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.MS)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "50230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "50230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentProductionAndAuthorizerMs() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MS, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "50230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MS.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentHomologationAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("50230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());

    }

    @Test
    void testCorrectionLetterWithEnviromentHomologationAndAuthorizerMt() throws Exception {

        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("50230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());

    }

    @Test
    void testDeliveryReceiptWithEnviromentHomologationAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("50230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());


    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentHomologationAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("50230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());


    }

    @Test
    void testEpecWithEnviromentHomologationAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "51230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.MT)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.MT)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.MT)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());


    }

    @Test
    void testGtvWithEnviromentHomologationAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "51230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());

    }

    @Test
    void testProvisionDisagreementWithEnviromentHomologationAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "51230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());

    }

    @Test
    void testMultimodalWithEnviromentHomologationAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );


        CteReturnEvent o = service.multimodal(
                "51230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());

    }

    @Test
    void testCancelWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("51230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("51230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "51230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("51220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "51230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "51230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.MT)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.MT)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.MT)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "51230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "51230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentProductionAndAuthorizerMt() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "51230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.MT.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("41230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("41230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "41230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("41220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "41230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "41230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.PR)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.PR)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.PR)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "41230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "41230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentHomologationAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "41230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.HOMOLOGATION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancel("41230511520224000140999999999999999999999999", "999999999999999");
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCorrectionLetterWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.correctionLetter("41230511520224000140999999999999999999999999", Collections.singletonList(
                CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                        .builder()
                        .campoAlterado("xNome")
                        .grupoAlterado("emit")
                        .valorAlterado("TESTE")
                        .build()
        ), "1");

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testDeliveryReceiptWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.deliveryReceipt(
                "41230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=",
                "05213730345",
                "Artur",
                "-5.076913",
                "-42.801835",
                Collections.singletonList("41220911520224000140550010000035391879129974"));

        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testCancelDeliveryReceiptWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.cancelDeliveryReceipt(
                "41230511520224000140999999999999999999999999",
                "999999999999999",
                "1",
                "999999999999999"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testEpecWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.epec(
                "41230511520224000140999999999999999999999999",
                CteEpec.InfEvento
                        .DetEvento
                        .EvEPECCTe
                        .builder()
                        .xJust(CteEvent.EPEC.getDefaultMessage())
                        .vCarga("999.99")
                        .vtPrest("999.99")
                        .modal("03")
                        .ufIni(TUf.PR)
                        .vicms("0.00")
                        .vicmsst("0.00")
                        .toma4(CteEpec.InfEvento.DetEvento.EvEPECCTe.Toma4
                                .builder()
                                .toma("3")
                                .uf(TUf.PR)
                                .cnpj("11520224000140")
                                .ie("123456789")
                                .build())
                        .ufFim(TUf.PR)
                        .tpCTe("0")
                        .dhEmi("2023-05-01T00:00:00-03:00")
                        .build()
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testGtvWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.gtv(
                "41230511520224000140999999999999999999999999",
                "1",
                CteGtv.InfEvento
                        .DetEvento
                        .EvGTV
                        .InfGTV
                        .builder()
                        .nDoc("1")
                        .id("1")
                        .serie("1")
                        .subserie("1")
                        .dEmi(DateUtils.nowStringDate())
                        .ndv("1")
                        .infEspecie(Collections.singletonList(
                                CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.InfEspecie.builder()
                                        .tpEspecie(CteGtvKindType.OTHER.getCode())
                                        .vEspecie("100000.00")
                                        .build()
                        ))
                        .rem(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Rem.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .dest(CteGtv.InfEvento.DetEvento.EvGTV.InfGTV.Dest.builder()
                                .ie("194739350")
                                .xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .cnpj(service.getConfig().cnpj())
                                .uf(TUf.valueOf(service.getConfig().uf().name()))
                                .build())
                        .qCarga("1")
                        .build());
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testProvisionDisagreementWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.provisionDisagreement(
                "41230511520224000140999999999999999999999999",
                "1",
                "TESTE TESTE TESTE"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }

    @Test
    void testMultimodalWithEnviromentProductionAndAuthorizerPr() throws Exception {
        CteEventService service = new CteEventServiceImpl(
                new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.PRODUCTION, KeyStoreFactory.getInstance())
        );

        CteReturnEvent o = service.multimodal(
                "41230511520224000140999999999999999999999999",
                "1",
                "QUERO TESTAR ISSO AQUI",
                "1"
        );
        assertNotNull(o);
        assertNotEquals(CteReturnCode.CODE_242.getCode(), o.getInfEvento().getCStat());
        assertNotEquals(CteReturnCode.CODE_677.getCode(), o.getInfEvento().getCStat());
        assertEquals(Environment.PRODUCTION.getCode(), o.getInfEvento().getTpAmb());
        assertEquals(UF.PR.getCode(), o.getInfEvento().getCOrgao());
    }
}
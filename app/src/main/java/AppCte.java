import br.inf.portalfiscal.cte.send.TUFSemEX;
import br.inf.portalfiscal.cte.send.TUf;
import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.components.security.signer.DefaultXmlSigner;
import com.softart.dfe.enums.cte.identification.*;
import com.softart.dfe.enums.cte.info.charge.CteChargeUnid;
import com.softart.dfe.enums.cte.info.kind.CteCashType;
import com.softart.dfe.enums.cte.info.kind.CteGtvKindType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.city.CityPI;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.cte.event.CteCorrectionLetter;
import com.softart.dfe.models.cte.event.CteGtv;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception.CteReturnSend;
import com.softart.dfe.models.cte.reception_gtve.Gtve;
import com.softart.dfe.models.cte.reception_os.CteOs;
import com.softart.dfe.services.cte.distribution.CteDistributionServiceImpl;
import com.softart.dfe.services.cte.event.CteEventService;
import com.softart.dfe.services.cte.event.CteEventServiceImpl;
import com.softart.dfe.services.cte.inutilization.CteInutilizationServiceImpl;
import com.softart.dfe.services.cte.inutilization.CteOsInutilizationServiceImpl;
import com.softart.dfe.services.cte.inutilization.InutilizationService;
import com.softart.dfe.services.cte.query_receipt.CteQueryReceiptService;
import com.softart.dfe.services.cte.query_receipt.CteQueryReceiptServiceImpl;
import com.softart.dfe.services.cte.query_situation.CteQuerySituationServiceImpl;
import com.softart.dfe.services.cte.reception.CteReceptionService;
import com.softart.dfe.services.cte.reception.CteReceptionServiceImpl;
import com.softart.dfe.services.cte.reception_gtve.GtveReceptionService;
import com.softart.dfe.services.cte.reception_gtve.GtveReceptionServiceImpl;
import com.softart.dfe.services.cte.reception_os.CteOsReceptionService;
import com.softart.dfe.services.cte.reception_os.CteOsReceptionServiceImpl;
import com.softart.dfe.services.cte.reception_sync.CteReceptionSyncService;
import com.softart.dfe.services.cte.reception_sync.CteReceptionSyncServiceImpl;
import com.softart.dfe.services.cte.status_service.CteStatusServiceServiceImpl;
import com.softart.dfe.util.DateUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public final class AppCte {

    public static void main(String[] args) throws Exception {
        System.setProperty("com.softart.certificate.path", "path/to/certificate.pfx");
        System.setProperty("com.softart.certificate.password", "*");
        System.setProperty("com.softart.dfe.storage.mdfe.logxml", "false");
        System.setProperty("com.softart.dfe.handler.log.request", "false");
        System.setProperty("com.softart.dfe.handler.log.response", "false");
//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
//        statusServico(Arrays.asList(UF.PR, UF.BA, UF.RS));
//        distribution();
//        querySituation("22221011520224000140570010000002881903321274");
//        cancelar("22221011520224000140570010000002881903321274");
//        cartaCorrecao("22221011520224000140570010000002881903321274");
//        comprovanteEntrega("22221011520224000140570010000002881903321274");
//        cancelarComprovanteEntrega("22221011520224000140570010000002881903321274", "322220000001422");
//        gtv("22221011520224000140570010000002881903321274");
//        provisionInDisagreement("22221211520224000140570010000003191604007441", "QUERO TESTAR ISSO AQUI");
//        multimodal("22221211520224000140570010000003191604007441", "QUERO TESTAR ISSO AQUI", "1");
//        reception();
//        receptionOs();
//        receptionGtve();
        receptionSync();
//        queryReceipt("223000019361172");
////        inutilizarCte();
//        inutilizarCteOs();
    }

    private static void queryReceipt(String receipt) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        System.out.println(new CteQueryReceiptServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info)).queryReceipt(receipt));

    }

    private static void cancelar(String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        System.out.println(new CteEventServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info)).cancel(accessKey));

    }

    private static void reception() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
        CteReceptionService service = new CteReceptionServiceImpl(new PfxCteConfigImpl(UF.SP, "11520224000140", Environment.HOMOLOGATION, info));

        CteReturnSend send = service.reception(getCte(service.getConfig(), 1, Model.CTE));
        System.out.println(send);

        if (Objects.nonNull(send.getInfRec())) {
            Thread.sleep(send.getInfRec().getTMed().longValue() * 1000L);

            CteQueryReceiptService queryReceiptService = new CteQueryReceiptServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info));

            System.out.println(queryReceiptService.queryReceipt(send.getInfRec().getNRec()));
        }
    }

    private static void receptionSync() throws Exception {
        try {
            KeyStoreInfo info = KeyStoreFactory.getInstance();
            CteReceptionSyncService service = new CteReceptionSyncServiceImpl(new PfxCteConfigImpl(UF.MT, "11520224000140", Environment.HOMOLOGATION, info));

            System.out.println(service.receptionSync(getCte(service.getConfig(), 1, Model.CTE)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void receptionOs() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
        CteOsReceptionService service = new CteOsReceptionServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info));

        System.out.println(service.receptionOs(getCteOs(service.getConfig(), 1, Model.CTE_OS)));

    }

    private static void receptionGtve() throws Exception {
        try {
            KeyStoreInfo info = KeyStoreFactory.getInstance();
            GtveReceptionService service = new GtveReceptionServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info));

            System.out.println(service.receptionGtve(getGtve(service.getConfig(), 1, Model.GTVE)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static CteOs getCteOs(CteConfig config, int number, Model model) throws Exception {
        CityPI c = CityPI.PI_TERESINA;

        return CteOs
                .builder()
                .infCte(CteOs.InfCte
                        .builder()
                        .ide(CteOs.InfCte
                                .Ide
                                .builder()
                                .cuf(config.uf().getCode())
                                .cfop("5353")
                                .natOp("TESTE")
                                .mod(model.getCode())
                                .serie("1")
                                .nct(String.valueOf(number))
                                .tpAmb(config.environment().getCode())
                                .tpCTe(CteType.NORMAL.getCode())
                                .procEmi(CteProcessEmission.APPLICATION.getCode())
                                .tpImp(CtePrintType.PORTRAIT.getCode())
                                .tpEmis(config.emission().getCode())
                                .cMunEnv(c.getCode())
                                .ufEnv(TUf.valueOf(c.getUf().name()))
                                .xMunEnv(c.getDescription())
                                .modal(CteModal.RODOVIARIO.getCode())
                                .tpServ(CteServiceType.VALUE.getCode())
                                .cMunIni(c.getCode())
                                .xMunIni(c.getDescription())
                                .ufIni(TUf.valueOf(c.getUf().name()))
                                .cMunFim(c.getCode())
                                .xMunFim(c.getDescription())
                                .ufFim(TUf.valueOf(c.getUf().name()))
                                .indIEToma("1")
                                .build())
                        .emit(CteOs.InfCte.Emit
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .crt("1")
                                .enderEmit(CteOs.InfCte.TEndeEmi
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUFSemEX.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .toma(CteOs.InfCte.Toma.builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderToma(CteOs.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .vPrest(CteOs.InfCte.VPrest.builder()
                                .vtPrest("1110.00")
                                .vRec("1110.00")
                                .build())
                        .imp(CteOs.InfCte.Imp
                                .builder()
                                .icms(CteOs.InfCte.Imp.TImpOS
                                        .builder()
                                        .icms00(CteOs.InfCte.Imp.TImpOS.ICMS00.builder()
                                                .vbc("1110.00")
                                                .picms("17.00")
                                                .vicms("188.70")
                                                .build())
                                        .build())
                                .vTotTrib("188.70")
                                .build())
                        .infCTeNorm(CteOs.InfCte.InfCTeNorm
                                .builder()
                                .infServico(CteOs.InfCte.InfCTeNorm.InfServico
                                        .builder()
                                        .infQ(CteOs.InfCte.InfCTeNorm.InfServico.InfQ.builder().qCarga("100").build())
                                        .xDescServ("CARREGAMENTO DE VASILHAMES")
                                        .build())
                                .build())
                        .infRespTec(CteOs.InfCte.TRespTec.builder()
                                .cnpj("11520224000140")
                                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                                .email("falecom@tartigrado.com")
                                .fone("86988033430")
                                .build())
                        .build())
                .build();
    }

    private static Cte getCte(CteConfig config, int number, Model model) throws Exception {
        CityPI c = CityPI.PI_TERESINA;

        return Cte
                .builder()
                .infCte(Cte.InfCte
                        .builder()
                        .ide(Cte.InfCte
                                .Ide
                                .builder()
                                .cuf(config.uf().getCode())
                                .cfop("5932")
                                .natOp("TESTE")
                                .mod(model.getCode())
                                .serie("1")
                                .nct(String.valueOf(number))
                                .tpAmb(config.environment().getCode())
                                .tpCTe(CteType.NORMAL.getCode())
                                .procEmi(CteProcessEmission.APPLICATION.getCode())
                                .tpImp(CtePrintType.PORTRAIT.getCode())
                                .tpEmis(config.emission().getCode())
                                .cMunEnv(c.getCode())
                                .ufEnv(TUf.valueOf(c.getUf().name()))
                                .xMunEnv(c.getDescription())
                                .modal(CteModal.RODOVIARIO.getCode())
                                .tpServ(CteServiceType.NORMAL.getCode())
                                .cMunIni(c.getCode())
                                .xMunIni(c.getDescription())
                                .ufIni(TUf.valueOf(c.getUf().name()))
                                .cMunFim(c.getCode())
                                .xMunFim(c.getDescription())
                                .ufFim(TUf.valueOf(c.getUf().name()))
                                .indIEToma("1")
                                .retira("1")
                                .toma3(Cte.InfCte.Ide.Toma3.builder().toma(CteToma.REMITTEE.getCode()).build())
                                .build())
                        .compl(Cte.InfCte.Compl.builder().entrega(Cte.InfCte.Compl.Entrega
                                        .builder()
                                        .semData(Cte.InfCte.Compl.Entrega.SemData.builder().build())
                                        .semHora(Cte.InfCte.Compl.Entrega.SemHora.builder().build())
                                        .build())
                                .build())
                        .emit(Cte.InfCte.Emit
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .crt("1")
                                .enderEmit(Cte.InfCte.TEndeEmi
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUFSemEX.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .rem(Cte.InfCte.Rem
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .enderReme(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .exped(Cte.InfCte.Exped
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderExped(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .receb(Cte.InfCte.Receb
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderReceb(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .dest(Cte.InfCte.Dest
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderDest(Cte.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .vPrest(Cte.InfCte.VPrest.builder()
                                .vtPrest("1110.00")
                                .vRec("1110.00")
                                .build())
                        .imp(Cte.InfCte.Imp
                                .builder()
                                .icms(Cte.InfCte.Imp.TImp
                                        .builder()
                                        .icms00(Cte.InfCte.Imp.TImp.ICMS00.builder()
                                                .vbc("1110.00")
                                                .picms("17.00")
                                                .vicms("188.70")
                                                .build())
                                        .build())
                                .vTotTrib("188.70")
                                .build())
                        .infCTeNorm(Cte.InfCte.InfCTeNorm
                                .builder()
                                .infCarga(Cte.InfCte.InfCTeNorm.InfCarga
                                        .builder()
                                        .vCarga("1600.00")
                                        .proPred("VASILHAME 13KG - ONU 1075 GLP 2.1")
                                        .xOutCat("VASILHAME")
                                        .infQ(Collections.singletonList(
                                                Cte.InfCte.InfCTeNorm.InfCarga.InfQ
                                                        .builder()
                                                        .cUnid(CteChargeUnid.KG.getCode())
                                                        .tpMed("PESO BRUTO")
                                                        .qCarga("130.0000")
                                                        .build()
                                        ))
                                        .build())
                                .infDoc(Cte.InfCte.InfCTeNorm.InfDoc
                                        .builder()
                                        .infNFe(Collections.singletonList(Cte.InfCte.InfCTeNorm.InfDoc.InfNFe
                                                .builder()
                                                .chave("22220911520224000140550010000035391879129974")
                                                .build()))
                                        .build())
                                .infModal(Cte.InfCte.InfCTeNorm.InfModal
                                        .builder()
                                        .rodo(Cte.InfCte.InfCTeNorm.InfModal.Rodo
                                                .builder()
                                                .rntrc("12345678")
                                                .build())
                                        .build())
                                .build())
                        .infRespTec(Cte.InfCte.TRespTec.builder()
                                .cnpj("11520224000140")
                                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                                .email("falecom@tartigrado.com")
                                .fone("86988033430")
                                .build())
                        .build())
                .build();
    }

    private static Gtve getGtve(CteConfig config, int number, Model model) throws Exception {
        CityPI c = CityPI.PI_TERESINA;

        return Gtve
                .builder()
                .infCte(Gtve.InfCte
                        .builder()
                        .ide(Gtve.InfCte
                                .Ide
                                .builder()
                                .cuf(config.uf().getCode())
                                .cfop("5353")
                                .natOp("TESTE")
                                .mod(model.getCode())
                                .serie("1")
                                .nct(String.valueOf(number))
                                .tpAmb(config.environment().getCode())
                                .tpCTe(CteType.GTVE.getCode())
                                .tpImp(CtePrintType.PORTRAIT.getCode())
                                .tpEmis(config.emission().getCode())
                                .cMunEnv(c.getCode())
                                .ufEnv(TUf.valueOf(c.getUf().name()))
                                .xMunEnv(c.getDescription())
                                .modal(CteModal.RODOVIARIO.getCode())
                                .tpServ(CteServiceType.GTV.getCode())
                                .dhChegadaDest(DateUtils.plusDaysAsString(10))
                                .indIEToma("1")
                                .toma(Gtve.InfCte.Ide.Toma.builder().toma(CteToma.REMITTER.getCode()).build())
                                .build())
                        .emit(Gtve.InfCte.Emit
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .crt("1")
                                .enderEmit(Gtve.InfCte.TEndeEmi
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUFSemEX.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .rem(Gtve.InfCte.Rem
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .ie("194739350")
                                .enderReme(Gtve.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .dest(Gtve.InfCte.Dest
                                .builder()
                                .cnpj(config.cnpj())
                                .xNome("CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .ie("194739350")
                                .enderDest(Gtve.InfCte.TEndereco
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(config.uf().name()))
                                        .build())
                                .build())
                        .detGTV(Gtve.InfCte.DetGTV
                                .builder()
                                .qCarga("3000")
                                .infEspecie(Collections.singletonList(
                                        Gtve.InfCte.DetGTV.InfEspecie
                                                .builder()
                                                .tpEspecie(CteGtvKindType.OTHER.getCode())
                                                .tpNumerario(CteCashType.NATIONAL.getCode())
                                                .vEspecie("3000")
                                                .build()
                                ))
                                .infVeiculo(Collections.singletonList(
                                        Gtve.InfCte.DetGTV.InfVeiculo.builder()
                                                .placa("GTV1234")
                                                .rntrc("12345678")
                                                .build()
                                ))
                                .build())
                        .infRespTec(Gtve.InfCte.TRespTec.builder()
                                .cnpj("11520224000140")
                                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                                .email("falecom@tartigrado.com")
                                .fone("86988033430")
                                .build())
                        .build())
                .build();
    }

    private static void cartaCorrecao(String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction = CteCorrectionLetter.InfEvento.DetEvento.EvCCeCTe.InfCorrecao
                .builder()
                .campoAlterado("xNome")
                .grupoAlterado("emit")
                .valorAlterado("TESTE")
                .build();

        System.out.println(new CteEventServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info)).correctionLetter(accessKey, correction));

    }

    private static void comprovanteEntrega(String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();


        System.out.println(new CteEventServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info)).deliveryReceipt(accessKey, "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE4LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4NCjxzdmcgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQxNC42MjMgNDE0LjYyMyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNDE0LjYyMyA0MTQuNjIzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojMjExOTE1OyIgZD0iTTQwOS44OTEsOTkuNzhjLTE4LjA4Mi0xMS4yMDYtMzguODg0LTE3LjEzLTYwLjE1Ni0xNy4xM2gtNTYuNjQ4Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjE1Ny41MjgNCgkJaC01Ljc1NHYtMTYuMDMyYzAtNS41MjItNC40NzgtMTAtMTAtMTBoLTI5LjYwN3YtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgyOC45NThjNS41MjIsMCwxMC00LjQ3OCwxMC0xMFYxMDMuMjgNCgkJYzAtNS41MjItNC40NzgtMTAtMTAtMTBIMTAuNzU3Yy01LjUyMywwLTEwLDQuNDc4LTEwLDEwdjEwMS4yODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzOC45NTgNCgkJYy0wLjA2NCwwLjQ1Ni0wLjEwOCwwLjkxNy0wLjEwOCwxLjM5MXY4LjE4OEgxMGMtNS41MjMsMC0xMCw0LjQ3OC0xMCwxMHY1Ni4xODhjMCw1LjUyMiw0LjQ3NywxMCwxMCwxMGgzMS40MTkNCgkJYzQuMjA4LDE4LjEwNCwyMC40NjEsMzEuNjM4LDM5LjgyNywzMS42MzhzMzUuNjE4LTEzLjUzNCwzOS44MjctMzEuNjM4aDQuMTRjNC4yMDgsMTguMTA0LDIwLjQ2MSwzMS42MzgsMzkuODI3LDMxLjYzOA0KCQlzMzUuNjE5LTEzLjUzNCwzOS44MjctMzEuNjM4aDYyLjQ2NWM1LjUyMiwwLDEwLTQuNDc4LDEwLTEwdi0yMC4xNTZoNS43NTR2MjAuMTU2YzAsNS41MjIsNC40NzgsMTAsMTAsMTBoMTUuNTk0DQoJCWM0LjIwOCwxOC4xMDQsMjAuNDYyLDMxLjYzOCwzOS44MjcsMzEuNjM4YzE5LjY1NiwwLDM2LjExMy0xMy45NCw0MC4wMTYtMzIuNDUxYzE0LjkxNy0zLjM0MSwyNi4xMDEtMTYuNjc5LDI2LjEwMS0zMi41ODlWMTA4LjI4DQoJCUM0MTQuNjIzLDEwNC44MTksNDEyLjgzMywxMDEuNjA0LDQwOS44OTEsOTkuNzh6IE0zNDguNTA3LDMxMS45NzNjLTExLjUyMiwwLTIwLjg5Ny05LjM3NS0yMC44OTctMjAuODk3DQoJCXM5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5NnMyMC44OTcsOS4zNzQsMjAuODk3LDIwLjg5NlMzNjAuMDI5LDMxMS45NzMsMzQ4LjUwNywzMTEuOTczeiBNMzQ4LjUwNywyNTAuMTc5DQoJCWMtMTguODM0LDAtMzQuNzI2LDEyLjgwMS0zOS40NTYsMzAuMTU2aC01Ljk2NXYtMzYuMTg4aDkxLjUzN3YyMi43ODZjMCw1LjExOS0yLjg4Nyw5LjU3My03LjExNywxMS44MjkNCgkJQzM4Mi4yNjksMjYyLjIxLDM2Ni43NjgsMjUwLjE3OSwzNDguNTA3LDI1MC4xNzl6IE0zOTQuNjIzLDE2NC4wMzhoLTQxLjc2OXYtMjQuNDU3aDQxLjc2OVYxNjQuMDM4eiBNMzk0LjYyMywxMTQuMDM0djUuNTQ3DQoJCWgtNTEuNzY5Yy01LjUyMiwwLTEwLDQuNDc4LTEwLDEwdjQ0LjQ1N2MwLDUuNTIyLDQuNDc4LDEwLDEwLDEwaDUxLjc2OXY0MC4xMDhoLTkxLjUzN1YxMDIuNjVoNDYuNjQ4DQoJCUMzNjUuNDUzLDEwMi42NSwzODAuODYxLDEwNi41NzEsMzk0LjYyMywxMTQuMDM0eiBNMTg1LjkzOCwyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3DQoJCWMtMTEuNTIyLDAtMjAuODk3LTkuMzc1LTIwLjg5Ny0yMC44OTdzOS4zNzUtMjAuODk2LDIwLjg5Ny0yMC44OTZDMTc2LjU2MywyNzAuMTc5LDE4NS45MzgsMjc5LjU1MywxODUuOTM4LDI5MS4wNzV6DQoJCSBNMTAyLjE0MywyOTEuMDc1YzAsMTEuNTIyLTkuMzc1LDIwLjg5Ny0yMC44OTcsMjAuODk3cy0yMC44OTctOS4zNzUtMjAuODk3LTIwLjg5N3M5LjM3NS0yMC44OTYsMjAuODk3LTIwLjg5Ng0KCQlTMTAyLjE0MywyNzkuNTUzLDEwMi4xNDMsMjkxLjA3NXogTTE2MS42ODYsMjI0LjE0NmgtMzYuMDM5di04LjE4OGMwLTAuNDczLTAuMDQ0LTAuOTM1LTAuMTA4LTEuMzkxaDM2LjI1NQ0KCQljLTAuMDY0LDAuNDU2LTAuMTA4LDAuOTE3LTAuMTA4LDEuMzkxVjIyNC4xNDZ6IE0yMCwyNDQuMTQ2aDIzNy4zMzJ2MzYuMTg4aC01Mi44MzZjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1Ng0KCQlzLTM0LjcyNiwxMi44MDEtMzkuNDU2LDMwLjE1NmgtNC44ODJjLTQuNzMtMTcuMzU1LTIwLjYyMi0zMC4xNTYtMzkuNDU2LTMwLjE1NlM0Ni41MiwyNjIuOTc5LDQxLjc5LDI4MC4zMzVIMjBWMjQ0LjE0NnoNCgkJIE0yMTcuNzI1LDIxNS45NTl2OC4xODhoLTM2LjAzOXYtOC4xODhjMC0wLjQ3My0wLjA0NC0wLjkzNS0wLjEwOC0xLjM5MWgzNi4yNTVDMjE3Ljc2OSwyMTUuMDI0LDIxNy43MjUsMjE1LjQ4NiwyMTcuNzI1LDIxNS45NTl6DQoJCSBNMjAuNzU3LDExMy4yOGgyMzUuODE4djgxLjI4OEgyMC43NTdWMTEzLjI4eiBNNjkuNSwyMTQuNTY4aDM2LjI1NWMtMC4wNjQsMC40NTYtMC4xMDgsMC45MTctMC4xMDgsMS4zOTF2OC4xODhINjkuNjA3di04LjE4OA0KCQlDNjkuNjA3LDIxNS40ODYsNjkuNTYzLDIxNS4wMjQsNjkuNSwyMTQuNTY4eiIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=", "05213730345", "Artur", "-5.076913", "-42.801835", Collections.singletonList("22220911520224000140550010000035391879129974")));

    }

    private static void cancelarComprovanteEntrega(String accessKey, String deliveryReceipt) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info));

        System.out.println(service.cancelDeliveryReceipt(accessKey, deliveryReceipt));

    }

    private static void provisionInDisagreement(String ak, String obs) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info));

        System.out.println(service.provisionDisagreement(ak, obs));
    }

    private static void multimodal(String ak, String reg, String doc) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info));

        System.out.println(service.multimodal(ak, reg, doc));
    }


    private static void gtv(String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        CteEventService service = new CteEventServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info));
        System.out.println(service.gtv(accessKey,
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
                        .build()));

    }

    private static void distribution() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        System.out.println(new CteDistributionServiceImpl(new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info)).distributionUltNsu(0L));

    }

    private static void querySituation(String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        CteConfig config = new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info);
        XMLSignerService signer = new DefaultXmlSigner();
        System.out.println(new CteQuerySituationServiceImpl(config).querySituation(accessKey));
    }


    private static void statusServico(Collection<UF> states) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        for (UF state : UF.states()) {
            try {
                System.out.println(new CteStatusServiceServiceImpl(new PfxCteConfigImpl(state, "11520224000140", Environment.HOMOLOGATION, info)).statusService());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                System.out.println(new CteStatusServiceServiceImpl(new PfxCteConfigImpl(state, "11520224000140", Environment.PRODUCTION, info)).statusService());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void inutilizarCte() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
        XMLSignerService signer = new DefaultXmlSigner();

        for (UF state : UF.states()) {
            try {
                System.out.println(new CteInutilizationServiceImpl(new PfxCteConfigImpl(state, "11520224000140", Environment.HOMOLOGATION, info)).inutilizar(1, 1, 1));
            } catch (Exception ignored) {
            }
        }

    }

    private static void inutilizarCteOs() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        CteConfig config = new PfxCteConfigImpl(UF.PR, "11520224000140", Environment.HOMOLOGATION, info);
        XMLSignerService signer = new DefaultXmlSigner();
        InutilizationService service = new CteOsInutilizationServiceImpl(config);

        CteReturnInutilization ret = service.inutilizar(1, 1, 2);
        System.out.println(ret);
    }

}


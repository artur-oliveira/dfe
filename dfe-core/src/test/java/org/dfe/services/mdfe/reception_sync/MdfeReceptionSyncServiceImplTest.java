package org.dfe.services.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TUf;
import org.dfe.components.internal.certificate.KeyStoreFactory;
import org.dfe.components.internal.config.PfxMdfeConfigImpl;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.city.CityPI;
import org.dfe.enums.mdfe.identification.MdfeEmissionType;
import org.dfe.enums.mdfe.identification.MdfeEmitterType;
import org.dfe.enums.mdfe.identification.MdfeModal;
import org.dfe.enums.mdfe.identification.MdfeProcessEmissionType;
import org.dfe.exceptions.security.CertificateException;
import org.dfe.exceptions.security.SSLContextException;
import org.dfe.models.mdfe.reception_sync.Mdfe;
import org.dfe.models.mdfe.reception_sync.MdfeReturn;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MdfeReceptionSyncServiceImplTest {

    MdfeReceptionSyncService service = new MdfeReceptionSyncServiceImpl(
            new PfxMdfeConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance())
    );

    MdfeReceptionSyncServiceImplTest() throws SSLContextException, CertificateException {
        System.setProperty("org.dfe.handler.log.request", "true");
        System.setProperty("org.dfe.handler.log.response", "true");
    }

    @Test
    void testReceptionSync() throws Exception {
        CityPI c = CityPI.PI_TERESINA;

        Mdfe mdfe = Mdfe.builder().infMDFe(Mdfe.InfMDFe
                        .builder()
                        .ide(Mdfe.InfMDFe
                                .Ide
                                .builder()
                                .cuf(service.getConfig().uf().getCode())
                                .mod(Model.MDFE.getCode())
                                .tpEmit(MdfeEmitterType.CODE_2.getCode())
                                .serie("1")
                                .nmdf(String.valueOf(1))
                                .tpAmb(service.getConfig().environment().getCode())
                                .tpEmis(MdfeEmissionType.NORMAL.getCode())
                                .procEmi(MdfeProcessEmissionType.APPLICATION.getCode())
                                .tpEmis(service.getConfig().emission().getCode())
                                .infMunCarrega(Collections.singletonList(Mdfe.InfMDFe.Ide.InfMunCarrega.builder().cMunCarrega(c.getCode()).xMunCarrega(c.getCode()).build()))
                                .modal(MdfeModal.RODOVIARIO.getCode())
                                .ufIni(TUf.valueOf(c.getUf().name()))
                                .ufFim(TUf.valueOf(c.getUf().name()))
                                .build())
                        .emit(Mdfe.InfMDFe.Emit
                                .builder()
                                .cnpj(service.getConfig().cnpj())
                                .xNome("MDF-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .enderEmit(Mdfe.InfMDFe.Emit.TEndeEmi
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(service.getConfig().uf().name()))
                                        .build())
                                .build())
                        .infModal(Mdfe.InfMDFe.InfModal
                                .builder()
                                .rodo(Mdfe.InfMDFe.InfModal.Rodo
                                        .builder()
                                        .infANTT(Mdfe.InfMDFe.InfModal.Rodo.InfANTT.builder().rntrc("12345678").build())
                                        .veicTracao(Mdfe.InfMDFe.InfModal.Rodo.VeicTracao
                                                .builder()
                                                .tara("555")
                                                .condutor(Collections.singletonList(Mdfe.InfMDFe.InfModal.Rodo.VeicTracao.Condutor
                                                        .builder()
                                                        .xNome("Teste Condutor")
                                                        .cpf("08601129005")
                                                        .build()))
                                                .tpRod("06")
                                                .tpCar("01")
                                                .uf(TUf.PI)
                                                .placa("LVL5338")
                                                .build())
                                        .build())
                                .build())
                        .infDoc(Mdfe.InfMDFe.InfDoc
                                .builder()
                                .infMunDescarga(Collections.singletonList(Mdfe.InfMDFe.InfDoc.InfMunDescarga
                                        .builder()
                                        .cMunDescarga(c.getCode())
                                        .xMunDescarga(c.getDescription())
                                        .infNFe(Collections.singletonList(Mdfe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.builder().chNFe("22221211520224000140550010000036611779691887").build()))
                                        .build()))

                                .build())
                        .tot(Mdfe.InfMDFe.Tot.builder().cUnid("01").qnFe("1").qcTe("0").qmdFe("0").qCarga("13.0000").vCarga("160.00").build())
                        .infRespTec(Mdfe.InfMDFe.TRespTec.builder()
                                .cnpj("11520224000140")
                                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                                .email("falecom@tartigrado.com")
                                .fone("99999999999")
                                .build())
                        .build())
                .build();

        MdfeReturn sendMdfeReturn = service.receptionSync(mdfe);

        assertNotNull(sendMdfeReturn);
        assertNotNull(sendMdfeReturn.getCStat());
        assertNotNull(sendMdfeReturn.getXMotivo());
        assertEquals(service.getConfig().uf().getCode(), sendMdfeReturn.getCuf());
    }

    @Test
    void testReceptionSyncProduction() throws Exception {
        CityPI c = CityPI.PI_TERESINA;

        Mdfe mdfe = Mdfe.builder().infMDFe(Mdfe.InfMDFe
                        .builder()
                        .ide(Mdfe.InfMDFe
                                .Ide
                                .builder()
                                .cuf(service.getConfig().uf().getCode())
                                .mod(Model.MDFE.getCode())
                                .tpEmit(MdfeEmitterType.CODE_2.getCode())
                                .serie("1")
                                .nmdf(String.valueOf(1))
                                .tpAmb(Environment.PRODUCTION.getCode())
                                .tpEmis(MdfeEmissionType.NORMAL.getCode())
                                .procEmi(MdfeProcessEmissionType.APPLICATION.getCode())
                                .tpEmis(service.getConfig().emission().getCode())
                                .infMunCarrega(Collections.singletonList(Mdfe.InfMDFe.Ide.InfMunCarrega.builder().cMunCarrega(c.getCode()).xMunCarrega(c.getCode()).build()))
                                .modal(MdfeModal.RODOVIARIO.getCode())
                                .ufIni(TUf.valueOf(c.getUf().name()))
                                .ufFim(TUf.valueOf(c.getUf().name()))
                                .build())
                        .emit(Mdfe.InfMDFe.Emit
                                .builder()
                                .cnpj(service.getConfig().cnpj())
                                .xNome("MDF-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL")
                                .xFant("Teste")
                                .enderEmit(Mdfe.InfMDFe.Emit.TEndeEmi
                                        .builder()
                                        .cep("64014220")
                                        .xBairro("Bairro Teste")
                                        .xCpl("Complemento teste")
                                        .cMun(c.getCode())
                                        .xMun(c.getDescription())
                                        .xLgr("Rua teste")
                                        .nro("666")
                                        .uf(TUf.valueOf(service.getConfig().uf().name()))
                                        .build())
                                .build())
                        .infModal(Mdfe.InfMDFe.InfModal
                                .builder()
                                .rodo(Mdfe.InfMDFe.InfModal.Rodo
                                        .builder()
                                        .infANTT(Mdfe.InfMDFe.InfModal.Rodo.InfANTT.builder().rntrc("12345678").build())
                                        .veicTracao(Mdfe.InfMDFe.InfModal.Rodo.VeicTracao
                                                .builder()
                                                .tara("555")
                                                .condutor(Collections.singletonList(Mdfe.InfMDFe.InfModal.Rodo.VeicTracao.Condutor
                                                        .builder()
                                                        .xNome("Teste Condutor")
                                                        .cpf("08601129005")
                                                        .build()))
                                                .tpRod("06")
                                                .tpCar("01")
                                                .uf(TUf.PI)
                                                .placa("LVL5338")
                                                .build())
                                        .build())
                                .build())
                        .infDoc(Mdfe.InfMDFe.InfDoc
                                .builder()
                                .infMunDescarga(Collections.singletonList(Mdfe.InfMDFe.InfDoc.InfMunDescarga
                                        .builder()
                                        .cMunDescarga(c.getCode())
                                        .xMunDescarga(c.getDescription())
                                        .infNFe(Collections.singletonList(Mdfe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.builder().chNFe("22221211520224000140550010000036611779691887").build()))
                                        .build()))

                                .build())
                        .tot(Mdfe.InfMDFe.Tot.builder().cUnid("01").qnFe("1").qcTe("0").qmdFe("0").qCarga("13.0000").vCarga("160.00").build())
                        .infRespTec(Mdfe.InfMDFe.TRespTec.builder()
                                .cnpj("11520224000140")
                                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                                .email("falecom@tartigrado.com")
                                .fone("99999999999")
                                .build())
                        .build())
                .build();

        MdfeReturn sendMdfeReturn = service.receptionSync(mdfe);

        assertNotNull(sendMdfeReturn);
        assertNotNull(sendMdfeReturn.getCStat());
        assertNotNull(sendMdfeReturn.getXMotivo());
        assertEquals(service.getConfig().uf().getCode(), sendMdfeReturn.getCuf());
    }
}
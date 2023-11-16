package org.dfe.models.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TUf;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.identification.NFType;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.models.nf.authorization.Nf;
import org.dfe.util.StringUtils;
import lombok.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SendNfeEpec implements DFObject, XMLAdapter<SendNfeEpec, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfeEpec> evento;

    public static SendNfeEpec build(NfeEpec event) {
        return build(Collections.singletonList(event));
    }

    public static SendNfeEpec build(NfeEpec.InfEvento infEvento) {
        return build(NfeEpec.builder().infEvento(infEvento).build());
    }

    public static SendNfeEpec build(List<NfeEpec> event) {
        return SendNfeEpec.builder().evento(event).build();
    }

    public static NfeEpec.InfEvento.DetEvento detEvento(String emissionDate, NFType type, String stateRegistration, TUf uf, String cnpj, String cpf, String foreignId, String recipientStateRegistration, String totalValue, String totalIcms, String totalIcmsSt, NfConfig config) {
        return NfeEpec.InfEvento.DetEvento.builder().dhEmi(emissionDate).tpNF(type.getCode()).cOrgaoAutor(config.uf().getCode()).ie(stateRegistration).dest(NfeEpec.InfEvento.DetEvento.Dest.builder().cnpj(cnpj).uf(uf).cpf(cpf).idEstrangeiro(foreignId).ie(recipientStateRegistration).vnf(totalValue).vicms(totalIcms).vst(totalIcmsSt).build()).build();
    }

    public static NfeEpec.InfEvento infEvento(String accessKey, NfeEpec.InfEvento.DetEvento detEvento, Config config) {
        return NfeEpec.InfEvento.builder()
                .chNFe(accessKey)
                .tpAmb(config.environment().getCode())
                .cnpj(config.cnpj())
                .cpf(config.cpf())
                .cOrgao(UF.RFB.getCode())
                .nSeqEvento("1")
                .detEvento(detEvento)
                .build();
    }

    public static NfeEpec.InfEvento infEvento(Nf n, NfConfig config) {
        return infEvento(AccessKeyParserFactory.nfe().fromId(n.toObject().getInfNFe().getId()), detEvento(n.getInfNFe().getIde().getDhEmi(), NFType.valueOfCode(n.getInfNFe().getIde().getTpNF()), n.getInfNFe().getEmit().getIe(), TUf.valueOf(n.getInfNFe().getEmit().getEnderEmit().getUf().name()), n.getInfNFe().getEmit().getCnpj(), n.getInfNFe().getEmit().getCpf(), n.getInfNFe().getDest().getIdEstrangeiro(), n.getInfNFe().getDest().getIe(), n.getInfNFe().getTotal().getIcmsTot().getVnf(), n.getInfNFe().getTotal().getIcmsTot().getVicms(), n.getInfNFe().getTotal().getIcmsTot().getVst(), config), config);
    }

    public static SendNfeEpec build(String accessKey, String emissionDate, NFType type, String stateRegistration, TUf uf, String cnpj, String cpf, String foreignId, String recipientStateRegistration, String totalValue, String totalIcms, String totalIcmsSt, NfConfig config) {
        return build(accessKey, detEvento(emissionDate, type, stateRegistration, uf, cnpj, cpf, foreignId, recipientStateRegistration, totalValue, totalIcms, totalIcmsSt, config), config);
    }

    public static SendNfeEpec build(Nf n, NfConfig config) {
        return build(AccessKeyParserFactory.nfe().fromId(n.toObject().getInfNFe().getId()), n.getInfNFe().getIde().getDhEmi(), NFType.valueOfCode(n.getInfNFe().getIde().getTpNF()), n.getInfNFe().getEmit().getIe(), TUf.valueOf(n.getInfNFe().getEmit().getEnderEmit().getUf().name()), n.getInfNFe().getEmit().getCnpj(), n.getInfNFe().getEmit().getCpf(), n.getInfNFe().getDest().getIdEstrangeiro(), n.getInfNFe().getDest().getIe(), n.getInfNFe().getTotal().getIcmsTot().getVnf(), n.getInfNFe().getTotal().getIcmsTot().getVicms(), n.getInfNFe().getTotal().getIcmsTot().getVst(), config);
    }

    public static SendNfeEpec build(List<Nf> nfs, NfConfig config) {
        return build(nfs.stream().map(it -> NfeEpec.builder().infEvento(infEvento(it, config)).build()).collect(Collectors.toList()));
    }

    public static SendNfeEpec build(String accessKey, NfeEpec.InfEvento.DetEvento detEvento, Config config) {
        return build(NfeEpec.builder()
                .infEvento(infEvento(accessKey, detEvento, config))
                .build());
    }

}

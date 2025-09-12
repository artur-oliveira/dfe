package org.dfe.models.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.send.TUf;
import lombok.*;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.identification.NFType;
import org.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.models.nf.authorization.Nf;
import org.dfe.models.nf.authorization.NfProcessed;
import org.dfe.util.DfeOptional;
import org.dfe.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SendNfEvent implements DFObject, XMLAdapter<SendNfEvent, TEnvEvento> {

    protected final String idLote = StringUtils.random();
    protected final String versao = NFEventVersion.getDefault().getVersion();
    protected List<NfEvent> evento;

    public static SendNfEvent sendEvent(NfEvent event) {
        return sendEvent(List.of(event));
    }

    public static SendNfEvent sendEvent(List<NfEvent> event) {
        return SendNfEvent.builder().evento(event).build();
    }

    public static NfEvent nfeCancel(String accessKey, String protocol, String motive, String sequenceNumber, Config conf) {
        return NfEvent.builder().infEvento(NfEvent
                .InfEvento
                .builder()
                .chNFe(accessKey)
                .nSeqEvento(sequenceNumber)
                .cnpj(conf.cnpj())
                .cpf(conf.cpf())
                .tpEvento(NFEvent.CANCEL.getCode())
                .cOrgao(conf.uf().getCode())
                .tpAmb(conf.environment().getCode())
                .detEvento(DetCancelEvent.builder().nProt(protocol).xJust(motive).build())
                .build()).build();
    }

    public static NfEvent nfeCancel(NfProcessed processed, String motive, String sequenceNumber, Config conf) {
        return nfeCancel(processed.getProtNFe().getInfProt().getChNFe(), processed.getProtNFe().getInfProt().getNProt(), motive, sequenceNumber, conf);
    }

    public static SendNfEvent cancel(String chaveDeAcesso, String protocolo, String motivo, String nseq, Config conf) {
        return sendEvent(nfeCancel(chaveDeAcesso, protocolo, motivo, nseq, conf));
    }

    public static SendNfEvent cancel(List<NfProcessed> processeds, String motive, NfConfig config) {
        return sendEvent(processeds.stream().map(it -> nfeCancel(it, motive, "1", config)).collect(Collectors.toList()));
    }

    public static SendNfEvent cancel(NfProcessed processed, String motive, NfConfig config) {
        return cancel(Collections.singletonList(processed), motive, config);
    }

    public static SendNfEvent correctionLetter(String accessKey, String correction, String nseq, Config conf) {
        return sendEvent(Collections.singletonList(NfEvent.builder()
                .infEvento(NfEvent.InfEvento
                        .builder()
                        .chNFe(accessKey)
                        .nSeqEvento(nseq)
                        .cnpj(conf.cnpj())
                        .tpEvento(NFEvent.CORRECTION_LETTER.getCode())
                        .cpf(conf.cpf())
                        .cOrgao(conf.uf().getCode())
                        .tpAmb(conf.environment().getCode())
                        .detEvento(DetCorrectionLetterEvent
                                .builder()
                                .xCorrecao(correction)
                                .xCondUso(conf.uf() == UF.MT ? DetCorrectionLetterEvent.XCONDUSO_2 : DetCorrectionLetterEvent.XCONDUSO_1)
                                .build()).build()).build()));
    }

    public static NfEvent buildInterestedActor(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization, Config config) {
        return NfEvent.builder()
                .infEvento(NfEvent
                        .InfEvento.builder()
                        .chNFe(accessKey)
                        .tpEvento(NFEvent.INTERESTED_ACTOR.getCode())
                        .cOrgao(config.uf().getCode())
                        .tpAmb(config.environment().getCode())
                        .cnpj(config.cnpj())
                        .cpf(config.cpf()).nSeqEvento(nseq)
                        .detEvento(DetInterestedActorEvent
                                .builder()
                                .autXML(DetInterestedActorEvent.AutXML.builder()
                                        .cpf(DfeOptional.ofEmpty(StringUtils.extractDigits(cpf)).orElse(null))
                                        .cnpj(DfeOptional.ofEmpty(StringUtils.extractDigits(cnpj)).orElse(null))
                                        .build())
                                .tpAutorizacao(authorization.getCode())
                                .cOrgaoAutor(config.uf().getCode()).build())
                        .build())
                .build();
    }

    public static SendNfEvent interestedActor(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization, Config config) {
        return sendEvent(buildInterestedActor(accessKey, cpf, cnpj, nseq, authorization, config));
    }

    public static SendNfEvent interestedActor(String accessKey, String cpf, String cnpj, Config config) {
        return interestedActor(accessKey, cpf, cnpj, "1", config);
    }

    public static SendNfEvent interestedActor(String accessKey, String cpf, String cnpj, String nseq, Config config) {
        return interestedActor(accessKey, cpf, cnpj, nseq, NFDownloadAuthorization.YES, config);
    }


    public static SendNfEvent operationConfirmation(String accessKey, String sequenceNumber, Config conf) {
        return sendEvent(NfEvent
                .builder()
                .infEvento(NfEvent.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_CONFIRMATION.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(accessKey)
                        .nSeqEvento(sequenceNumber)
                        .detEvento(DetManifestationEvent.builder().descEvento(NFEvent.OPERATION_CONFIRMATION.getDescription()).build())
                        .build())
                .build());
    }

    public static SendNfEvent operationScience(List<Pair<String, String>> pairs, Config conf) {
        return sendEvent(pairs.stream().map(it -> NfEvent
                .builder()
                .infEvento(NfEvent.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_SCIENCE.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(it.first())
                        .nSeqEvento(it.second())
                        .detEvento(DetManifestationEvent.builder().descEvento(NFEvent.OPERATION_SCIENCE.getDescription()).build())
                        .build())
                .build()).collect(Collectors.toList()));
    }

    public static SendNfEvent operationIgnorance(String accessKey, String sequenceNumber, String motive, Config conf) {
        return sendEvent(NfEvent
                .builder()
                .infEvento(NfEvent.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_IGNORANCE.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(accessKey)
                        .nSeqEvento(sequenceNumber)
                        .detEvento(DetManifestationEvent.builder().descEvento(NFEvent.OPERATION_IGNORANCE.getDescription()).xJust(motive).build())
                        .build())
                .build());
    }

    public static SendNfEvent operationNotPerformed(String accessKey, String sequenceNumber, String motive, Config conf) {
        return sendEvent(NfEvent
                .builder()
                .infEvento(NfEvent.InfEvento
                        .builder()
                        .tpEvento(NFEvent.OPERATION_NOT_PERFORMED.getCode())
                        .cOrgao(UF.RFB.getCode())
                        .tpAmb(conf.environment().getCode())
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .chNFe(accessKey)
                        .nSeqEvento(sequenceNumber)
                        .detEvento(DetManifestationEvent.builder().descEvento(NFEvent.OPERATION_NOT_PERFORMED.getDescription()).xJust(motive).build())
                        .build())
                .build());
    }


    public static SendNfEvent substituteCancel(String accessKey, String accessKeyRef, String protocol, String justification, String sequence, Config conf) {
        return sendEvent(NfEvent
                .builder()
                .infEvento(NfEvent.InfEvento
                        .builder()
                        .chNFe(accessKey)
                        .nSeqEvento(sequence)
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .cOrgao(conf.uf().getCode())
                        .tpEvento(NFEvent.SUBSTITUTE_CANCEL.getCode())
                        .tpAmb(conf.environment().getCode())
                        .detEvento(DetSubstituteCancelEvent
                                .builder()
                                .chNFeRef(accessKeyRef)
                                .cOrgaoAutor(conf.uf().getCode())
                                .nProt(protocol)
                                .xJust(justification)
                                .build())
                        .build())
                .build());
    }

    public static DetEpecEvent epecDetEvent(String emissionDate, NFType type, String stateRegistration, TUf uf, String cnpj, String cpf, String foreignId, String recipientStateRegistration, String totalValue, String totalIcms, String totalIcmsSt, NfConfig config) {
        return DetEpecEvent.builder().dhEmi(emissionDate).tpNF(type.getCode()).cOrgaoAutor(config.uf().getCode()).ie(stateRegistration).dest(DetEpecEvent.Dest.builder().cnpj(cnpj).uf(uf).cpf(cpf).idEstrangeiro(foreignId).ie(recipientStateRegistration).vnf(totalValue).vicms(totalIcms).vst(totalIcmsSt).build()).build();
    }

    public static NfEvent.InfEvento epecInfEvento(String accessKey, DetEpecEvent detEvento, Config config) {
        return NfEvent.InfEvento.builder()
                .chNFe(accessKey)
                .tpEvento(NFEvent.EPEC.getCode())
                .tpAmb(config.environment().getCode())
                .cnpj(config.cnpj())
                .cpf(config.cpf())
                .cOrgao(UF.RFB.getCode())
                .nSeqEvento("1")
                .detEvento(detEvento)
                .build();
    }

    public static NfEvent.InfEvento epecInfEvento(Nf n, NfConfig config) {
        return epecInfEvento(
                AccessKeyParserFactory.nfe().fromId(n.toObject().getInfNFe().getId()),
                epecDetEvent(n.getInfNFe().getIde().getDhEmi(), NFType.valueOfCode(n.getInfNFe().getIde().getTpNF()), n.getInfNFe().getEmit().getIe(), TUf.valueOf(n.getInfNFe().getEmit().getEnderEmit().getUf().name()), n.getInfNFe().getEmit().getCnpj(), n.getInfNFe().getEmit().getCpf(), n.getInfNFe().getDest().getIdEstrangeiro(), n.getInfNFe().getDest().getIe(), n.getInfNFe().getTotal().getIcmsTot().getVnf(), n.getInfNFe().getTotal().getIcmsTot().getVicms(), n.getInfNFe().getTotal().getIcmsTot().getVst(), config),
                config);
    }

    public static SendNfEvent epecEvent(String accessKey, String emissionDate, NFType type, String stateRegistration, TUf uf, String cnpj, String cpf, String foreignId, String recipientStateRegistration, String totalValue, String totalIcms, String totalIcmsSt, NfConfig config) {
        return epecEvent(accessKey, epecDetEvent(emissionDate, type, stateRegistration, uf, cnpj, cpf, foreignId, recipientStateRegistration, totalValue, totalIcms, totalIcmsSt, config), config);
    }

    public static SendNfEvent epecEvent(Nf n, NfConfig config) {
        return epecEvent(AccessKeyParserFactory.nfe().fromId(n.toObject().getInfNFe().getId()), n.getInfNFe().getIde().getDhEmi(), NFType.valueOfCode(n.getInfNFe().getIde().getTpNF()), n.getInfNFe().getEmit().getIe(), TUf.valueOf(n.getInfNFe().getEmit().getEnderEmit().getUf().name()), n.getInfNFe().getEmit().getCnpj(), n.getInfNFe().getEmit().getCpf(), n.getInfNFe().getDest().getIdEstrangeiro(), n.getInfNFe().getDest().getIe(), n.getInfNFe().getTotal().getIcmsTot().getVnf(), n.getInfNFe().getTotal().getIcmsTot().getVicms(), n.getInfNFe().getTotal().getIcmsTot().getVst(), config);
    }

    public static SendNfEvent epecEvent(List<Nf> nfs, NfConfig config) {
        return sendEvent(nfs.stream().map(it -> NfEvent.builder().infEvento(epecInfEvento(it, config)).build()).collect(Collectors.toList()));
    }

    public static SendNfEvent epecEvent(String accessKey, DetEpecEvent detEvento, Config config) {
        return sendEvent(NfEvent.builder()
                .infEvento(epecInfEvento(accessKey, detEvento, config))
                .build());
    }
}

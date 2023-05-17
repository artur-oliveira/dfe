package com.softart.dfe.models.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEvento;
import com.softart.dfe.components.internal.ProjectProperties;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFAuthor;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import com.softart.dfe.enums.nf.version.NFEventVersion;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.DfeOptional;
import com.softart.dfe.util.StringUtils;
import com.softart.dfe.util.XMLStringUtils;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfeInterestedActor implements DFObject, XMLAdapter<NfeInterestedActor, TEvento> {

    @Builder.Default
    protected String versao = NFEventVersion.getDefault().getVersion();
    protected InfEvento infEvento;

    public static NfeInterestedActor build(String accessKey, String cpf, String cnpj, String nseq, NFDownloadAuthorization authorization, Config config) {
        return NfeInterestedActor.builder().infEvento(NfeInterestedActor.InfEvento.builder().chNFe(accessKey).tpAmb(config.environment().getCode()).cnpj(config.cnpj()).cpf(config.cpf()).nSeqEvento(nseq).detEvento(NfeInterestedActor.InfEvento.DetEvento.builder().autXML(NfeInterestedActor.InfEvento.DetEvento.AutXML.builder().cpf(DfeOptional.ofEmpty(StringUtils.extractDigits(cpf)).orElse(null)).cnpj(DfeOptional.ofEmpty(StringUtils.extractDigits(cnpj)).orElse(null)).build()).tpAutorizacao(authorization.getCode()).cOrgaoAutor(config.uf().getCode()).build()).build()).build();
    }

    @ToString
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfEvento implements DFObject, XMLAdapter<InfEvento, TEvento.InfEvento> {

        @Builder.Default
        protected String dhEvento = DateUtils.nowString();

        @Builder.Default
        protected String verEvento = NFEventVersion.getDefault().getVersion();
        @Builder.Default
        protected String tpEvento = NFEvent.INTERESTED_ACTOR.getCode();
        @Builder.Default
        protected String cOrgao = UF.RFB.getCode();
        protected String tpAmb;
        protected String cnpj;
        protected String cpf;
        protected String chNFe;
        protected String nSeqEvento;
        protected DetEvento detEvento;
        protected String id;

        @Override
        public TEvento.InfEvento toObject() {
            TEvento.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEvento(getTpEvento(), getChNFe(), getNSeqEvento()));
            evento.setId(getId());
            return evento;
        }

        @ToString
        @Getter
        @Setter
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DetEvento implements DFObject, XMLAdapter<DetEvento, TEvento.InfEvento.DetEvento> {
            @Builder.Default
            protected String versao = NFEventVersion.getDefault().getVersion();
            @Builder.Default
            protected String descEvento = NFEvent.INTERESTED_ACTOR.getDescription();
            protected String cOrgaoAutor;
            @Builder.Default
            protected String tpAutor = NFAuthor.ISSUER.getCode();
            @Builder.Default
            protected String verAplic = ProjectProperties.projectVersion;
            protected AutXML autXML;
            @Builder.Default
            protected String tpAutorizacao = NFDownloadAuthorization.YES.getCode();
            @Builder.Default
            protected String xCondUso = "O emitente ou destinatário da NF-e, declara que permite o transportador declarado no campo CNPJ/CPF deste evento a autorizar os transportadores subcontratados ou redespachados a terem acesso ao download da NF-e";

            @ToString
            @Getter
            @Setter
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class AutXML implements DFObject, XMLAdapter<AutXML, TEvento.InfEvento.DetEvento.AutXML> {
                protected String cnpj;
                protected String cpf;
            }
        }
    }

}

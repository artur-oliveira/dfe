package org.dfe.models.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEvento;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.DateUtils;
import org.dfe.util.XMLStringUtils;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfeCorrectionLetter implements DFObject, XMLAdapter<NfeCorrectionLetter, TEvento> {

    @Builder.Default
    protected String versao = NFEventVersion.getDefault().getVersion();
    protected InfEvento infEvento;

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
        protected String tpEvento = NFEvent.CORRECTION_LETTER.getCode();
        protected String cOrgao;
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

            public static final String CONDITION_1 = "A Carta de Correção é disciplinada pelo § 1º-A do art. 7º do Convênio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularização de erro ocorrido na emissão de documento fiscal, desde que o erro não esteja relacionado com: I - as variáveis que determinam o valor do imposto tais como: base de cálculo, alíquota, diferença de preço, quantidade, valor da operação ou da prestação; II - a correção de dados cadastrais que implique mudança do remetente ou do destinatário; III - a data de emissão ou de saída.";
            public static final String CONDITION_2 = "A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.";

            @Builder.Default
            protected String versao = NFEventVersion.getDefault().getVersion();
            @Builder.Default
            protected String descEvento = NFEvent.CORRECTION_LETTER.getDescription();
            protected String xCorrecao;
            @Builder.Default
            protected String xCondUso = DetEvento.CONDITION_1;
        }
    }

}

package org.dfe.models.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEvento;
import lombok.*;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.XMLNode;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import java.util.Map;
import java.util.Objects;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class DetCorrectionLetterEvent implements DFObject, XMLAdapter<DetCorrectionLetterEvent, TEvento.InfEvento.DetEvento> {
    public static final String XCONDUSO_1 = "A Carta de Correção é disciplinada pelo § 1º-A do art. 7º do Convênio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularização de erro ocorrido na emissão de documento fiscal, desde que o erro não esteja relacionado com: I - as variáveis que determinam o valor do imposto tais como: base de cálculo, alíquota, diferença de preço, quantidade, valor da operação ou da prestação; II - a correção de dados cadastrais que implique mudança do remetente ou do destinatário; III - a data de emissão ou de saída.";
    public static final String XCONDUSO_2 = "A Carta de Correcao e disciplinada pelo paragrafo 1o-A do art. 7o do Convenio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularizacao de erro ocorrido na emissao de documento fiscal, desde que o erro nao esteja relacionado com: I - as variaveis que determinam o valor do imposto tais como: base de calculo, aliquota, diferenca de preco, quantidade, valor da operacao ou da prestacao; II - a correcao de dados cadastrais que implique mudanca do remetente ou do destinatario; III - a data de emissao ou de saida.";

    @Builder.Default
    private String versao = NFEventVersion.getDefault().getVersion();
    @Builder.Default
    private String descEvento = NFEvent.CORRECTION_LETTER.getDescription();
    private String xCorrecao;
    @Builder.Default
    private String xCondUso = XCONDUSO_1;

    @Override
    @SneakyThrows
    public TEvento.InfEvento.DetEvento toObject() {
        TEvento.InfEvento.DetEvento evento = new TEvento.InfEvento.DetEvento();
        XMLNode node = new XMLNode("detEvento")
                .addAttribute("versao", getVersao())
                .addChild("descEvento", getDescEvento())
                .addChild("xCorrecao", getXCorrecao())
                .addChild("xCondUso", getXCondUso());

        for (Map.Entry<String, String> attr : node.getAttributes().entrySet()) {
            evento.getOtherAttributes().put(new QName(attr.getKey()), attr.getValue());
        }

        for (XMLNode child : node.getChildren()) {
            evento.getAny().add(child.toElement("http://www.portalfiscal.inf.br/nfe"));
        }
        return evento;
    }

    @Override
    public DetCorrectionLetterEvent fromObject(TEvento.InfEvento.DetEvento o) {
        o.getOtherAttributes().keySet().forEach(key -> {
            if (key.getLocalPart().equals("versao")) {
                setVersao(o.getOtherAttributes().get(key));
            }
        });

        setDescEvento(o.getAny().stream().filter(it -> Objects.equals(it.getTagName(), "descEvento")).findFirst().map(Node::getTextContent).orElse(null));
        setXCorrecao(o.getAny().stream().filter(it -> Objects.equals(it.getTagName(), "xCorrecao")).findFirst().map(Node::getTextContent).orElse(null));
        setXCondUso(o.getAny().stream().filter(it -> Objects.equals(it.getTagName(), "xCondUso")).findFirst().map(Node::getTextContent).orElse(null));

        return XMLAdapter.super.fromObject(o);
    }
}

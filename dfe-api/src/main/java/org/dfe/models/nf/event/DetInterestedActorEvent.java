package org.dfe.models.nf.event;


import br.inf.portalfiscal.nfe.event_generic.TEvento;
import lombok.*;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.enums.nf.NFAuthor;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.interested_actor.NFDownloadAuthorization;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.XMLNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import java.util.Map;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class DetInterestedActorEvent implements DFObject, XMLAdapter<DetInterestedActorEvent, TEvento.InfEvento.DetEvento> {
    @Builder.Default
    private String versao = NFEventVersion.getDefault().getVersion();
    @Builder.Default
    private String descEvento = NFEvent.INTERESTED_ACTOR.getDescription();
    private String cOrgaoAutor;
    @Builder.Default
    private String tpAutor = NFAuthor.ISSUER.getCode();
    @Builder.Default
    private String verAplic = ProjectProperties.projectVersion;
    private AutXML autXML;
    @Builder.Default
    private String tpAutorizacao = NFDownloadAuthorization.YES.getCode();
    @Builder.Default
    private String xCondUso = "O emitente ou destinatário da NF-e, declara que permite o transportador declarado no campo CNPJ/CPF deste evento a autorizar os transportadores subcontratados ou redespachados a terem acesso ao download da NF-e";

    @ToString
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AutXML {
        private String cnpj;
        private String cpf;
    }

    @Override
    @SneakyThrows
    public TEvento.InfEvento.DetEvento toObject() {
        TEvento.InfEvento.DetEvento evento = new TEvento.InfEvento.DetEvento();

        XMLNode node = new XMLNode("detEvento")
                .addAttribute("versao", getVersao())
                .addChild("descEvento", getDescEvento())
                .addChild("cOrgaoAutor", getCOrgaoAutor())
                .addChild("tpAutor", getTpAutor())
                .addChild("verAplic", getVerAplic())
                .addChild(new XMLNode("autXML")
                        .addChild("CNPJ", getAutXML().getCnpj())
                        .addChild("CPF", getAutXML().getCpf()))
                .addChild("tpAutorizacao", getTpAutorizacao())
                .addChild("xCondUso", getXCondUso());

        // atributos
        for (Map.Entry<String, String> attr : node.getAttributes().entrySet()) {
            evento.getOtherAttributes().put(new QName(attr.getKey()), attr.getValue());
        }

        // elementos filhos
        for (XMLNode child : node.getChildren()) {
            evento.getAny().add(child.toElement("http://www.portalfiscal.inf.br/nfe"));
        }

        return evento;
    }

    @Override
    public DetInterestedActorEvent fromObject(TEvento.InfEvento.DetEvento o) {
        // atributos
        o.getOtherAttributes().forEach((key, value) -> {
            if ("versao".equals(key.getLocalPart())) setVersao(value);
        });

        // filhos diretos
        setDescEvento(o.getAny().stream().filter(it -> "descEvento".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setCOrgaoAutor(o.getAny().stream().filter(it -> "cOrgaoAutor".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setTpAutor(o.getAny().stream().filter(it -> "tpAutor".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(NFAuthor.ISSUER.getCode()));
        setVerAplic(o.getAny().stream().filter(it -> "verAplic".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(ProjectProperties.projectVersion));
        setTpAutorizacao(o.getAny().stream().filter(it -> "tpAutorizacao".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(NFDownloadAuthorization.YES.getCode()));
        setXCondUso(o.getAny().stream().filter(it -> "xCondUso".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(""));

        // filhos aninhados (autXML)
        Node autNode = o.getAny().stream().filter(it -> "autXML".equals(it.getTagName()))
                .findFirst().orElse(null);
        if (autNode != null) {
            AutXML aut = new AutXML();
            NodeList children = autNode.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if ("CNPJ".equals(child.getNodeName())) aut.setCnpj(child.getTextContent());
                if ("CPF".equals(child.getNodeName())) aut.setCpf(child.getTextContent());
            }
            setAutXML(aut);
        }

        return this;
    }


}
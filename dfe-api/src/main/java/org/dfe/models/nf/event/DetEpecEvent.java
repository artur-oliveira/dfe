package org.dfe.models.nf.event;


import br.inf.portalfiscal.nfe.event_generic.TEvento;
import br.inf.portalfiscal.nfe.send.TUf;
import lombok.*;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.enums.nf.NFAuthor;
import org.dfe.enums.nf.NFEvent;
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
public final class DetEpecEvent implements DFObject, XMLAdapter<DetEpecEvent, TEvento.InfEvento.DetEvento> {
    @Builder.Default
    private String versao = NFEventVersion.getDefault().getVersion();
    @Builder.Default
    private String descEvento = NFEvent.EPEC.getDescription();
    private String cOrgaoAutor;
    @Builder.Default
    private String tpAutor = NFAuthor.ISSUER.getCode();
    @Builder.Default
    private String verAplic = ProjectProperties.projectVersion;
    private String dhEmi;
    private String tpNF;
    private String ie;
    private Dest dest;

    @ToString
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Dest {
        private TUf uf;
        private String cnpj;
        private String cpf;
        private String idEstrangeiro;
        private String ie;
        private String vnf;
        private String vicms;
        private String vst;
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
                .addChild("dhEmi", getDhEmi())
                .addChild("tpNF", getTpNF())
                .addChild("IE", getIe());

        if (dest != null) {
            XMLNode destNode = new XMLNode("dest")
                    .addChild("UF", dest.getUf() != null ? dest.getUf().name() : null)
                    .addChild("CNPJ", dest.getCnpj())
                    .addChild("PF", dest.getCpf())
                    .addChild("idEstrangeiro", dest.getIdEstrangeiro())
                    .addChild("IE", dest.getIe())
                    .addChild("vNF", dest.getVnf())
                    .addChild("vICMS", dest.getVicms())
                    .addChild("vST", dest.getVst());

            node.addChild(destNode);
        }

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
    public DetEpecEvent fromObject(TEvento.InfEvento.DetEvento o) {
        // atributos
        o.getOtherAttributes().forEach((key, value) -> {
            if ("versao".equals(key.getLocalPart())) setVersao(value);
        });

        // filhos diretos
        setDescEvento(o.getAny().stream().filter(it -> "descEvento".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(NFEvent.EPEC.getDescription()));
        setCOrgaoAutor(o.getAny().stream().filter(it -> "cOrgaoAutor".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setTpAutor(o.getAny().stream().filter(it -> "tpAutor".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(NFAuthor.ISSUER.getCode()));
        setVerAplic(o.getAny().stream().filter(it -> "verAplic".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(ProjectProperties.projectVersion));
        setDhEmi(o.getAny().stream().filter(it -> "dhEmi".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setTpNF(o.getAny().stream().filter(it -> "tpNF".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setIe(o.getAny().stream().filter(it -> "ie".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));

        // dest
        o.getAny().stream().filter(it -> "dest".equals(it.getTagName()))
                .findFirst().ifPresent(destEl -> {
                    Dest d = new Dest();
                    NodeList nodes = destEl.getChildNodes();
                    for (int i = 0; i < nodes.getLength(); i++) {
                        Node n = nodes.item(i);
                        switch (n.getNodeName()) {
                            case "uf" -> d.setUf(n.getTextContent() != null ? TUf.valueOf(n.getTextContent()) : null);
                            case "cnpj" -> d.setCnpj(n.getTextContent());
                            case "cpf" -> d.setCpf(n.getTextContent());
                            case "idEstrangeiro" -> d.setIdEstrangeiro(n.getTextContent());
                            case "ie" -> d.setIe(n.getTextContent());
                            case "vNF" -> d.setVnf(n.getTextContent());
                            case "vICMS" -> d.setVicms(n.getTextContent());
                            case "vST" -> d.setVst(n.getTextContent());
                        }
                    }
                    setDest(d);
                });

        return this;
    }

}
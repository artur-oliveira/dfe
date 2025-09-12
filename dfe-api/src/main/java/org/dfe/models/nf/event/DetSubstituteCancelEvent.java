package org.dfe.models.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEvento;
import lombok.*;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.enums.nf.NFAuthor;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.XMLNode;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import java.util.Map;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class DetSubstituteCancelEvent implements DFObject, XMLAdapter<DetSubstituteCancelEvent, TEvento.InfEvento.DetEvento> {
    @Builder.Default
    private String versao = NFEventVersion.getDefault().getVersion();
    @Builder.Default
    private String descEvento = NFEvent.SUBSTITUTE_CANCEL.getDescription();
    private String cOrgaoAutor;
    @Builder.Default
    private String tpAutor = NFAuthor.ISSUER.getCode();
    @Builder.Default
    private String verAplic = ProjectProperties.displayVersion();
    private String nProt;
    private String xJust;
    private String chNFeRef;

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
                .addChild("nProt", getNProt())
                .addChild("xJust", getXJust())
                .addChild("chNFeRef", getChNFeRef());

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
    public DetSubstituteCancelEvent fromObject(TEvento.InfEvento.DetEvento o) {
        // atributos
        o.getOtherAttributes().forEach((key, value) -> {
            if ("versao".equals(key.getLocalPart())) setVersao(value);
        });

        // filhos diretos
        setDescEvento(o.getAny().stream().filter(it -> "descEvento".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(NFEvent.SUBSTITUTE_CANCEL.getDescription()));
        setCOrgaoAutor(o.getAny().stream().filter(it -> "cOrgaoAutor".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setTpAutor(o.getAny().stream().filter(it -> "tpAutor".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(NFAuthor.ISSUER.getCode()));
        setVerAplic(o.getAny().stream().filter(it -> "verAplic".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(ProjectProperties.displayVersion()));
        setNProt(o.getAny().stream().filter(it -> "nProt".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setXJust(o.getAny().stream().filter(it -> "xJust".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));
        setChNFeRef(o.getAny().stream().filter(it -> "chNFeRef".equals(it.getTagName()))
                .findFirst().map(Node::getTextContent).orElse(null));

        return this;
    }
}

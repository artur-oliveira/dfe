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
public final class DetCancelEvent implements DFObject, XMLAdapter<DetCancelEvent, TEvento.InfEvento.DetEvento> {
    @Builder.Default
    private String versao = NFEventVersion.getDefault().getVersion();
    @Builder.Default
    private String descEvento = NFEvent.CANCEL.getDescription();
    private String nProt;
    private String xJust;

    @Override
    @SneakyThrows
    public TEvento.InfEvento.DetEvento toObject() {
        TEvento.InfEvento.DetEvento evento = new TEvento.InfEvento.DetEvento();
        XMLNode node = new XMLNode("detEvento")
                .addAttribute("versao", getVersao())
                .addChild("descEvento", getDescEvento())
                .addChild("nProt", getNProt())
                .addChild("xJust", getXJust());

        for (Map.Entry<String, String> attr : node.getAttributes().entrySet()) {
            evento.getOtherAttributes().put(new QName(attr.getKey()), attr.getValue());
        }

        for (XMLNode child : node.getChildren()) {
            evento.getAny().add(child.toElement("http://www.portalfiscal.inf.br/nfe"));
        }
        return evento;
    }

    @Override
    public DetCancelEvent fromObject(TEvento.InfEvento.DetEvento o) {
        o.getOtherAttributes().keySet().forEach(key -> {
            if (key.getLocalPart().equals("versao")) {
                setVersao(o.getOtherAttributes().get(key));
            }
        });

        setDescEvento(o.getAny().stream().filter(it -> Objects.equals(it.getTagName(), "descEvento")).findFirst().map(Node::getTextContent).orElse(null));
        setNProt(o.getAny().stream().filter(it -> Objects.equals(it.getTagName(), "nProt")).findFirst().map(Node::getTextContent).orElse(null));
        setXJust(o.getAny().stream().filter(it -> Objects.equals(it.getTagName(), "xJust")).findFirst().map(Node::getTextContent).orElse(null));

        return XMLAdapter.super.fromObject(o);
    }
}

package org.dfe.util;

import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Map;
import java.util.Objects;

public final class XMLBuilder {

    private XMLBuilder() {}

    @SneakyThrows
    public static Element build(XMLNode node, String namespace, Document doc) {
        if (Objects.isNull(doc)) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.newDocument();
        }
        // Cria elemento usando namespace se informado
        Element el = namespace != null
                ? doc.createElementNS(namespace, node.getName())
                : doc.createElement(node.getName());

        // adiciona atributos
        for (Map.Entry<String, String> attr : node.getAttributes().entrySet()) {
            el.setAttribute(attr.getKey(), attr.getValue());
        }

        // filhos
        for (XMLNode child : node.getChildren()) {
            el.appendChild(child.toElement(namespace, doc));
        }

        // valor
        if (node.getValue() != null && !node.getValue().isEmpty()) {
            el.setTextContent(node.getValue());
        }

        return el;
    }
}

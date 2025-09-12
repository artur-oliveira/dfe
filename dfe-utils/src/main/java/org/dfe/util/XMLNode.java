package org.dfe.util;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.*;

@Getter
@Setter
public final class XMLNode {

    private final String name;
    private final List<XMLNode> children = new ArrayList<>();
    private final Map<String, String> attributes = new LinkedHashMap<>();
    private String value;

    public XMLNode(String name) {
        this(name, null);
    }

    public XMLNode(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public XMLNode addAttribute(String key, String val) {
        this.attributes.put(key, val);
        return this;
    }

    public XMLNode addChild(XMLNode child) {
        // Never add empty nodes
        if (Objects.isNull(child.getValue()) && child.getChildren().isEmpty()) {
            return this;
        }
        this.children.add(child);
        return this;
    }

    public XMLNode addChild(String name, String value) {
        return addChild(new XMLNode(name, value));
    }

    public Element toElement(String namespace, Document doc) {
        return XMLBuilder.build(this, namespace, doc);
    }

    // Overload sem namespace e doc
    public Element toElement(String namespace) {
        return toElement(namespace, null);
    }

    @Deprecated
    public Element toElement() {
        return toElement(null, null);
    }

}

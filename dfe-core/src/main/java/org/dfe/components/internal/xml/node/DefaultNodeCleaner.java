package org.dfe.components.internal.xml.node;

import lombok.AccessLevel;
import lombok.Getter;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import java.util.*;

@Getter(AccessLevel.PRIVATE)
final class DefaultNodeCleaner extends NodeCleanerFactory {

    private final Map<String, String> overridingNamespaces;

    DefaultNodeCleaner() {
        this.overridingNamespaces = Map.of("NFe", "http://www.portalfiscal.inf.br/nfe", "CTe", "http://www.portalfiscal.inf.br/cte", "MDFe", "http://www.portalfiscal.inf.br/mdfe");
    }

    /**
     * This function takes a node and a map of nodes to their parents, and recursively cleans the node and all of its
     * children
     *
     * @param node The node to clean.
     */
    @Override
    public void clean(Node node) {
        clean(node, new HashMap<>());
        postRemoveNs(node, new ArrayList<>());
    }


    /**
     * It removes all namespace prefixes from the XML document and stores the namespace URI in a map
     *
     * @param node             The node to be cleaned.
     * @param namespaceElement A map of namespace prefixes to namespace URIs.
     */
    private void clean(Node node, Map<String, String> namespaceElement) {
        NodeList nodes = node.getChildNodes();

        if (node instanceof Element el) {

            if (Objects.nonNull(el.getPrefix()) && namespaceElement.containsKey(el.getPrefix())) {
                el.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, XMLConstants.XMLNS_ATTRIBUTE, namespaceElement.get(el.getPrefix()));
                namespaceElement.remove(el.getPrefix());
            }

            if (getOverridingNamespaces().containsKey(el.getLocalName())) {
                el.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, XMLConstants.XMLNS_ATTRIBUTE, getOverridingNamespaces().get(el.getLocalName()));
            }

            Collection<Attr> removeAttrs = new ArrayList<>();
            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                if (node.getAttributes().item(i) instanceof Attr ns) {
                    if (Objects.equals(ns.getName(), XMLConstants.XMLNS_ATTRIBUTE) || !ns.getName().startsWith(XMLConstants.XMLNS_ATTRIBUTE))
                        continue;

                    removeAttrs.add(ns);
                    namespaceElement.put(ns.getLocalName(), ns.getValue());
                }
            }

            removeAttrs.forEach(el::removeAttributeNode);
            el.setPrefix(XMLConstants.DEFAULT_NS_PREFIX);
        }

        for (int i = 0; i < nodes.getLength(); i++) {
            clean(nodes.item(i), namespaceElement);
        }
    }

    /**
     * This function removes specified namespaces from an XML node and its child nodes.
     *
     * @param node The root node of an XML document or a subtree of the XML document.
     * @param ns   A list of namespace URIs to be removed from the XML document.
     */
    private void postRemoveNs(Node node, List<String> ns) {
        NodeList nodes = node.getChildNodes();

        if (node instanceof Element el && !getOverridingNamespaces().containsKey(el.getLocalName())) {
            Collection<Attr> removeAttrs = new ArrayList<>();
            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                if (node.getAttributes().item(i) instanceof Attr attr) {
                    if (Objects.equals(attr.getName(), XMLConstants.XMLNS_ATTRIBUTE)) {
                        if (ns.contains(attr.getValue())) {
                            removeAttrs.add(attr);
                        } else {
                            ns.add(attr.getValue());
                        }
                    }
                }
            }

            removeAttrs.forEach(el::removeAttributeNode);
            el.setPrefix(XMLConstants.DEFAULT_NS_PREFIX);
        }

        for (int i = 0; i < nodes.getLength(); i++) {
            postRemoveNs(nodes.item(i), ns);
        }
    }

}

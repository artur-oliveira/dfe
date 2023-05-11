package com.softart.dfe.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;

public final class XMLUtils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `XMLStringUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private XMLUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    public static Transformer getTransformer() throws TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        return transformer;
    }

    public static Element toElement(JAXBElement<?> o, Marshaller marshaller) throws JAXBException {
        DOMResult res = new DOMResult();
        marshaller.marshal(o, res);
        return ((Document) res.getNode()).getDocumentElement();
    }
}

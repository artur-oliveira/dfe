package com.softart.dfe.util;

import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.exceptions.xml.UnmarshallException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Objects;

public final class XMLUtils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `XMLStringUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private XMLUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * This function returns a Transformer object that can be used to transform XML documents, with the output property set
     * to omit the XML declaration.
     *
     * @return The method is returning an instance of the Transformer class.
     */
    public static Transformer getTransformer() throws TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        return transformer;
    }

    /**
     * This function converts a JAXB element to a DOM element using a marshaller.
     *
     * @param o          o is a JAXB element that represents an object to be marshalled into an XML document. It can be any object
     *                   that has been annotated with JAXB annotations.
     * @param marshaller The marshaller is an object that is responsible for converting Java objects into XML data and
     *                   writing the XML data to an output stream or a DOM tree. It is typically created using a JAXBContext object and
     *                   configured with various options such as encoding, schema validation, and namespace prefixes. In this method, the
     *                   marshaller
     * @return The method is returning a DOM Element object that represents the root element of the XML document generated
     * by marshalling the given JAXB element using the provided marshaller.
     */
    public static Element toElement(JAXBElement<?> o, Marshaller marshaller) {
        try {
            DOMResult res = new DOMResult();
            marshaller.marshal(o, res);
            return ((Document) res.getNode()).getDocumentElement();
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    /**
     * This function marshalls a given object using a JAXBContext and returns the resulting XML string with cleaned
     * namespaces.
     *
     * @param context JAXBContext is a class that provides a way to interact with Java Architecture for XML Binding (JAXB)
     *                framework. It is used to provide a way to convert Java objects into XML and vice versa.
     * @param o       The parameter "o" is a JAXBElement object that contains the data to be marshalled into XML format. The type
     *                of the object can vary depending on the specific implementation.
     * @return The method is returning a String that represents the XML representation of the object passed as a
     * JAXBElement, after it has been marshalled using the JAXBContext provided. The returned String has also been
     * processed to remove any unnecessary namespace declarations using the XMLStringUtils.cleanNamespace() method.
     */
    public static String marshall(JAXBContext context, JAXBElement<?> o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                context.createMarshaller().marshal(o, sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    /**
     * This function returns the value of a JAXB element object as a specified type.
     *
     * @param o        The object to be checked and returned as the expected type.
     * @param expected The expected class type that the input object should be converted to.
     * @param xml      The `xml` parameter is a string that represents an XML document. It is used in the `UnmarshallException`
     *                 message to provide context about the error that occurred.
     * @return The method is returning an object of type T, which is the expected type specified by the Class<T> parameter.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getJaxbElementValue(Object o, Class<T> expected, String xml) {
        if (!Objects.equals(o.getClass(), expected))
            throw new UnmarshallException("cannot convert to " + expected.getSimpleName(), xml);
        return (T) o;
    }

    /**
     * This Java function converts an XML element to a string and removes any namespace information.
     *
     * @param el The parameter "el" is an object of type "Element", which represents an element in an XML document.
     * @return The method is returning a string representation of the XML element passed as a parameter, with the namespace
     * removed.
     */
    public static String elementToString(Element el) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(el), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }
}

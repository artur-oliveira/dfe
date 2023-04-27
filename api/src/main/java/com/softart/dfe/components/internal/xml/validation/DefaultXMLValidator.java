package com.softart.dfe.components.internal.xml.validation;

import com.softart.dfe.exceptions.xml.XSDValidationException;
import com.softart.dfe.models.internal.xml.XMLValidation;
import com.softart.dfe.util.RequireUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Getter(AccessLevel.PRIVATE)
final class DefaultXMLValidator extends XMLValidatorFactory {

    private final Map<String, Schema> schemaMapping = new ConcurrentHashMap<>();

    /**
     * It takes an XMLValidation object, which contains the XML and XSD to validate, and throws an XSDValidationException
     * if the XML is invalid
     *
     * @param validation This is a POJO that contains the XML and XSD to be validated.
     */
    public void validateXML(XMLValidation validation) throws XSDValidationException {
        try {

            Schema schema;
            synchronized (getSchemaMapping()) {
                schema = getSchemaMapping().get(validation.getXsd());
                schema = Optional.ofNullable(schema).orElseGet(() -> getSchema(validation.getXsd()));
            }
            try (StringReader reader = new StringReader(validation.getXml())) {
                schema.newValidator().validate(new StreamSource(reader));
            }
        } catch (Exception e) {
            throw new XSDValidationException(e, validation.getXml());
        }
    }

    @SneakyThrows
    private Schema getSchema(String xsd) {
        final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, Boolean.FALSE);
        factory.setResourceResolver(new ResourceResolver(xsd));
        try (InputStream is = RequireUtils.nonNull(DefaultXMLValidator.class.getClassLoader().getResourceAsStream(xsd), "failed to find xsd with name " + xsd)) {
            Schema schema = factory.newSchema(new StreamSource(is));
            getSchemaMapping().put(xsd, schema);
            return schema;
        }
    }

    /**
     * > This class is used to resolve external resources, such as DTDs and schemas, that are referenced in an XML document
     */
    @Getter
    private static final class ResourceResolver implements LSResourceResolver {

        private final String xsdRootPath;

        public ResourceResolver(String xsd) {
            this.xsdRootPath = xsd.substring(0, xsd.lastIndexOf("/") + 1);
        }

        /**
         * > It takes the systemId of the xsd file, and returns an InputStream of the xsd file
         *
         * @param type         The type of the resource being resolved.
         * @param namespaceURI The namespace of the resource being resolved.
         * @param publicId     The public identifier of the external entity being referenced, or null if none was supplied.
         * @param systemId     The system identifier (URI) of the resource being resolved.
         * @param baseURI      The base URI to be used (see section 5.1.4 in [XML Base]). If the baseURI is null, the behavior is
         * @return An LSInput object.
         */
        public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {

            InputStream resourceAsStream = ResourceResolver.class.getClassLoader().getResourceAsStream(xsdRootPath + systemId);
            Objects.requireNonNull(resourceAsStream, String.format("Could not find the specified xsd file: %s", systemId));

            return new Input(publicId, systemId, baseURI, resourceAsStream, "UTF-8");
        }

        /**
         * This class implements the LSInput interface, which is used by the DOM parser to read XML documents.
         */
        @Getter
        @Setter
        public static class Input implements LSInput {

            protected String publicId = null;
            protected String systemId = null;
            protected String baseSystemId = null;
            protected InputStream byteStream = null;
            protected Reader characterStream = null;
            protected String stringData = null;
            protected String baseURI = null;
            protected String encoding = null;
            protected boolean certifiedText = false;

            public Input(String publicId, String systemId, String baseSystemId, InputStream byteStream, String encoding) {
                setPublicId(publicId);
                setSystemId(systemId);
                setBaseSystemId(baseSystemId);
                setByteStream(byteStream);
                setEncoding(encoding);
            }


            @Override
            public boolean getCertifiedText() {
                return certifiedText;
            }

            @Override
            public void setCertifiedText(boolean certifiedText) {
                this.certifiedText = certifiedText;
            }
        }

    }
}

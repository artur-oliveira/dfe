package org.dfe.components.internal.xml.validation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.dfe.exceptions.xml.XSDValidationException;
import org.dfe.interfaces.xml.XMLValidator;
import org.dfe.models.internal.xml.XMLValidation;
import org.dfe.util.RequireUtils;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Log4j2
@Getter(AccessLevel.PRIVATE)
public final class DefaultXMLValidator implements XMLValidator {

    private static final List<String> DEFAULT_SCHEMAS = Arrays.asList(
            // CT-e
            "xsds/cte/PL_CTe_400/cte_v4.00.xsd",
            "xsds/cte/PL_CTe_400/cteModalRodoviario_v4.00.xsd",
            "xsds/cte/PL_CTe_400/eventoCTe_v4.00.xsd",
            "xsds/cte/PL_CTe_400/evCancCTe_v4.00.xsd",
            // NF-e
            "xsds/nfe/PL_010b_NT2025_002_v1.21/enviNFe_v4.00.xsd",
            "xsds/nfe/PL_010b_NT2025_002_v1.21/consStatServ_v4.00.xsd",
            "xsds/nfe/Evento_Generico_PL_v1.01/envEvento_v1.00.xsd",
            "xsds/nfe/Evento_Generico_PL_v1.01/e110110_v1.00.xsd",
            "xsds/nfe/Evento_Generico_PL_v1.01/e110111_v1.00.xsd",
            // MDF-e
            "xsds/mdfe/PL_MDFe_300b_NT012025_100/eventoMDFe_v3.00.xsd",
            "xsds/mdfe/PL_MDFe_300b_NT012025_100/evCancMDFe_v3.00.xsd",
            "xsds/mdfe/PL_MDFe_300b_NT012025_100/evEncMDFe_v3.00.xsd",
            "xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfe_v3.00.xsd",
            "xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeModalRodoviario_v3.00.xsd"
    );

    private final List<SaxParserExceptionHandler> handlers = List.of(
            new SaxPatternExceptionHandler(),
            new SaxComplexTypeExceptionHandler()
    );

    @Getter(AccessLevel.PACKAGE)
    private final Map<String, Schema> schemaMapping = new ConcurrentHashMap<>();

    public DefaultXMLValidator() {
        DEFAULT_SCHEMAS.forEach(this::getSchema);
    }

    @Override
    public void validateXML(XMLValidation validation) throws XSDValidationException {
        try {
            Schema schema = getSchemaMapping().computeIfAbsent(validation.xsd(), this::loadSchema);
            try (StringReader reader = new StringReader(validation.xml())) {
                schema.newValidator().validate(new StreamSource(reader));
            }
        } catch (SAXParseException e) {
            log.error(e.getMessage());
            throw handlers.stream()
                    .filter(it -> it.accept(e))
                    .findFirst()
                    .map(it -> it.handleSaxParseException(e, validation))
                    .orElseGet(() -> new XSDValidationException(e, validation.xml()));
        } catch (SAXException | IOException e) {
            throw new XSDValidationException(e, validation.xml());
        }
    }

    @SneakyThrows
    private void getSchema(String xsd) {
        schemaMapping.computeIfAbsent(xsd, this::loadSchema);
    }

    @SneakyThrows
    Schema loadSchema(String xsd) {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
        factory.setResourceResolver(new ResourceResolver(xsd));
        try (InputStream is = RequireUtils.nonNull(
                DefaultXMLValidator.class.getClassLoader().getResourceAsStream(xsd),
                "failed to find xsd: " + xsd)) {
            return factory.newSchema(new StreamSource(is));
        }
    }

    private record ResourceResolver(String xsdRootPath) implements LSResourceResolver {
        private ResourceResolver(String xsdRootPath) {
            this.xsdRootPath = xsdRootPath.substring(0, xsdRootPath.lastIndexOf("/") + 1);
        }

        @Override
        public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
            InputStream resourceAsStream = Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream(xsdRootPath + systemId),
                    "Could not find XSD: " + systemId
            );
            return new Input(publicId, systemId, baseURI, resourceAsStream, "UTF-8");
        }

        /**
         * This class implements the LSInput interface, which is used by the DOM parser to read XML documents.
         */
        @Getter
        @Setter
        public final static class Input implements LSInput {

            private String publicId;
            private String systemId;
            private String baseSystemId;
            private InputStream byteStream;
            private String encoding;
            private boolean certifiedText = false;
            private Reader characterStream;
            private String stringData;
            private String baseURI;

            public Input(String publicId, String systemId, String baseSystemId, InputStream byteStream, String encoding) {
                this.publicId = publicId;
                this.systemId = systemId;
                this.baseSystemId = baseSystemId;
                this.byteStream = byteStream;
                this.encoding = encoding;
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

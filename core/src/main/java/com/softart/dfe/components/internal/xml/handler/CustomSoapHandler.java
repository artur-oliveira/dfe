package com.softart.dfe.components.internal.xml.handler;

import com.softart.dfe.components.internal.xml.node.NodeCleanerFactory;
import com.softart.dfe.interfaces.xml.XMLNodeCleaner;
import com.softart.dfe.util.GZIPUtils;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import lombok.extern.log4j.Log4j2;
import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Log4j2
public final class CustomSoapHandler implements SOAPHandler<SOAPMessageContext> {

    private static final String BASE_64_PREFFIX = "H4sIAAAAAAAA";
    private static final boolean LOG_REQUEST = Boolean.parseBoolean(System.getProperty("com.softart.dfe.handler.log.request", "true"));
    private static final boolean LOG_RESPONSE = Boolean.parseBoolean(System.getProperty("com.softart.dfe.handler.log.response", "true"));

    private final List<XMLNodeCleaner> responseNodeCleaner = new ArrayList<>();

    public CustomSoapHandler(List<XMLNodeCleaner> responseNodeCleaner) {
        this.responseNodeCleaner.addAll(responseNodeCleaner);
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        boolean outbondMessage = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outbondMessage) {
            try {
                Node body = context.getMessage().getSOAPPart().getEnvelope().getBody();
                NodeCleanerFactory.getInstance().clean(body);
                NodeCleanerFactory.getInstance().clean(context.getMessage().getSOAPPart().getEnvelope().getHeader());

                if (LOG_REQUEST) {
                    try (StringWriter xml = new StringWriter()) {
                        XMLUtils.getTransformer().transform(new DOMSource(body.getFirstChild().getFirstChild()), new StreamResult(xml));
                        log.debug(xml.toString().startsWith(BASE_64_PREFFIX) ? GZIPUtils.decompressWithBase64(xml.toString()) : xml.toString());
                    }
                }

            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        } else {
            try {
                if (LOG_RESPONSE) {
                    SOAPBody body = context.getMessage().getSOAPPart().getEnvelope().getBody();
                    responseNodeCleaner.forEach(it -> it.clean(body));
                    try (StringWriter xml = new StringWriter()) {
                        XMLUtils.getTransformer().transform(new DOMSource(body.getFirstChild().getFirstChild()), new StreamResult(xml));
                        log.debug(xml.toString().startsWith(BASE_64_PREFFIX) ? GZIPUtils.decompressWithBase64(xml.toString()) : xml.toString());
                    }
                }
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

}
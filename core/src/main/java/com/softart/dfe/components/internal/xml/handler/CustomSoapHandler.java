package com.softart.dfe.components.internal.xml.handler;

import com.softart.dfe.components.internal.xml.namespace.NameSpaceCleanerFactory;
import com.softart.dfe.util.XMLUtils;
import lombok.extern.log4j.Log4j2;

import javax.xml.namespace.QName;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import java.io.StringWriter;
import java.util.Set;

@Log4j2
public final class CustomSoapHandler implements SOAPHandler<SOAPMessageContext> {

    private static final boolean LOG_REQUEST = Boolean.parseBoolean(System.getProperty("com.softart.dfe.handler.log.request", "true"));
    private static final boolean LOG_RESPONSE = Boolean.parseBoolean(System.getProperty("com.softart.dfe.handler.log.response", "true"));

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        boolean outbondMessage = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outbondMessage) {
            try {
                NameSpaceCleanerFactory.getInstance().clean(context.getMessage().getSOAPPart().getEnvelope().getBody());
                NameSpaceCleanerFactory.getInstance().clean(context.getMessage().getSOAPPart().getEnvelope().getHeader());

                if (LOG_REQUEST) {
                    try (StringWriter xml = new StringWriter()) {
                        XMLUtils.getTransformer().transform(new DOMSource(context.getMessage().getSOAPPart().getEnvelope().getBody().getFirstChild().getFirstChild()), new StreamResult(xml));
                        log.debug(xml);
                    }
                }

            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        } else {
            try {
                if (LOG_RESPONSE) {
                    try (StringWriter xml = new StringWriter()) {
                        XMLUtils.getTransformer().transform(new DOMSource(context.getMessage().getSOAPPart().getEnvelope().getBody().getFirstChild().getFirstChild()), new StreamResult(xml));
                        log.debug(xml);
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
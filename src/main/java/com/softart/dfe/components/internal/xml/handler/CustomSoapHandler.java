package com.softart.dfe.components.internal.xml.handler;

import com.softart.dfe.components.internal.xml.namespace.NameSpaceCleanerFactory;
import lombok.extern.log4j.Log4j2;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

@Log4j2
public final class CustomSoapHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if ((boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
            try {
                NameSpaceCleanerFactory.getInstance().clean(context.getMessage().getSOAPPart().getEnvelope().getBody());
                NameSpaceCleanerFactory.getInstance().clean(context.getMessage().getSOAPPart().getEnvelope().getHeader());
            } catch (SOAPException ex) {
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
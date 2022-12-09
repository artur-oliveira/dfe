package com.softart.dfe.components.wsdl;

import com.softart.dfe.components.internal.xml.handler.CustomSoapHandler;
import com.softart.dfe.components.security.SocketFactory;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;
import lombok.AccessLevel;
import lombok.Getter;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.soap.SOAPHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter(AccessLevel.PRIVATE)
final class DefaultConfigureProviderFactory extends ConfigureProviderFactory {

    public static final int TIMEOUT_IN_SECS = Integer.parseInt(System.getProperty("DEFAULT_WEBSERVICE_TIMEOUT", "30"));
    private static final String SOCKET_FACTORY = "com.sun.xml.internal.ws.transport.https.client.SSLSocketFactory";
    private static final String ENDPOINT_ADDRESS = "javax.xml.ws.service.endpoint.address";
    private static final String CONNECT_TIMEOUT = "com.sun.xml.internal.ws.connect.timeout";
    private static final String REQUEST_TIMEOUT = "com.sun.xml.internal.ws.request.timeout";

    private final List<SOAPHandler<?>> handlers = Collections.singletonList(new CustomSoapHandler());

    public DefaultConfigureProviderFactory() {
    }

    private void context(BindingProvider port, Config config) throws SecurityException {
        port.getRequestContext().put(SOCKET_FACTORY, SocketFactory.getInstance().context(config).getSocketFactory());
    }

    private void useHttps(BindingProvider port) {
        port.getRequestContext().put(ENDPOINT_ADDRESS, port.getRequestContext().get(ENDPOINT_ADDRESS).toString().replace("http://", "https://"));
    }

    private void timeout(BindingProvider port) {
        port.getRequestContext().put(CONNECT_TIMEOUT, DefaultConfigureProviderFactory.TIMEOUT_IN_SECS * 1000);
        port.getRequestContext().put(REQUEST_TIMEOUT, DefaultConfigureProviderFactory.TIMEOUT_IN_SECS * 1000);
    }

    private void handler(BindingProvider ws) {
        ws.getBinding().setHandlerChain(new ArrayList<>(getHandlers()));
    }

    public void configure(BindingProvider port, Config config) throws SecurityException {
        context(port, config);
        timeout(port);
        handler(port);
        useHttps(port);
    }
}

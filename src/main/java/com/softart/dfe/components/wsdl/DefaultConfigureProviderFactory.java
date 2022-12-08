package com.softart.dfe.components.wsdl;

import com.softart.dfe.components.internal.xml.handler.CustomSoapHandler;
import com.softart.dfe.components.security.SocketFactory;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.ArrayList;
import java.util.List;

final class DefaultConfigureProviderFactory extends ConfigureProviderFactory {

    public static final int TIMEOUT_IN_SECS = Integer.parseInt(System.getProperty("DEFAULT_WEBSERVICE_TIMEOUT", "30"));
    private static final String SOCKET_FACTORY = "com.sun.xml.internal.ws.transport.https.client.SSLSocketFactory";
    private static final String ENDPOINT_ADDRESS = "javax.xml.ws.service.endpoint.address";
    private static final String CONNECT_TIMEOUT = "com.sun.xml.internal.ws.connect.timeout";
    private static final String REQUEST_TIMEOUT = "com.sun.xml.internal.ws.request.timeout";

    public DefaultConfigureProviderFactory() {
    }

    public static void context(BindingProvider port, Config config) throws SecurityException {
        port.getRequestContext().put(SOCKET_FACTORY, SocketFactory.getInstance().context(config).getSocketFactory());
    }

    public static void useHttps(BindingProvider port) {
        port.getRequestContext().put(ENDPOINT_ADDRESS, port.getRequestContext().get(ENDPOINT_ADDRESS).toString().replace("http://", "https://"));
    }

    public static void timeout(BindingProvider port, int timeoutInSecs) {
        port.getRequestContext().put(CONNECT_TIMEOUT, timeoutInSecs * 1000);
        port.getRequestContext().put(REQUEST_TIMEOUT, timeoutInSecs * 1000);
    }

    @SuppressWarnings("rawtypes")
    public static void handler(BindingProvider ws) {
        List<Handler> handlerChain = new ArrayList<>();
        handlerChain.add(new CustomSoapHandler());
        ws.getBinding().setHandlerChain(handlerChain);
    }

    public void configure(BindingProvider port, Config config) throws SecurityException {
        context(port, config);
        timeout(port, TIMEOUT_IN_SECS);
        handler(port);
        useHttps(port);
    }
}

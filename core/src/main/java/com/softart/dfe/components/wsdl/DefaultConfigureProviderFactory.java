package com.softart.dfe.components.wsdl;

import com.softart.dfe.components.internal.xml.handler.CustomSoapHandler;
import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import lombok.AccessLevel;
import lombok.Getter;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.soap.SOAPHandler;
import java.util.*;

@Getter(AccessLevel.PRIVATE)
final class DefaultConfigureProviderFactory extends ConfigureProviderFactory {

    public static final int TIMEOUT_IN_SECS = Integer.parseInt(System.getProperty("com.softart.dfe.ws.timeout", "10"));
    private static final String SOCKET_FACTORY = "com.sun.xml.internal.ws.transport.https.client.SSLSocketFactory";
    private static final String ENDPOINT_ADDRESS = "javax.xml.ws.service.endpoint.address";
    private static final String CONNECT_TIMEOUT = "com.sun.xml.internal.ws.connect.timeout";
    private static final String REQUEST_TIMEOUT = "com.sun.xml.internal.ws.request.timeout";

    private final List<SOAPHandler<?>> handlers = Collections.singletonList(new CustomSoapHandler());

    static {
        System.setProperty("sun.net.client.defaultReadTimeout", Objects.toString(TIMEOUT_IN_SECS * 1000));
        System.setProperty("sun.net.client.defaultConnectTimeout", Objects.toString(TIMEOUT_IN_SECS * 1000));
    }

    public DefaultConfigureProviderFactory() {
    }

    /**
     * > The function takes a BindingProvider and a Config object, and sets the socket factory of the BindingProvider to a
     * socket factory that is configured with the Config object
     *
     * @param port   The port object that is used to invoke the web service.
     * @param config The configuration object that contains the keystore and truststore information.
     */
    private void context(BindingProvider port, Config config) throws SecurityException {
        port.getRequestContext().put(SOCKET_FACTORY, SocketFactory.getInstance().context(config).getSocketFactory());
    }

    /**
     * If the endpoint address is http, replace it with https
     *
     * @param config The provider config
     */
    private void useHttps(ProviderConfig config) {
        config.getPort().getRequestContext().put(ENDPOINT_ADDRESS, Optional.ofNullable(config.getOverridePortAddress()).orElseGet(() -> config.getPort().getRequestContext().get(ENDPOINT_ADDRESS).toString().replace("http://", "https://")));
    }

    /**
     * > Set the timeout for the request to the value of the `DefaultConfigureProviderFactory.TIMEOUT_IN_SECS` constant
     *
     * @param port the port of the web service
     */
    private void timeout(BindingProvider port) {
        port.getRequestContext().put(CONNECT_TIMEOUT, DefaultConfigureProviderFactory.TIMEOUT_IN_SECS * 1000);
        port.getRequestContext().put(REQUEST_TIMEOUT, DefaultConfigureProviderFactory.TIMEOUT_IN_SECS * 1000);
    }

    /**
     * Set the handler chain for the binding to the list of handlers.
     *
     * @param ws The web service client object
     */
    private void handler(BindingProvider ws) {
        ws.getBinding().setHandlerChain(new ArrayList<>(getHandlers()));
    }

    @Override
    public void configure(ProviderConfig config) throws SecurityException {
        context(config.getPort(), config.getConfig());
        timeout(config.getPort());
        handler(config.getPort());
        useHttps(config);
    }
}

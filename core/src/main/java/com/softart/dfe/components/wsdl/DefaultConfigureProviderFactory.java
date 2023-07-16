package com.softart.dfe.components.wsdl;

import com.softart.dfe.components.internal.xml.handler.CustomSoapHandler;
import com.softart.dfe.components.security.socket.SocketFactory;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import jakarta.xml.ws.BindingProvider;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Getter(AccessLevel.PRIVATE)
final class DefaultConfigureProviderFactory extends ConfigureProviderFactory {

    public static final int TIMEOUT_IN_SECS = Integer.parseInt(System.getProperty("com.softart.dfe.ws.timeout", "60"));
    private static final String SOCKET_FACTORY = "com.sun.xml.ws.transport.https.client.SSLSocketFactory";
    private static final String ENDPOINT_ADDRESS = "jakarta.xml.ws.service.endpoint.address";
    private static final String CONNECT_TIMEOUT = "com.sun.xml.ws.connect.timeout";
    private static final String REQUEST_TIMEOUT = "com.sun.xml.ws.request.timeout";

    static {
        System.setProperty("sun.net.client.defaultReadTimeout", Objects.toString(TIMEOUT_IN_SECS * 1000));
        System.setProperty("sun.net.client.defaultConnectTimeout", Objects.toString(TIMEOUT_IN_SECS * 1000));
    }

    public DefaultConfigureProviderFactory() {
    }

    /**
     * The function takes a BindingProvider and a Config object, and sets the socket factory of the BindingProvider to a
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
        config.port().getRequestContext().put(ENDPOINT_ADDRESS, Optional.ofNullable(config.overridePortAddress()).orElseGet(() -> config.port().getRequestContext().get(ENDPOINT_ADDRESS).toString().replace(":80/", "/").replace("http://", "https://")));
    }

    static void enableDebug() {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    }

    static void disableDebug() {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "false");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "false");
    }

    private void debug(ProviderConfig config) {
        if (config.debugMode()) {
            enableDebug();
        } else {
            disableDebug();
        }
    }

    /**
     * Set the timeout for the request to the value of the `DefaultConfigureProviderFactory.TIMEOUT_IN_SECS` constant
     *
     * @param port the port of the web service
     */
    private void timeout(BindingProvider port) {
        port.getRequestContext().put(CONNECT_TIMEOUT, DefaultConfigureProviderFactory.TIMEOUT_IN_SECS * 1000);
        port.getRequestContext().put(REQUEST_TIMEOUT, DefaultConfigureProviderFactory.TIMEOUT_IN_SECS * 1000);
    }


    /**
     * The function sets a custom SOAP handler for the binding of a provider configuration.
     *
     * @param config The "config" parameter is an instance of the ProviderConfig class. It is used to configure the
     *               provider side of a SOAP web service.
     */
    private void handler(ProviderConfig config) {
        config.port().getBinding().setHandlerChain(new ArrayList<>(Collections.singletonList(new CustomSoapHandler(config.customResponseNodeCleaners()))));
    }

    @Override
    public void configure(ProviderConfig config) throws SecurityException {
        context(config.port(), config.config());
        timeout(config.port());
        handler(config);
        useHttps(config);
        debug(config);
    }
}

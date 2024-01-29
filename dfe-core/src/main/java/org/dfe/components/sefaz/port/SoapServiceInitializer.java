package org.dfe.components.sefaz.port;

import org.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import org.dfe.components.sefaz.port.cte4.initializer.ConfigCte4SoapServiceInitializer;
import org.dfe.components.sefaz.port.cte4.initializer.ProxyCte4SoapServiceInitializer;
import org.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import org.dfe.components.sefaz.port.mdfe.initializer.ConfigMdfeSoapServiceInitializer;
import org.dfe.components.sefaz.port.mdfe.initializer.ProxyMdfeSoapServiceInitializer;
import org.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import org.dfe.components.sefaz.port.nfce.initializer.ConfigNfceSoapServiceInitializer;
import org.dfe.components.sefaz.port.nfce.initializer.ProxyNfceSoapServiceInitializer;
import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.components.sefaz.port.nfe.initializer.ConfigNfeSoapServiceInitializer;
import org.dfe.components.sefaz.port.nfe.initializer.ProxyNfeSoapServiceInitializer;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.interfaces.sefaz.port.CommonSoapService;
import lombok.Data;

import java.util.Objects;

@Data
public abstract class SoapServiceInitializer<T extends CommonSoapService> {
    protected SoapServiceInitializer<T> next;

    /**
     * Create a new instance of the ProxyNfeSoapServiceInitializer class and pass it to the ConfigNfeSoapServiceInitializer
     * class, then return the result of the ConfigNfeSoapServiceInitializer class.
     *
     * @return A SoapServiceInitializer<AbstractNfeSoapService>
     */
    public static SoapServiceInitializer<AbstractNfeSoapService> nfe() {
        return SoapServiceInitializer.link(new ProxyNfeSoapServiceInitializer(), new ConfigNfeSoapServiceInitializer());
    }

    /**
     * Create a new instance of the SoapServiceInitializer class, passing the ProxyNfceSoapServiceInitializer and
     * ConfigNfceSoapServiceInitializer classes as parameters.
     *
     * @return A SoapServiceInitializer object.
     */
    public static SoapServiceInitializer<AbstractNfceSoapService> nfce() {
        return SoapServiceInitializer.link(new ProxyNfceSoapServiceInitializer(), new ConfigNfceSoapServiceInitializer());
    }

    public static SoapServiceInitializer<AbstractCte4SoapService> cte4() {
        return SoapServiceInitializer.link(new ProxyCte4SoapServiceInitializer(), new ConfigCte4SoapServiceInitializer());
    }

    /**
     * Create a new instance of the class ProxyMdfeSoapServiceInitializer and pass it to the
     * ConfigMdfeSoapServiceInitializer class, then return the result of the ConfigMdfeSoapServiceInitializer class
     *
     * @return A SoapServiceInitializer object.
     */
    public static SoapServiceInitializer<AbstractMdfeSoapService> mdfe() {
        return SoapServiceInitializer.link(new ProxyMdfeSoapServiceInitializer(), new ConfigMdfeSoapServiceInitializer());
    }

    /**
     * It takes a variable number of arguments of type T, where T extends SoapServiceInitializer, and returns the first
     * argument.
     *
     * @param first The first initializer in the chain.
     * @return The first element in the chain.
     */
    @SafeVarargs
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends SoapServiceInitializer> T link(T first, T... chain) {
        SoapServiceInitializer<CommonSoapService> head = first;
        for (SoapServiceInitializer<CommonSoapService> nextInChain : chain) {
            head.setNext(nextInChain);
            head = nextInChain;
        }
        return first;
    }

    /**
     * This function is called by the framework to initialize the service
     *
     * @param soapService The SOAP service that you want to initialize.
     */
    public abstract void initialize(T soapService) throws SoapServiceInitializationException;

    /**
     * If the next SoapServiceInitializer is not null, then initialize the next SoapServiceInitializer
     *
     * @param soapService The SoapService object that is being initialized.
     */
    protected void initializeNext(T soapService) throws SoapServiceInitializationException {
        if (soapService.isInitialized()) return;
        if (Objects.isNull(getNext()) && !soapService.isInitialized()) throw new SoapServiceInitializationException();
        getNext().initialize(soapService);
    }
}

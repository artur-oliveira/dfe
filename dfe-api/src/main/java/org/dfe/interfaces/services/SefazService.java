package org.dfe.interfaces.services;

import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.DfProcess;
import org.dfe.interfaces.validation.ValidationService;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;

/**
 * Declaring a public interface named `SefazService`. This interface defines a set of methods that must be implemented by
 * any class that implements this interface. The methods defined in this interface are `getConfig()`, `getXmlSigner()`,
 * `getProcess()`, `getProviderFactory()`, `getValidatorFactory()`, and `getConfigureProviderFactory()`.
 */
public interface SefazService {

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config getConfig();

    /**
     * This function returns an instance of the XMLSignerService class
     *
     * @return The XMLSignerService object.
     */
    XMLSignerService getXmlSigner();

    /**
     * Returns the process instance
     *
     * @return The process that is being returned is the process that is being used to run the current thread.
     */
    DfProcess getProcess();

    /**
     * It returns a DfeService object that can be used to make requests to the Google Play Developer API
     *
     * @return A ProviderFactory object.
     */
    DfeService getProviderFactory();

    /**
     * Returns the ValidatorFactory instance that this ValidatorContext is bound to.
     *
     * @return A ValidatorFactory object.
     */
    ValidationService getValidatorFactory();

    /**
     * Returns the ConfigureProviderFactory instance
     *
     * @return The ConfigureProviderFactory is being returned.
     */
    ConfigureProvider getConfigureProviderFactory();

}

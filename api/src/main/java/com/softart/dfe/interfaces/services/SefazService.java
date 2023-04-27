package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.DfProcess;
import com.softart.dfe.interfaces.validation.ValidationService;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;

public interface SefazService {

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config getConfig();

    /**
     * > This function returns an instance of the XMLSignerService class
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
     * > Returns the ConfigureProviderFactory instance
     *
     * @return The ConfigureProviderFactory is being returned.
     */
    ConfigureProvider getConfigureProviderFactory();

}

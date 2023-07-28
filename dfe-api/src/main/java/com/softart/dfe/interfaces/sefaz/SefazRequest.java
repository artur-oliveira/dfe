package com.softart.dfe.interfaces.sefaz;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.interfaces.xml.generic.XML;

import java.util.Collection;

/**
 * This is defining a Java interface named `SefazRequest` with two generic type parameters `SEND` and `RETURN`, both of
 * which extend the `XML` class. The interface declares several methods that must be implemented by any class that
 * implements this interface. These methods include `getData()`, `getConfig()`, `getValidators()`, `getSigner()`,
 * `getConfigureProvider()`, `getBeforeRequest()`, and `getAfterRequest()`.
 */
public interface SefazRequest<SEND extends XML, RETURN extends XML> {

    /**
     * GetData() returns a SEND object.
     *
     * @return The getData() method is being returned.
     */
    SEND data();

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config config();

    /**
     * "Get the validators that should be used to validate the given object."
     * <p>
     * The function is generic, so it can be used to validate any type of object. The type of object that is being
     * validated is specified by the generic type parameter `SEND`
     *
     * @return A collection of validators.
     */
    Collection<? extends Validator<SEND>> validators();

    /**
     * Returns an instance of the XMLSignerService class
     *
     * @return The XMLSignerService object.
     */
    XMLSignerService signer();

    /**
     * Get the configure provider.
     *
     * @return The ConfigureProvider is being returned.
     */
    ConfigureProvider configureProvider();

    /**
     * Returns a collection of BeforeWebServiceRequest objects that will be executed before the request is sent
     *
     * @return A collection of BeforeWebServiceRequest objects.
     */
    Collection<? extends BeforeWebServiceRequest<SEND>> beforeRequest();

    /**
     * Returns a collection of all the `AfterWebServiceRequest` objects that are registered with the `WebServiceRequest`
     * object
     *
     * @return A collection of AfterWebServiceRequest objects.
     */
    Collection<? extends AfterWebServiceRequest<SEND, RETURN>> afterRequest();

}

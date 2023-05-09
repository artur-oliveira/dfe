package com.softart.dfe.interfaces.sefaz;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.interfaces.xml.generic.XML;

import java.util.Collection;

public interface SefazRequest<SEND extends XML, RETURN extends XML> {

    /**
     * GetData() returns a SEND object.
     *
     * @return The getData() method is being returned.
     */
    SEND getData();

    /**
     * Get the config object.
     *
     * @return The config object.
     */
    Config getConfig();

    /**
     * "Get the validators that should be used to validate the given object."
     * <p>
     * The function is generic, so it can be used to validate any type of object. The type of object that is being
     * validated is specified by the generic type parameter `SEND`
     *
     * @return A collection of validators.
     */
    Collection<? extends Validator<SEND>> getValidators();

    /**
     * Returns an instance of the XMLSignerService class
     *
     * @return The XMLSignerService object.
     */
    XMLSignerService getSigner();

    /**
     * Get the configure provider.
     *
     * @return The ConfigureProvider is being returned.
     */
    ConfigureProvider getConfigureProvider();

    /**
     * Returns a collection of BeforeWebServiceRequest objects that will be executed before the request is sent
     *
     * @return A collection of BeforeWebServiceRequest objects.
     */
    Collection<? extends BeforeWebServiceRequest<SEND>> getBeforeRequest();

    /**
     * Returns a collection of all the `AfterWebServiceRequest` objects that are registered with the `WebServiceRequest`
     * object
     *
     * @return A collection of AfterWebServiceRequest objects.
     */
    Collection<? extends AfterWebServiceRequest<SEND, RETURN>> getAfterRequest();

}

package org.dfe.interfaces.process;

import org.dfe.interfaces.xml.generic.XML;

import java.util.Collection;

/**
 * This is defining a generic interface called `ProcessFactory` with two type parameters `REQ` and `RES` that extend the
 * `XML` interface. The `REQ` parameter represents the type of the request object that will be processed by the factory,
 * and the `RES` parameter represents the type of the response object that will be produced by the factory. This interface
 * is used to define a factory that can create processes to handle requests and produce responses of the specified types.
 */
public interface ProcessFactory<REQ extends XML, RES extends XML> {

    /**
     * Returns a collection of functions that will be called after the web service request is made
     *
     * @return A collection of AfterWebServiceRequest objects.
     */
    Collection<? extends AfterWebServiceRequest<REQ, RES>> after();

    /**
     * "Returns a collection of objects that can be used to modify the request before it is sent to the web service."
     * <p>
     * The `before()` function is called by the `WebServiceRequest` object before it sends the request to the web service.
     * The `WebServiceRequest` object will call the `before()` function on each object in the collection returned by the
     * `before()` function
     *
     * @return A collection of BeforeWebServiceRequest objects.
     */
    Collection<? extends BeforeWebServiceRequest<REQ>> before();

}

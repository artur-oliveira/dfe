package org.dfe.interfaces.process;

import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.xml.generic.XML;

/**
 * This is a Java interface declaration with two generic type parameters `REQ` and `RES` that extend the `XML` interface.
 * The interface `AfterWebServiceRequest` defines a method `process` that takes an object of type `T` which implements the
 * `AfterRequest` interface with generic type parameters `REQ` and `RES`. The method throws a `ProcessException`.
 */
public interface AfterWebServiceRequest<REQ extends XML, RES extends XML> {


    /**
     * This function processes an object of type T that extends AfterRequest and throws a ProcessException.
     *
     * @param o The parameter "o" is a generic type "T" that extends the interface "AfterRequest<REQ, RES>". It represents
     *          an object that contains information or actions to be processed after a request has been made and a response has been
     *          received. The "REQ" and "RES" are also generic
     * @throws ProcessException ProcessException
     */
    <T extends AfterRequest<REQ, RES>> void process(T o) throws ProcessException;

}

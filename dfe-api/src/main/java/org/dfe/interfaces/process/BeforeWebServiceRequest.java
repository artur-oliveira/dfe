package org.dfe.interfaces.process;

import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.xml.generic.XML;

/**
 * This is a Java interface declaration with a generic type parameter `REQ` that extends the `XML` interface. The interface
 * `BeforeWebServiceRequest` defines a method `process` that takes an object of type `T` which extends the `BeforeRequest`
 * interface and has a generic type parameter `REQ` that extends the `XML` interface. The method throws a
 * `ProcessException`. This interface is used to define a contract for processing a web service request before it is sent.
 */
public interface BeforeWebServiceRequest<REQ extends XML> {


    /**
     * This is a Java method that processes an object of a generic type T that extends the BeforeRequest interface and may
     * throw a ProcessException.
     *
     * @param o The parameter "o" is a generic type "T" that extends the interface "BeforeRequest<REQ>". It is used as an
     *          input to the "process" method.
     * @throws ProcessException ProcessException
     */
    <T extends BeforeRequest<REQ>> void process(T o) throws ProcessException;

}

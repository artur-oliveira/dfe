package org.dfe.interfaces.sefaz.port;

/**
 * The code is defining a Java interface named `NfeSoapService` that extends another interface named `NfCommonSoapService`.
 * This means that `NfeSoapService` inherits all the methods and constants defined in `NfCommonSoapService`, and can also
 * define its own methods and constants.
 */
public interface NfeSoapService extends NfCommonSoapService {

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homDistribution();

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodDistribution();

    /**
     * This is a generic method that returns an object of type T for product query registration.
     *
     * @return A generic type T is being returned, which is determined by the implementation of the method
     * `prodQueryRegister()`.
     */
    <T> T prodQueryRegister();

    /**
     * This is a generic method that returns an object of type T for homology query registration.
     *
     * @return The method `homQueryRegister()` is a generic method that returns an object of type `T`. The specific type of
     * object being returned depends on the implementation of the method.
     */
    <T> T homQueryRegister();

    /**
     * QueryGtin() returns a generic type T.
     *
     * @return A generic type T.
     */
    <T> T queryGtin();

}

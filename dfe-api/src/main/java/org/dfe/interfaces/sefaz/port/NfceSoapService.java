package org.dfe.interfaces.sefaz.port;

/**
 * This code is defining a Java interface named `NfceSoapService` that extends another interface named
 * `NfCommonSoapService`. This means that `NfceSoapService` inherits all the methods and constants from
 * `NfCommonSoapService` and can also define its own methods.
 */
public interface NfceSoapService extends NfCommonSoapService {

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodSubstituteCancel();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homSubstituteCancel();
}

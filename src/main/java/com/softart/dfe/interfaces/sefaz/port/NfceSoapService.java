package com.softart.dfe.interfaces.sefaz.port;

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

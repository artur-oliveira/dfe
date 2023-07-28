package com.softart.dfe.interfaces.sefaz.port;

import com.softart.dfe.interfaces.internal.config.NfConfig;

public interface NfCommonSoapService extends CommonSoapService {

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodAuthorization();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homAuthorization();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodCancel();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homCancel();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodInutilization();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homInutilization();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodQueryProtocol();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homQueryProtocol();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodQueryStatusService();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homQueryStatusService();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodReturnAuthorization();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homReturnAuthorization();

    /**
     * The function returns a configuration object of type NfConfig.
     *
     * @return A `NfConfig` object is being returned.
     */
    NfConfig getConfig();

}

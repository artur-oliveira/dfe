package org.dfe.interfaces.sefaz.port;

/**
 * The `public interface CteSoapService` is declaring an interface named `CteSoapService`. The `extends CommonSoapService`
 * part is indicating that this interface is extending another interface named `CommonSoapService`. This means that
 * `CteSoapService` will inherit all the methods and properties of `CommonSoapService` in addition to the ones declared in
 * `CteSoapService`.
 */
public interface CteSoapService extends CommonSoapService {


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodDistribution();


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
    <T> T prodEvent();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homEvent();


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
    <T> T prodQueryReceipt();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homQueryReceipt();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodQuerySituation();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homQuerySituation();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodReception();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homReception();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodReceptionGtve();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homReceptionGtve();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodReceptionOs();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homReceptionOs();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodReceptionSync();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homReceptionSync();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodStatusService();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homStatusService();


}

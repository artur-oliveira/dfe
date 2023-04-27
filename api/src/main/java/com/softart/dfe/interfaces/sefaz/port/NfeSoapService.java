package com.softart.dfe.interfaces.sefaz.port;

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

    <T> T prodQueryRegister();

    <T> T homQueryRegister();

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homEpec();

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodEpec();


    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homInterestedActor();

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodInterestedActor();

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T homCorrectionLetter();

    /**
     * This function returns a generic type T.
     *
     * @return A function that takes a type parameter T and returns a value of type T.
     */
    <T> T prodCorrectionLetter();

    /**
     * "Given a type T, return a T."
     * <p>
     * The function is generic, meaning that it can be used with any type
     *
     * @return A homogeneous manifestation of the type T.
     */
    <T> T homManifestation();

    /**
     * It returns a T, which is a generic type.
     *
     * @return A new instance of the type T.
     */
    <T> T prodManifestation();

    /**
     * QueryGtin() returns a generic type T.
     *
     * @return A generic type T.
     */
    <T> T queryGtin();

}

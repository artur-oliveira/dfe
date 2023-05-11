package com.softart.dfe.interfaces.internal.nf;

/**
 * Declaring a public interface named `NfAnServiceURL`. This interface contains four abstract methods that return URLs for
 * different events and distributions on AN environment.
 */
public interface NfAnServiceURL {

    /**
     * It returns the URL of production events on AN environment
     *
     * @return A string.
     */
    String eventNfAnProd();

    /**
     * It returns the URL of homologation events on AN environment
     *
     * @return A string.
     */
    String eventNfAnHom();

    /**
     * It returns the URL of production distribution on AN environment
     *
     * @return A string.
     */
    String distributionNfAnProd();

    /**
     * It returns the URL of homologation distribution on AN environment
     *
     * @return A string.
     */
    String distributionNfAnHom();


}

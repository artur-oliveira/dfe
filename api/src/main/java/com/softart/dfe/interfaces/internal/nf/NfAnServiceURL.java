package com.softart.dfe.interfaces.internal.nf;

@SuppressWarnings("unused")
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

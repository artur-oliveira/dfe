package org.dfe.interfaces.internal.nf;

/**
 * Declaring a public interface named `NfCommonServiceURL`. This interface contains several method signatures that define
 * the URLs and protocols used to interact with NF (Nota Fiscal) services in both production and homologation environments.
 * The methods return strings that represent the various URLs and protocols used for querying and authorizing NF
 * transactions.
 */
public interface NfCommonServiceURL {

    /**
     * It returns the name of the field that stores the utilization of the NF-Prod.
     *
     * @return A string.
     */
    String inutilizationNfProd();

    /**
     * It returns the string "inutilizationNfHom".
     *
     * @return A string.
     */
    String inutilizationNfHom();

    /**
     * It returns the name of the event.
     *
     * @return A string.
     */
    String eventNfProd();

    /**
     * It returns the event name for the notification of a new home.
     *
     * @return A string.
     */
    String eventNfHom();

    /**
     * Returns the protocol used to query the NF-e production web service
     *
     * @return The query is returning the protocol and the number of products.
     */
    String queryProtocolNfProd();

    /**
     * Returns the protocol of the NF homologous to the query sequence
     *
     * @return The query returns the number of homozygous variants for each individual.
     */
    String queryProtocolNfHom();

    /**
     * It returns the status of the service.
     *
     * @return The status of the service.
     */
    String statusServiceNfProd();

    /**
     * Returns the status of the service
     *
     * @return A string.
     */
    String statusServiceNfHom();

    /**
     * It returns the authorization token for the production environment.
     *
     * @return A string.
     */
    String authorizationNfProd();

    /**
     * It returns the authorization number for the NF-e Homologation environment.
     *
     * @return A string.
     */
    String authorizationNfHom();

    /**
     * Returns the authorization number for the NF-e production environment
     *
     * @return The returnAuthorizationNfProd() method is being returned.
     */
    String returnAuthorizationNfProd();

    /**
     * Returns the authorization number of the NF-e
     *
     * @return The returnAuthorizationNfHom() method is being returned.
     */
    String returnAuthorizationNfHom();

}

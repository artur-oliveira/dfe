package com.softart.dfe.interfaces.internal.mdfe;

/**
 * Declaring a public interface named `MdfeURL`. This interface contains several method signatures that define the behavior
 * of the methods that will implement this interface.
 */
public interface MdfeURL {
    /**
     * Returns the home reception of the current user.
     *
     * @return A string.
     */
    String receptionHom();

    /**
     * It returns a string.
     *
     * @return The queryReceiptHom() method is returning a String.
     */
    String queryReceiptHom();

    /**
     * Returns the home event of the current event
     *
     * @return A string.
     */
    String eventHom();

    /**
     * It returns a String.
     *
     * @return The querySituationHom() method is returning a String.
     */
    String querySituationHom();

    /**
     * Returns the status of the service
     *
     * @return A string.
     */
    String statusServiceHom();

    /**
     * It returns a string that is a query for unclosed homonyms.
     *
     * @return The queryUnclosedHom() method returns a String.
     */
    String queryUnclosedHom();

    /**
     * Returns the distribution of the homozygous genotypes
     *
     * @return The distribution home directory.
     */
    String distributionHom();

    /**
     * It returns a String.
     *
     * @return A string.
     */
    String receptionSyncHom();

    /**
     * This function returns the reception production of the current word
     *
     * @return A string.
     */
    String receptionProd();

    /**
     * This function returns a query string that can be used to retrieve the receipt product information from the database
     *
     * @return The queryReceiptProd() method returns a String.
     */
    String queryReceiptProd();

    /**
     * Returns the event production.
     *
     * @return The eventProd() method is being returned.
     */
    String eventProd();

    /**
     * It returns a String.
     *
     * @return The querySituationProd() method returns a String.
     */
    String querySituationProd();

    String statusServiceProd();

    /**
     * This function returns a query that returns all the unclosed production orders
     *
     * @return A list of all the products that have not been closed.
     */
    String queryUnclosedProd();

    /**
     * Returns the distribution of the product of the two random variables.
     *
     * @return A string.
     */
    String distributionProd();

    /**
     * It receives a message from the queue "sync.prod" and returns it as a String.
     *
     * @return A string.
     */
    String receptionSyncProd();
}

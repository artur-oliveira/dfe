package com.softart.dfe.interfaces.internal.cte;

/**
 * The code is defining a Java interface named `CteURL` that extends another interface named `CteAnServiceURL`. This means
 * that `CteURL` inherits all the methods and constants defined in `CteAnServiceURL`, and also adds its own methods. Any
 * class that implements `CteURL` must provide an implementation for all the methods defined in both `CteURL` and
 * `CteAnServiceURL`.
 */
public interface Cte4URL extends CteAnServiceURL {

    /**
     * It returns the operating system of the production server.
     *
     * @return The return type is a string.
     */
    String receptionOsProd();

    /**
     * It returns the value of the receptionOsHom property.
     *
     * @return A string.
     */
    String receptionOsHom();

    /**
     * It receives a message from the queue "sync.prod" and returns it as a String.
     *
     * @return A string.
     */
    String receptionSyncProd();

    /**
     * It returns a String.
     *
     * @return A string.
     */
    String receptionSyncHom();

    /**
     * Returns the reception of the GTVE production
     *
     * @return A string.
     */
    String receptionGtveProd();

    /**
     * This function returns the reception of the GTVE channel in the home
     *
     * @return A string.
     */
    String receptionGtveHom();

    /**
     * It returns a String.
     *
     * @return The querySituationProd() method returns a String.
     */
    String querySituationProd();

    /**
     * It returns a String.
     *
     * @return The querySituationHom() method is returning a String.
     */
    String querySituationHom();

    /**
     * This function returns the status of the service in production.
     *
     * @return The status of the service.
     */
    String statusServiceProd();

    /**
     * Returns the status of the service
     *
     * @return A string.
     */
    String statusServiceHom();

    /**
     * Returns the event production.
     *
     * @return The eventProd() method is being returned.
     */
    String eventProd();

    /**
     * Returns the home event of the current event
     *
     * @return A string.
     */
    String eventHom();

}

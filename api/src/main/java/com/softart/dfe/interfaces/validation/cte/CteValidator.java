package com.softart.dfe.interfaces.validation.cte;

import java.util.Collection;

/**
 * The code is defining a Java interface called `CteValidator`. This interface specifies a set of methods that must be
 * implemented by any class that implements this interface. The methods defined in this interface are used to validate
 * different aspects of a CTE (Conhecimento de Transporte Eletrônico) document, such as its distribution, events,
 * inutilization, query receipt, query situation, reception, and status service.
 */
public interface CteValidator {

    /**
     * "Return a collection of validators that will be used to validate the distribution of the data."
     * <p>
     * The distribution validators are used to validate the distribution of the data. For example, if you have a column
     * that is supposed to contain only the values "A" and "B", then you can use the `CteDistributionValidator` to validate
     * that the column contains only those values
     *
     * @return A collection of CteDistributionValidator objects.
     */
    Collection<CteDistributionValidator> distributionValidators();

    /**
     * "Return a collection of event validators that will be used to validate events."
     * <p>
     * The event validators are used to validate events.  The event validators are called in the order they are returned by
     * this function.  If any of the event validators return false, the event is not processed.  If all of the event
     * validators return true, the event is processed
     *
     * @return A collection of CteEventValidator objects.
     */
    Collection<CteEventValidator> eventValidators();

    /**
     * It returns a collection of validators that will be used to validate the inutilization
     *
     * @return A collection of CteInutilizationValidator objects.
     */
    Collection<CteInutilizationValidator> inutilizationValidators();

    /**
     * This function returns a collection of validators that will be used to validate the receipt of a query
     *
     * @return A collection of CteQueryReceiptValidator objects.
     */
    Collection<CteQueryReceiptValidator> queryReceiptValidators();

    /**
     * This function returns a collection of validators that will be used to validate the query situation
     *
     * @return A collection of CteQuerySituationValidator objects.
     */
    Collection<CteQuerySituationValidator> querySituationValidators();

    /**
     * This function returns a collection of all the `CteReceptionGtveValidator` objects that are available in the
     * application
     *
     * @return A collection of CteReceptionGtveValidator objects.
     */
    Collection<CteReceptionGtveValidator> receptionGtveValidators();

    /**
     * Return a collection of all the CteStatusServiceValidator beans in the application context.
     *
     * @return A collection of CteStatusServiceValidator objects.
     */
    Collection<CteStatusServiceValidator> statusServiceValidators();

    Collection<CteReceptionCteOsValidator> receptionCteOsValidators();

    /**
     * Return a collection of all the CteReceptionCteSyncValidator beans in the application context
     *
     * @return A collection of CteReceptionCteSyncValidator objects.
     */
    Collection<CteReceptionCteSyncValidator> receptionCteSyncValidators();


    /**
     * Return a collection of CteReceptionCteValidator objects.
     *
     * @return A collection of CteReceptionCteValidator objects.
     */
    Collection<CteReceptionCteValidator> receptionCteValidators();


}

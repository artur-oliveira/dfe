package org.dfe.interfaces.internal.cte;

/**
 * Declaring a public interface named `CteAnServiceURL`. This interface contains two abstract methods
 * `distributionAnProd()` and `distributionAnHom()`. Any class that implements this interface must provide an
 * implementation for these two methods.
 */
public interface CteAnServiceURL {

    /**
     * It returns the distribution of the product of two random variables.
     *
     * @return A string.
     */
    String distributionAnProd();

    /**
     * Returns the distribution of the anhomogeneous Poisson process
     *
     * @return A string.
     */
    String distributionAnHom();

}

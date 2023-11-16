package org.dfe.interfaces.internal;

/**
 * This is declaring a generic interface named `Pair` with two type parameters `T` and `I`. The interface has two methods
 * `first()` and `second()` which return the first and second elements respectively. The types of the elements are
 * determined by the type parameters `T` and `I`. This allows the interface to be implemented with different types of
 * elements depending on the implementation.
 */
public interface Pair<T, I> {
    /**
     * Returns the first element
     *
     * @return the first element
     */
    T first();

    /**
     * Returns the second element
     *
     * @return the second element
     */
    I second();
}

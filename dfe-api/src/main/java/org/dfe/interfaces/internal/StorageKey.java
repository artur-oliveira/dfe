package org.dfe.interfaces.internal;

/**
 * Declaring a public interface named `StorageKey`. An interface in Java is a collection of abstract methods and constants
 * that can be implemented by classes. In this case, the interface has three abstract methods: `getForSend()`,
 * `getForReturn()`, and `getForProcessed()`. Any class that implements this interface must provide an implementation for
 * these methods.
 */
public interface StorageKey {

    /**
     * It returns a string that can be sent to the server.
     *
     * @return A string.
     */
    String getForSend();

    /**
     * This function returns a String.
     *
     * @return The value of the variable "forReturn"
     */
    String getForReturn();

    /**
     * Returns the value of the field forProcessed.
     *
     * @return The value of the variable forProcessed.
     */
    String getForProcessed();

}

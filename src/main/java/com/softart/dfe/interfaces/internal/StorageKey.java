package com.softart.dfe.interfaces.internal;

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

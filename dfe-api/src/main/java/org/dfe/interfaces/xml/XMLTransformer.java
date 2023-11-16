package org.dfe.interfaces.xml;

@FunctionalInterface
public interface XMLTransformer<T> {

    /**
     * Given an XML string, return a Java object.
     *
     * @param xml The XML string to be transformed.
     * @return The return type is the same as the type of the object that is passed in.
     */
    T transform(String xml);

}

package com.softart.dfe.interfaces.xml;

@FunctionalInterface
public interface XMLTransformer<T> {

    T transform(String xml);

}

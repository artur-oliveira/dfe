package org.dfe.interfaces.internal;

@FunctionalInterface
public interface ThrowableSupplier<T> {
    T get() throws Exception;
}


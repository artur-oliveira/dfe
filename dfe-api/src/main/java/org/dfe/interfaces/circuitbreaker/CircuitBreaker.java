package org.dfe.interfaces.circuitbreaker;

import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.ThrowableSupplier;

public interface CircuitBreaker {
    <T> T execute(ThrowableSupplier<T> supplier) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CircuitBreakerState getState();
}
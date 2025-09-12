package org.dfe.interfaces.circuitbreaker.impl;

import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.circuitbreaker.CircuitBreaker;
import org.dfe.interfaces.internal.ThrowableSupplier;

public abstract class GenericCircuitBreaker implements CircuitBreaker {

    protected abstract void onSuccess();

    protected abstract void onFailure();

    @Override
    public <T> T execute(ThrowableSupplier<T> supplier) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        try {
            T result = supplier.get();
            onSuccess();
            return result;
        } catch (
                CircuitBreakerException | NoProviderFound | SecurityException | ProcessException |
                ValidationException | SoapServiceGeneralException | RuntimeException e
        ) {
            throw e;
        } catch (Exception e) {
            onFailure();
            throw new CircuitBreakerException(e);
        }
    }
}

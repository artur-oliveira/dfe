package org.dfe.interfaces.circuitbreaker.impl;

import org.dfe.exceptions.CircuitBreakerException;
import org.dfe.exceptions.DfeUncheckedException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.circuitbreaker.CircuitBreakerState;
import org.dfe.interfaces.internal.ThrowableSupplier;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class SimpleCircuitBreaker extends GenericCircuitBreaker {

    private final int failureThreshold;
    private final long timeoutMillis;

    private final AtomicReference<CircuitBreakerState> state = new AtomicReference<>(CircuitBreakerState.CLOSED);
    private final AtomicInteger failureCount = new AtomicInteger(0);
    private final AtomicLong lastFailureTime = new AtomicLong(0);

    public SimpleCircuitBreaker(int failureThreshold, long timeoutMillis) {
        this.failureThreshold = failureThreshold;
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    public <T> T execute(ThrowableSupplier<T> supplier) throws CircuitBreakerException, NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        long now = System.currentTimeMillis();

        // Verificação de estado OPEN
        if (state.get() == CircuitBreakerState.OPEN) {
            if ((now - lastFailureTime.get()) >= timeoutMillis) {
                state.compareAndSet(CircuitBreakerState.OPEN, CircuitBreakerState.HALF_OPEN);
            } else {
                throw new CircuitBreakerException("CircuitBreaker is OPEN");
            }
        }

        try {
            T result = supplier.get();
            onSuccess();
            return result;
        } catch (
                CircuitBreakerException | NoProviderFound | SecurityException | ProcessException |
                ValidationException | SoapServiceGeneralException | DfeUncheckedException e
        ) {
            throw e;
        } catch (RuntimeException e) {
            onFailure();
            throw e;
        } catch (Exception e) {
            onFailure();
            throw new CircuitBreakerException(e);
        }
    }

    @Override
    public CircuitBreakerState getState() {
        return state.get();
    }

    @Override
    protected void onSuccess() {
        failureCount.set(0);
        state.set(CircuitBreakerState.CLOSED);
    }

    @Override
    protected void onFailure() {
        failureCount.incrementAndGet();
        lastFailureTime.set(System.currentTimeMillis());

        if (failureCount.get() >= failureThreshold) {
            state.set(CircuitBreakerState.OPEN);
        }
    }
}


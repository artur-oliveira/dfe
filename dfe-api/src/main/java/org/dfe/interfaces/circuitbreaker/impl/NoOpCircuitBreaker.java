package org.dfe.interfaces.circuitbreaker.impl;

import org.dfe.interfaces.circuitbreaker.CircuitBreakerState;

public final class NoOpCircuitBreaker extends GenericCircuitBreaker {

    protected void onSuccess() {

    }

    protected void onFailure() {

    }

    @Override
    public CircuitBreakerState getState() {
        return CircuitBreakerState.CLOSED;
    }
}

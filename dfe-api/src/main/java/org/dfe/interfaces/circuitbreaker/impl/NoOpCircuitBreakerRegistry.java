package org.dfe.interfaces.circuitbreaker.impl;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.interfaces.circuitbreaker.CircuitBreaker;
import org.dfe.interfaces.circuitbreaker.CircuitBreakerRegistry;
import org.dfe.interfaces.circuitbreaker.DfeOperation;

public final class NoOpCircuitBreakerRegistry implements CircuitBreakerRegistry {

    private static final CircuitBreaker CIRCUIT_BREAKER = new NoOpCircuitBreaker();

    public CircuitBreaker get(Environment env, Model type, UF authorizer, DfeOperation operation) {
        return CIRCUIT_BREAKER;
    }
}


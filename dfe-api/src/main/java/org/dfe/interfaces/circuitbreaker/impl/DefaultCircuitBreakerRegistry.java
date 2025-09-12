package org.dfe.interfaces.circuitbreaker.impl;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.interfaces.circuitbreaker.CircuitBreaker;
import org.dfe.interfaces.circuitbreaker.CircuitBreakerKey;
import org.dfe.interfaces.circuitbreaker.CircuitBreakerRegistry;
import org.dfe.interfaces.circuitbreaker.DfeOperation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DefaultCircuitBreakerRegistry implements CircuitBreakerRegistry {
    private final Map<CircuitBreakerKey, CircuitBreaker> breakers = new ConcurrentHashMap<>();
    private final int failureThreshold;
    private final long timeoutMillis;

    public DefaultCircuitBreakerRegistry(int failureThreshold, long timeoutMillis) {
        this.failureThreshold = failureThreshold;
        this.timeoutMillis = timeoutMillis;
    }

    public CircuitBreaker get(Environment env, Model type, UF authorizer, DfeOperation operation) {
        CircuitBreakerKey key = new CircuitBreakerKey(env, type, authorizer, operation);
        return breakers.computeIfAbsent(key, k -> new SimpleCircuitBreaker(
                failureThreshold,
                timeoutMillis
        ));
    }
}


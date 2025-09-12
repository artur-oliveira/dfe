package org.dfe.interfaces.circuitbreaker;

import org.dfe.interfaces.circuitbreaker.impl.DefaultCircuitBreakerRegistry;

import java.util.Optional;

public final class CircuitBreakerFactory {

    private static final Integer FAILURE_THRESHOLD = Integer.parseInt(Optional.ofNullable(System.getenv("org.dfe.circuit-breaker.failure-threshold")).orElse(System.getProperty("org.dfe.circuit-breaker.failure-threshold", "3")));
    private static final Integer TIMEOUT_MILLIS = Integer.parseInt(Optional.ofNullable(System.getenv("org.dfe.circuit-breaker.timeout-millis")).orElse(System.getProperty("org.dfe.circuit-breaker.timeout-millis", "15000")));

    private static volatile CircuitBreakerRegistry registry;

    public static void configure(CircuitBreakerRegistry customRegistry) {
        registry = customRegistry;
    }

    public static CircuitBreakerRegistry getInstance() {
        if (registry == null) {
            synchronized (CircuitBreakerFactory.class) {
                if (registry == null) {
                    registry = new DefaultCircuitBreakerRegistry(
                            FAILURE_THRESHOLD, TIMEOUT_MILLIS
                    );
                }
            }
        }
        return registry;
    }
}


package org.dfe.interfaces.circuitbreaker;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;

public interface CircuitBreakerRegistry {
    CircuitBreaker get(
            Environment env,
            Model type,
            UF authorizer,
            DfeOperation operation
    );
}
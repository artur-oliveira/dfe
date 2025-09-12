package org.dfe.interfaces.circuitbreaker;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;

public record CircuitBreakerKey(
        Environment environment,
        Model type,
        UF authorizer,
        DfeOperation method
) {
}


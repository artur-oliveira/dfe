package org.dfe.models.internal.mdfe;

import org.dfe.enums.internal.UF;
import lombok.Builder;

@Builder
public record RouteLocator(
        UF start,
        UF end,
        boolean includeStartEnd
) {

}

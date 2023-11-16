package org.dfe.models.internal.port;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.cte.CteAuthorizer;
import org.dfe.enums.internal.cte.CtePathEndpoint;
import lombok.Builder;


@Builder
public record CteServiceFinder(
        CtePathEndpoint endpoint,
        CteAuthorizer authorizer,
        Environment environment
) implements Finder {

}

package org.dfe.models.internal.port;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.cte.Cte4Authorizer;
import org.dfe.enums.internal.cte.Cte4PathEndpoint;
import lombok.Builder;


@Builder
public record Cte4ServiceFinder(
        Cte4PathEndpoint endpoint,
        Cte4Authorizer authorizer,
        Environment environment
) implements Finder {

}

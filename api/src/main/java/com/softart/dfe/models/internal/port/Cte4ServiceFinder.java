package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.cte.Cte4Authorizer;
import com.softart.dfe.enums.internal.cte.Cte4PathEndpoint;
import lombok.Builder;


@Builder
public record Cte4ServiceFinder(
        Cte4PathEndpoint endpoint,
        Cte4Authorizer authorizer,
        Environment environment
) implements Finder {

}

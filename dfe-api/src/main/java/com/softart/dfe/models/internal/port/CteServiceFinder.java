package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.cte.CteAuthorizer;
import com.softart.dfe.enums.internal.cte.CtePathEndpoint;
import lombok.Builder;


@Builder
public record CteServiceFinder(
        CtePathEndpoint endpoint,
        CteAuthorizer authorizer,
        Environment environment
) implements Finder {

}

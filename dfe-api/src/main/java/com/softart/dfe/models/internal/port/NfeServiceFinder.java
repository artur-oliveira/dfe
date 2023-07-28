package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.enums.internal.nf.NfePathEndpoint;
import lombok.Builder;


@Builder
public record NfeServiceFinder(
        NfePathEndpoint endpoint,
        NfeAuthorizer authorizer,
        Environment environment
) implements Finder {

}

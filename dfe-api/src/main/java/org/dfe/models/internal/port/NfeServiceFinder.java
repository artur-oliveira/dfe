package org.dfe.models.internal.port;

import lombok.Builder;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.enums.internal.nf.NfePathEndpoint;


@Builder
public record NfeServiceFinder(
        NfePathEndpoint endpoint,
        NfeAuthorizer authorizer,
        Environment environment
) implements Finder {

}

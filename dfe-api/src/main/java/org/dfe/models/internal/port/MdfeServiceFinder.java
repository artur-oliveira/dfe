package org.dfe.models.internal.port;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.mdfe.MdfeAuthorizer;
import org.dfe.enums.internal.mdfe.MdfePathEndpoint;
import lombok.Builder;

@Builder
public record MdfeServiceFinder(
        MdfePathEndpoint endpoint,
        MdfeAuthorizer authorizer,
        Environment environment
) implements Finder {

}

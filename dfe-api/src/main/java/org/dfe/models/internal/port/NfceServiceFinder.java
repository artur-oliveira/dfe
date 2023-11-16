package org.dfe.models.internal.port;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.nf.NfceAuthorizer;
import org.dfe.enums.internal.nf.NfcePathEndpoint;
import lombok.Builder;

@Builder
public record NfceServiceFinder(
        NfcePathEndpoint endpoint,
        NfceAuthorizer authorizer,
        Environment environment
) implements Finder {

}

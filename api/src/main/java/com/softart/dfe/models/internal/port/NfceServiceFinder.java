package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.nf.NfceAuthorizer;
import com.softart.dfe.enums.internal.nf.NfcePathEndpoint;
import lombok.Builder;

@Builder
public record NfceServiceFinder(
        NfcePathEndpoint endpoint,
        NfceAuthorizer authorizer,
        Environment environment
) implements Finder {

}

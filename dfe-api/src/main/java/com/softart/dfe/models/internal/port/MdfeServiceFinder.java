package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.mdfe.MdfeAuthorizer;
import com.softart.dfe.enums.internal.mdfe.MdfePathEndpoint;
import lombok.Builder;

@Builder
public record MdfeServiceFinder(
        MdfePathEndpoint endpoint,
        MdfeAuthorizer authorizer,
        Environment environment
) implements Finder {

}

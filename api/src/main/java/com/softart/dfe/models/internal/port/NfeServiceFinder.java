package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.nf.NfeAuthorizer;
import com.softart.dfe.enums.internal.nf.NfePathEndpoint;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class NfeServiceFinder extends Finder {
    public NfePathEndpoint endpoint;
    public NfeAuthorizer authorizer;
    public Environment environment;

}

package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.mdfe.MdfeAuthorizer;
import com.softart.dfe.enums.internal.mdfe.MdfePathEndpoint;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeServiceFinder extends Finder {
    public MdfePathEndpoint endpoint;
    public MdfeAuthorizer authorizer;
    public Environment environment;

}

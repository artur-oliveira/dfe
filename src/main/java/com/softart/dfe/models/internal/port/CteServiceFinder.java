package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.cte.CteAuthorizer;
import com.softart.dfe.enums.internal.cte.CtePathEndpoint;
import lombok.*;
import lombok.extern.log4j.Log4j2;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CteServiceFinder extends Finder {
    public CtePathEndpoint endpoint;
    public CteAuthorizer authorizer;
    public Environment environment;

}

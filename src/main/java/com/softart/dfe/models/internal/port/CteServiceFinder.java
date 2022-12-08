package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.cte.CteAuthorizer;
import com.softart.dfe.enums.internal.cte.CtePathEndpoint;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@With
@Log4j2
public final class CteServiceFinder extends Finder {
    public CtePathEndpoint endpoint;
    public CteAuthorizer authorizer;
    public Environment environment;

}

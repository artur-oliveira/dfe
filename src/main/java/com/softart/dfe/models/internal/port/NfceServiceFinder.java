package com.softart.dfe.models.internal.port;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.nf.NfceAuthorizer;
import com.softart.dfe.enums.internal.nf.NfcePathEndpoint;
import com.softart.dfe.util.StringUtils;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class NfceServiceFinder extends Finder {
    public NfcePathEndpoint endpoint;
    public NfceAuthorizer authorizer;
    public Environment environment;

}

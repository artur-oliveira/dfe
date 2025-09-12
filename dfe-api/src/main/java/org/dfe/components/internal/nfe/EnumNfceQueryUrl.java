package org.dfe.components.internal.nfe;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.nf.QueryNfceURL;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.nf.NfceQueryUrl;

import java.util.Arrays;

public final class EnumNfceQueryUrl implements NfceQueryUrl {
    @Override
    public String get(UF uf, Environment environment) throws NoProviderFound {
        QueryNfceURL url = Arrays.stream(QueryNfceURL.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);
        return environment.production() ? url.production() : url.homologation();
    }
}

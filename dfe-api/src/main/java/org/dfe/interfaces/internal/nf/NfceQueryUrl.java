package org.dfe.interfaces.internal.nf;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.services.NoProviderFound;

public interface NfceQueryUrl {

    String get(UF uf, Environment environment) throws NoProviderFound;

}

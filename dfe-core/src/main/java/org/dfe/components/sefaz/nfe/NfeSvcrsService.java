package org.dfe.components.sefaz.nfe;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.identification.NFEmissionType;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings({"unused"})
public final class NfeSvcrsService extends NfeSvrsService {

    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, NFEmissionType.SVCRS);
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Arrays.asList(UF.AM, UF.BA, UF.GO, UF.MA, UF.MS, UF.MT, UF.PE, UF.PR);
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Arrays.asList(UF.AM, UF.BA, UF.GO, UF.MA, UF.MS, UF.MT, UF.PE, UF.PI, UF.PR);
    }
}
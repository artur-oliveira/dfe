package org.dfe.components.sefaz.nfe;

import lombok.Getter;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.interfaces.sefaz.nf.nfe.NfeService;
import org.dfe.interfaces.sefaz.port.NfeSoapService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Getter
@SuppressWarnings({"unused"})
public final class NfeSvcanService extends NfeSvanService {

    private NfeSoapService soapService;

    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, NFEmissionType.SVCAN);
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Arrays.asList(UF.AC, UF.AL, UF.AP, UF.CE, UF.DF, UF.ES, UF.MG, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RO, UF.RR, UF.RS, UF.SC, UF.SE, UF.SP, UF.TO);
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Arrays.asList(UF.AC, UF.AL, UF.AP, UF.CE, UF.DF, UF.ES, UF.MG, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RO, UF.RR, UF.RS, UF.SC, UF.SE, UF.SP, UF.TO);
    }

    @Override
    public NfeService withSoapService(NfeSoapService nfeSoapService) {
        this.soapService = nfeSoapService;
        return this;
    }
}

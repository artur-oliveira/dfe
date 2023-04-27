package com.softart.dfe.models.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.AfterReceptionSync;
import com.softart.dfe.interfaces.process.mdfe.reception_sync.BeforeReceptionSync;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeReceptionSyncValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeSyncRequest implements SefazRequest<TMDFe, TRetMDFe> {
    public TMDFe data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<MdfeReceptionSyncValidator> validators;
    public Collection<BeforeReceptionSync> beforeRequest;
    public Collection<AfterReceptionSync> afterRequest;
}


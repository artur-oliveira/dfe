package com.softart.dfe.models.cte.reception_os;

import br.inf.portalfiscal.cte.send.TCTeOS;
import br.inf.portalfiscal.cte.send.TRetCTeOS;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte.reception_os.AfterReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_os.BeforeReceptionCteOs;
import com.softart.dfe.interfaces.process.cte.reception_sync.AfterReceptionCteSync;
import com.softart.dfe.interfaces.process.cte.reception_sync.BeforeReceptionCteSync;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteOsValidator;
import com.softart.dfe.interfaces.validation.cte.CteReceptionCteSyncValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSigner;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class CteOsRequest implements SefazRequest<TCTeOS, TRetCTeOS> {
    public TCTeOS data;
    public Config config;
    public XMLSigner signer;
    public ConfigureProvider configureProvider;
    public Collection<CteReceptionCteOsValidator> validators;
    public Collection<BeforeReceptionCteOs> beforeRequest;
    public Collection<AfterReceptionCteOs> afterRequest;
}

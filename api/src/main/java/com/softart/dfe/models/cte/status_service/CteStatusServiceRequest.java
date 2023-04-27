package com.softart.dfe.models.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte.status_service.AfterStatusService;
import com.softart.dfe.interfaces.process.cte.status_service.BeforeStatusService;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte.CteStatusServiceValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.*;

import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class CteStatusServiceRequest implements SefazRequest<TConsStatServ, TRetConsStatServ> {
    public TConsStatServ data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<CteStatusServiceValidator> validators;
    public Collection<BeforeStatusService> beforeRequest;
    public Collection<AfterStatusService> afterRequest;
}

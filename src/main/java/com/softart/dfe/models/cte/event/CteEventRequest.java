package com.softart.dfe.models.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import br.inf.portalfiscal.cte.send.TRetEvento;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte.event.AfterEvent;
import com.softart.dfe.interfaces.process.cte.event.BeforeEvent;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte.CteEventValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.*;

import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class CteEventRequest implements SefazRequest<TEvento, TRetEvento> {
    private TEvento data;
    private Config config;
    private XMLSignerService signer;
    private ConfigureProvider configureProvider;
    private Collection<CteEventValidator> validators;
    private Collection<BeforeEvent> beforeRequest;
    private Collection<AfterEvent> afterRequest;
}

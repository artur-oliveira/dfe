package com.softart.dfe.models.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.event.AfterEvent;
import com.softart.dfe.interfaces.process.mdfe.event.BeforeEvent;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeEventValidator;
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
public final class MdfeEventRequest implements SefazRequest<TEvento, TRetEvento> {
    public TEvento data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<MdfeEventValidator> validators;
    public Collection<BeforeEvent> beforeRequest;
    public Collection<AfterEvent> afterRequest;
}

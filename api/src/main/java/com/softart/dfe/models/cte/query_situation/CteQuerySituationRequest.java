package com.softart.dfe.models.cte.query_situation;

import br.inf.portalfiscal.cte.send.TConsSitCTe;
import br.inf.portalfiscal.cte.send.TRetConsSitCTe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.cte.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte.CteQuerySituationValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class CteQuerySituationRequest implements SefazRequest<TConsSitCTe, TRetConsSitCTe> {
    public TConsSitCTe data;
    public Config config;
    public XMLSignerService signer;
    public ConfigureProvider configureProvider;
    public Collection<CteQuerySituationValidator> validators;
    public Collection<BeforeQuerySituation> beforeRequest;
    public Collection<AfterQuerySituation> afterRequest;
}

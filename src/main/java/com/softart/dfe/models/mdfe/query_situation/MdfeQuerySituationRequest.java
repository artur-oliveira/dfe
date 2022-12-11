package com.softart.dfe.models.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.mdfe.query_situation.AfterQuerySituation;
import com.softart.dfe.interfaces.process.mdfe.query_situation.BeforeQuerySituation;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.AfterQueryUnclosed;
import com.softart.dfe.interfaces.process.mdfe.query_unclosed.BeforeQueryUnclosed;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQuerySituationValidator;
import com.softart.dfe.interfaces.validation.mdfe.MdfeQueryUnclosedValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSigner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeQuerySituationRequest implements SefazRequest<TConsSitMDFe, TRetConsSitMDFe> {
    public TConsSitMDFe data;
    public Config config;
    public XMLSigner signer;
    public ConfigureProvider configureProvider;
    public Collection<MdfeQuerySituationValidator> validators;
    public Collection<BeforeQuerySituation> beforeRequest;
    public Collection<AfterQuerySituation> afterRequest;
}

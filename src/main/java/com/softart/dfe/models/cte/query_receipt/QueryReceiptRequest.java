package com.softart.dfe.models.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import com.softart.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.cte.CteQueryReceiptValidator;
import com.softart.dfe.interfaces.wsdl.ConfigureProvider;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class QueryReceiptRequest implements SefazRequest<TConsReciCTe, TRetConsReciCTe> {
    private TConsReciCTe data;
    private Config config;
    private XMLSignerService signer;
    private ConfigureProvider configureProvider;
    private Collection<CteQueryReceiptValidator> validators;
    private Collection<BeforeQueryReceipt> beforeRequest;
    private Collection<AfterQueryReceipt> afterRequest;
}

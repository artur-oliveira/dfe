package org.dfe.models.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.cte.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.cte.query_receipt.BeforeQueryReceipt;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.cte.CteQueryReceiptValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record QueryReceiptRequest(
        TConsReciCTe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<CteQueryReceiptValidator> validators,
        Collection<BeforeQueryReceipt> beforeRequest,
        Collection<AfterQueryReceipt> afterRequest
) implements SefazRequest<TConsReciCTe, TRetConsReciCTe> {
}

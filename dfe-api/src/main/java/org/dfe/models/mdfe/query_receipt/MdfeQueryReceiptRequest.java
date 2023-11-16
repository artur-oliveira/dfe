package org.dfe.models.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.mdfe.query_receipt.AfterQueryReceipt;
import org.dfe.interfaces.process.mdfe.query_receipt.BeforeQueryReceipt;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.mdfe.MdfeQueryReceiptValidator;
import org.dfe.interfaces.wsdl.ConfigureProvider;
import org.dfe.interfaces.xml.XMLSignerService;
import lombok.Builder;

import java.util.Collection;

@Builder
public record MdfeQueryReceiptRequest(
        TConsReciMDFe data,
        Config config,
        XMLSignerService signer,
        ConfigureProvider configureProvider,
        Collection<MdfeQueryReceiptValidator> validators,
        Collection<BeforeQueryReceipt> beforeRequest,
        Collection<AfterQueryReceipt> afterRequest
) implements SefazRequest<TConsReciMDFe, TRetConsReciMDFe> {


}

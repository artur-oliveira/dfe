package com.softart.dfe.interfaces.process.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterReturnAuthorization extends AfterWebServiceRequest<TConsReciNFe, TRetConsReciNFe> {
}

package com.softart.dfe.interfaces.process.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;

public interface AfterAuthorization extends AfterWebServiceRequest<TEnviNFe, TRetEnviNFe> {
}

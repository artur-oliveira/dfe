package br.inf.portalfiscal.nfe.wsdl.status_service.ms.prod;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "NFeStatusServico4", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeStatusServico4 {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.status_service.ms.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4/nfeStatusServicoNF")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", partName = "nfeStatusServicoNFResult")
    NfeResultMsg nfeStatusServicoNF(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}

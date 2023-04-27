package br.inf.portalfiscal.nfe.wsdl.return_authorization.ms.prod;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "NFeRetAutorizacaoSoap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeRetAutorizacaoSoap {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.return_authorization.ms.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4/nfeRetAutorizacaoLote")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", partName = "nfeRetAutorizacaoLoteResult")
    @Action(input = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4/nfeRetAutorizacaoLote", output = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4/NFeRetAutorizacaoSoap/nfeRetAutorizacaoLoteResponse")
    NfeResultMsg nfeRetAutorizacaoLote(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRetAutorizacao4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}


package br.inf.portalfiscal.nfe.wsdl.query_register.mt.hom;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "CadConsultaCadastro4Soap12", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface CadConsultaCadastro4Soap12 {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.query_register.mt.hom.NfeResultMsg.ConsultaCadastroResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4/consultaCadastro")
    @WebResult(name = "consultaCadastroResult", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")
    @RequestWrapper(localName = "consultaCadastro", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", className = "br.inf.portalfiscal.nfe.wsdl.query_register.mt.hom.ConsultaCadastro")
    @ResponseWrapper(localName = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", className = "br.inf.portalfiscal.nfe.wsdl.query_register.mt.hom.NfeResultMsg")
    public NfeResultMsg.ConsultaCadastroResult consultaCadastro(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")
            ConsultaCadastro.NfeDadosMsg nfeDadosMsg);

}

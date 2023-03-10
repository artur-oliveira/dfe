package br.inf.portalfiscal.nfe.wsdl.inutilization.ms.nfce.prod;

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
@WebService(name = "NFeInutilizacaoSoap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeInutilizacaoSoap {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.inutilization.ms.nfce.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4/nfeInutilizacaoNF")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", partName = "nfeResultMsg")
    @Action(input = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4/nfeInutilizacaoNF", output = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4/NFeInutilizacaoSoap/nfeInutilizacaoNFResponse")
    NfeResultMsg nfeInutilizacaoNF(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}

package br.inf.portalfiscal.nfe.wsdl.inutilization.svcan.prod;

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
@WebService(name = "NFeInutilizacao4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeInutilizacao4Soap {


    /**
     * Serviço destinado ao atendimento de solicitações de inutilização de numeração
     *
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.inutilization.svcan.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4/nfeInutilizacaoNF")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", partName = "nfeInutilizacaoNFResult")
    NfeResultMsg nfeInutilizacaoNF(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeInutilizacao4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}

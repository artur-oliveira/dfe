
package br.inf.portalfiscal.nfe.wsdl.query_protocol.svcan.prod;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "NFeConsultaProtocolo4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeConsultaProtocolo4Soap {


    /**
     * Serviço destinado ao atendimento de solicitações de consulta da situação atual da NF-e na Base de Dados do Portal da Sefaz Virtual do Ambiente Nacional
     * 
     * @param nfeDadosMsg
     * @return
     *     returns br.inf.portalfiscal.nfe.wsdl.query_protocol.svcan.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4/nfeConsultaNF")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", partName = "nfeConsultaNFResult")
    public NfeResultMsg nfeConsultaNF(
        @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", partName = "nfeDadosMsg")
        NfeDadosMsg nfeDadosMsg);

}

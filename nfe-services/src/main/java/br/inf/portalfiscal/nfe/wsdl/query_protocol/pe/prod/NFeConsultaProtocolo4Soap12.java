package br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.prod;

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
@WebService(name = "NFeConsultaProtocolo4Soap12", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeConsultaProtocolo4Soap12 {


    /**
     * Consulta situacao atual da NFe
     *
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4/nfeConsultaNF")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", partName = "nfeResultMsg")
    NfeResultMsg nfeConsultaNF(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeConsultaProtocolo4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}

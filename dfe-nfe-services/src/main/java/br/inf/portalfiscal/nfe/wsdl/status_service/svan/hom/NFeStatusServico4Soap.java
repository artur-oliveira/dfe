package br.inf.portalfiscal.nfe.wsdl.status_service.svan.hom;

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
 */
@WebService(name = "NFeStatusServico4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeStatusServico4Soap {


    /**
     * Serviço destinado à consulta do status do serviço prestado pela Sefaz Virtual do Ambiente Nacional
     *
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.status_service.svan.hom.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4/nfeStatusServicoNF")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", partName = "nfeStatusServicoNFResult")
    public NfeResultMsg nfeStatusServicoNF(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}
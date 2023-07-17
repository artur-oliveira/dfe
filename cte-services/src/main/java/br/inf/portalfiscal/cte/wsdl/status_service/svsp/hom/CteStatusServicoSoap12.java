package br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Holder;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebService(name = "CteStatusServicoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteStatusServicoSoap12 {


    /**
     * Consulta Status do Serviço
     *
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.CteStatusServicoCTResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico/cteStatusServicoCT")
    @WebResult(name = "cteStatusServicoCTResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico", partName = "cteStatusServicoCTResult")
    public CteStatusServicoCTResult cteStatusServicoCT(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg,
            @WebParam(name = "cteCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServico", header = true, mode = WebParam.Mode.INOUT, partName = "cteCabecMsg")
            Holder<CteCabecMsg> cteCabecMsg);

}

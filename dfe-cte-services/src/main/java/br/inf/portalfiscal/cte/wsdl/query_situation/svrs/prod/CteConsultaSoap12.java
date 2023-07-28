package br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod;

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
@WebService(name = "CteConsultaSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteConsultaSoap12 {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteConsultaCTResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta/cteConsultaCT")
    @WebResult(name = "cteConsultaCTResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", partName = "cteConsultaCTResult")
    public CteConsultaCTResult cteConsultaCT(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg,
            @WebParam(name = "cteCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteConsulta", header = true, mode = WebParam.Mode.INOUT, partName = "cteCabecMsg")
            Holder<CteCabecMsg> cteCabecMsg);

}

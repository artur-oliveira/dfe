package br.inf.portalfiscal.cte.wsdl.event.mt.prod;

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
@WebService(name = "CteRecepcaoEventoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteRecepcaoEventoSoap12 {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.event.mt.prod.CteRecepcaoEventoResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento/cteRecepcaoEvento")
    @WebResult(name = "cteRecepcaoEventoResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", partName = "cteRecepcaoEventoResult")
    CteRecepcaoEventoResult cteRecepcaoEvento(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg);

}

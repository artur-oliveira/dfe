
package br.inf.portalfiscal.cte4.wsdl.status_service.mt.prod;

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
@WebService(name = "CteStatusServicoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class, br.inf.portalfiscal.cte.send400.ObjectFactory.class
})
public interface CteStatusServicoSoap12 {


    /**
     * 
     * @param cteDadosMsg
     * @return
     *     returns br.inf.portalfiscal.cte4.wsdl.status_service.mt.prod.CteStatusServicoCTResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteStatusServicoV4/CTeStatusServicoV4")
    @WebResult(name = "cteStatusServicoCTResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4", partName = "cteStatusServicoCTResult")
    public CteStatusServicoCTResult cteStatusServicoCT(
        @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeStatusServicoV4", partName = "cteDadosMsg")
        CteDadosMsg cteDadosMsg);

}

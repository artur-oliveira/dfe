
package br.inf.portalfiscal.cte4.wsdl.event.mg.hom;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "CTeRecepcaoEventoV4Soap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class, br.inf.portalfiscal.cte.send400.ObjectFactory.class
})
public interface CTeRecepcaoEventoV4Soap12 {


    /**
     * 
     * @param cteDadosMsg
     * @return
     *     returns br.inf.portalfiscal.cte4.wsdl.event.mg.hom.CteRecepcaoEventoResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento/cteRecepcaoEvento")
    @WebResult(name = "cteRecepcaoEventoResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", partName = "cteRecepcaoEventoResult")
    @Action(input = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento/cteRecepcaoEvento", output = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento/CTeRecepcaoEventoV4Soap12/cteRecepcaoEventoResponse")
    public CteRecepcaoEventoResult cteRecepcaoEvento(
        @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoEvento", partName = "cteDadosMsg")
        CteDadosMsg cteDadosMsg);

}

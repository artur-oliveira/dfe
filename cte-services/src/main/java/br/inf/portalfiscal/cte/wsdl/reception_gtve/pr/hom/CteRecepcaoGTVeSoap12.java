package br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.hom;

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
@WebService(name = "CteRecepcaoGTVeSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoGTVe")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteRecepcaoGTVeSoap12 {


    /**
     * RecepÃ§Ã£o de mensagens de GTVe (modelo
     * 64)
     *
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.hom.CteRecepcaoGTVeResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoGTVe/cteRecepcaoGTVe")
    @WebResult(name = "cteRecepcaoGTVeResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoGTVe", partName = "cteRecepcaoGTVeResult")
    CteRecepcaoGTVeResult cteRecepcaoGTVe(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoGTVe", partName = "cteDadosMsg")
            String cteDadosMsg);

}

package br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom;

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
@WebService(name = "CTeRecepcaoGTVeSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CTeRecepcaoGTVeSoap12 {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom.CteRecepcaoGTVeResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe/cteRecepcaoGTVe")
    @WebResult(name = "cteRecepcaoGTVeResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", partName = "cteRecepcaoGTVeResult")
    public CteRecepcaoGTVeResult cteRecepcaoGTVe(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", partName = "cteDadosMsg")
            String cteDadosMsg);

}

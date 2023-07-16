package br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.prod;

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
 */
@WebService(name = "CTeRecepcaoGTVeV4Soap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send400.ObjectFactory.class
})
public interface CTeRecepcaoGTVeV4Soap12 {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.prod.CteRecepcaoGTVeResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4/cteRecepcaoGTVe")
    @WebResult(name = "cteRecepcaoGTVeResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4", partName = "cteRecepcaoGTVeResult")
    @Action(input = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4/cteRecepcaoGTVe", output = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4/CTeRecepcaoGTVeV4Soap12/cteRecepcaoGTVeResponse")
    public CteRecepcaoGTVeResult cteRecepcaoGTVe(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVeV4", partName = "cteDadosMsg")
            String cteDadosMsg);

}

package br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod;

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
@WebService(name = "CteInutilizacaoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteInutilizacaoSoap12 {


    /**
     * Inutilização de numeração de CT-e
     *
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.CteInutilizacaoCTResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao/cteInutilizacaoCT")
    @WebResult(name = "cteInutilizacaoCTResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", partName = "cteInutilizacaoCTResult")
    CteInutilizacaoCTResult cteInutilizacaoCT(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg);

}

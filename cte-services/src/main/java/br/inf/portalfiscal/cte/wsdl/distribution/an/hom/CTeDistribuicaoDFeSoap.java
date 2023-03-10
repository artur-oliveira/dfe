package br.inf.portalfiscal.cte.wsdl.distribution.an.hom;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "CTeDistribuicaoDFeSoap", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe")
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.distribution.ObjectFactory.class
})
public interface CTeDistribuicaoDFeSoap {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.distribution.an.hom.CteDistDFeInteresseResponse.CteDistDFeInteresseResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe/cteDistDFeInteresse")
    @WebResult(name = "cteDistDFeInteresseResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe")
    @RequestWrapper(localName = "cteDistDFeInteresse", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", className = "br.inf.portalfiscal.cte.wsdl.distribution.an.hom.CteDistDFeInteresse")
    @ResponseWrapper(localName = "cteDistDFeInteresseResponse", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe", className = "br.inf.portalfiscal.cte.wsdl.distribution.an.hom.CteDistDFeInteresseResponse")
    CteDistDFeInteresseResponse.CteDistDFeInteresseResult cteDistDFeInteresse(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeDistribuicaoDFe")
            CteDistDFeInteresse.CteDadosMsg cteDadosMsg);

}

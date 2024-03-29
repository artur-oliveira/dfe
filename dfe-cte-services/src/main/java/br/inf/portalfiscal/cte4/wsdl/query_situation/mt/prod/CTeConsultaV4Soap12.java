package br.inf.portalfiscal.cte4.wsdl.query_situation.mt.prod;

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
@WebService(name = "CTeConsultaV4Soap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send400.ObjectFactory.class
})
public interface CTeConsultaV4Soap12 {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte4.wsdl.query_situation.mt.hom.CteConsultaCTResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4/cteConsultaCT")
    @WebResult(name = "cteConsultaCTResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4", partName = "cteConsultaCTResult")
    public CteConsultaCTResult cteConsultaCT(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeConsultaV4", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg);

}

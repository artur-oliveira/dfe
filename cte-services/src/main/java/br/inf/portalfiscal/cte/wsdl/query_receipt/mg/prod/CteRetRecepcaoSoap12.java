package br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod;

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
@WebService(name = "CteRetRecepcaoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteRetRecepcaoSoap12 {


    /**
     * Consulta Processamento de Lote de CT-e
     *
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.CteRetRecepcaoResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao/cteRetRecepcao")
    @WebResult(name = "cteRetRecepcaoResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao", partName = "cteRetRecepcaoResult")
    public CteRetRecepcaoResult cteRetRecepcao(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRetRecepcao", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg);

}

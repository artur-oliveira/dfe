package br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom;

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
@WebService(name = "CteRecepcaoOSSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteRecepcaoOSSoap12 {


    /**
     * Transmissão do CT-e Outros Serviços
     *
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.CteOSRecepcaoResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS/cteOSRecepcao")
    @WebResult(name = "cteOSRecepcaoResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", partName = "cteOSRecepcaoResult")
    public CteOSRecepcaoResult cteOSRecepcao(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg);

}

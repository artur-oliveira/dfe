package br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod;

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
@WebService(name = "MDFeStatusServicoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeStatusServico")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.mdfe.classes.ObjectFactory.class
})
public interface MDFeStatusServicoSoap12 {


    /**
     * @param mdfeDadosMsg
     * @return returns br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.MdfeStatusServicoMDFResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeStatusServico/mdfeStatusServicoMDF")
    @WebResult(name = "mdfeStatusServicoMDFResult", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeStatusServico", partName = "mdfeStatusServicoMDFResult")
    MdfeStatusServicoMDFResult mdfeStatusServicoMDF(
            @WebParam(name = "mdfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeStatusServico", partName = "mdfeDadosMsg")
            MdfeDadosMsg mdfeDadosMsg);

}

package br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod;

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
@WebService(name = "MDFeDistribuicaoDFeSoap12", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeDistribuicaoDFe")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.mdfe.classes.ObjectFactory.class
})
public interface MDFeDistribuicaoDFeSoap12 {


    /**
     * @param mdfeDadosMsg
     * @return returns br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.MdfeDistDFeInteresseResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeDistribuicaoDFe/mdfeDistDFeInteresse")
    @WebResult(name = "mdfeDistDFeInteresseResult", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeDistribuicaoDFe", partName = "mdfeDistDFeInteresseResult")
    MdfeDistDFeInteresseResult mdfeDistDFeInteresse(
            @WebParam(name = "mdfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeDistribuicaoDFe", partName = "mdfeDadosMsg")
            MdfeDadosMsg mdfeDadosMsg);

}

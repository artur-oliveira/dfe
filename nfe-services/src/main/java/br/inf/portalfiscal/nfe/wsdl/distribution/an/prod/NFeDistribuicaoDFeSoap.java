package br.inf.portalfiscal.nfe.wsdl.distribution.an.prod;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebService(name = "NFeDistribuicaoDFeSoap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe")
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.distribution.ObjectFactory.class
})
public interface NFeDistribuicaoDFeSoap {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NfeDistDFeInteresseResponse.NfeDistDFeInteresseResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe/nfeDistDFeInteresse")
    @WebResult(name = "nfeDistDFeInteresseResult", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe")
    @RequestWrapper(localName = "nfeDistDFeInteresse", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", className = "br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NfeDistDFeInteresse")
    @ResponseWrapper(localName = "nfeDistDFeInteresseResponse", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe", className = "br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NfeDistDFeInteresseResponse")
    NfeDistDFeInteresseResponse.NfeDistDFeInteresseResult nfeDistDFeInteresse(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeDistribuicaoDFe")
            NfeDistDFeInteresse.NfeDadosMsg nfeDadosMsg);

}

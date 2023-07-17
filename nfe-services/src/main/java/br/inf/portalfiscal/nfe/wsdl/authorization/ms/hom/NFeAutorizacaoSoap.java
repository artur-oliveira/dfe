package br.inf.portalfiscal.nfe.wsdl.authorization.ms.hom;

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
@WebService(name = "NFeAutorizacaoSoap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeAutorizacaoSoap {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.authorization.ms.hom.NfeResultMsg2
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLote")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeResultMsg")
    @Action(input = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLote", output = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/NFeAutorizacaoSoap/nfeAutorizacaoLoteResponse")
    public NfeResultMsg2 nfeAutorizacaoLote(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsg")
            NfeResultMsg nfeDadosMsg);

    /**
     * @param nfeDadosMsgZip
     * @return returns br.inf.portalfiscal.nfe.wsdl.authorization.ms.hom.NfeResultMsg2
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLoteZIP")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeResultMsg")
    @Action(input = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLoteZIP", output = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/NFeAutorizacaoSoap/nfeAutorizacaoLoteZIPResponse")
    public NfeResultMsg2 nfeAutorizacaoLoteZIP(
            @WebParam(name = "nfeDadosMsgZip", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsgZip")
            String nfeDadosMsgZip);

}

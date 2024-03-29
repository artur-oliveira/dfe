package br.inf.portalfiscal.nfe.wsdl.authorization.mg.prod;

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
@WebService(name = "NFeAutorizacao4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeAutorizacao4Soap {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.authorization.mg.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLote")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeAutorizacaoLoteResult")
    @Action(input = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLote", output = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/NFeAutorizacao4Soap/nfeAutorizacaoLoteResponse")
    public NfeResultMsg nfeAutorizacaoLote(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

    /**
     * @param nfeDadosMsgZip
     * @return returns br.inf.portalfiscal.nfe.wsdl.authorization.mg.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLoteZip")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeAutorizacaoLoteZipResult")
    @Action(input = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLoteZip", output = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/NFeAutorizacao4Soap/nfeAutorizacaoLoteZipResponse")
    public NfeResultMsg nfeAutorizacaoLoteZip(
            @WebParam(name = "nfeDadosMsgZip", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsgZip")
            String nfeDadosMsgZip);

}

package br.inf.portalfiscal.nfe.wsdl.authorization.go.nfce.prod;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "NFeAutorizacao4Service", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface NFeAutorizacao4Service {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.authorization.go.nfce.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLote")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeAutorizacaoLoteResult")
    NfeResultMsg nfeAutorizacaoLote(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

    /**
     * @param nfeDadosMsgZip
     * @return returns br.inf.portalfiscal.nfe.wsdl.authorization.go.nfce.prod.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4/nfeAutorizacaoLoteZIP")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeAutorizacaoLoteZIPResult")
    NfeResultMsg nfeAutorizacaoLoteZIP(
            @WebParam(name = "nfeDadosMsgZip", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4", partName = "nfeDadosMsgZip")
            NfeDadosMsgZip nfeDadosMsgZip);

}

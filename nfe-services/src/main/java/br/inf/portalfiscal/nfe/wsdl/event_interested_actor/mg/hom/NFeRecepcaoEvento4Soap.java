package br.inf.portalfiscal.nfe.wsdl.event_interested_actor.mg.hom;

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
@WebService(name = "NFeRecepcaoEvento4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory.class
})
public interface NFeRecepcaoEvento4Soap {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.event_interested_actor.mg.hom.NFeRecepcaoEvento4Result
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4/nfeRecepcaoEvento")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", partName = "nfeResultMsg")
    NFeRecepcaoEvento4Result nfeRecepcaoEvento(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}

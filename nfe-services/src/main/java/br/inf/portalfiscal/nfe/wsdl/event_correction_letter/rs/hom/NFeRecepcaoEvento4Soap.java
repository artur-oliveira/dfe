package br.inf.portalfiscal.nfe.wsdl.event_correction_letter.rs.hom;

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
@WebService(name = "NFeRecepcaoEvento4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory.class
})
public interface NFeRecepcaoEvento4Soap {


    /**
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.event_correction_letter.rs.hom.NfeResultMsg
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4/nfeRecepcaoEvento")
    @WebResult(name = "nfeResultMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", partName = "nfeRecepcaoEventoResult")
    NfeResultMsg nfeRecepcaoEvento(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NFeRecepcaoEvento4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg);

}

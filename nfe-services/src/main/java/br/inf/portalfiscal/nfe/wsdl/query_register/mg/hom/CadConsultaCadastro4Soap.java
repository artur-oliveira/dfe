package br.inf.portalfiscal.nfe.wsdl.query_register.mg.hom;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.Holder;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 */
@WebService(name = "CadConsultaCadastro4Soap", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.nfe.send.ObjectFactory.class
})
public interface CadConsultaCadastro4Soap {


    /**
     * @param nfeCabecMsg
     * @param nfeDadosMsg
     * @return returns br.inf.portalfiscal.nfe.wsdl.query_register.mg.hom.ConsultaCadastro4Result
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4/consultaCadastro")
    @WebResult(name = "consultaCadastro4Result", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", partName = "consultaCadastro4Result")
    @Action(input = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4/consultaCadastro", output = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4/CadConsultaCadastro4Soap/consultaCadastroResponse")
    public ConsultaCadastro4Result consultaCadastro(
            @WebParam(name = "nfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", partName = "nfeDadosMsg")
            NfeDadosMsg nfeDadosMsg,
            @WebParam(name = "nfeCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro4", header = true, mode = WebParam.Mode.INOUT, partName = "nfeCabecMsg")
            Holder<NfeCabecMsg> nfeCabecMsg);

}

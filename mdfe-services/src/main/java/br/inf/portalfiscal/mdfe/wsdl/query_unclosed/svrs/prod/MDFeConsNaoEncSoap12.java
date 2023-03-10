package br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "MDFeConsNaoEncSoap12", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeConsNaoEnc")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.mdfe.classes.ObjectFactory.class
})
public interface MDFeConsNaoEncSoap12 {


    /**
     * @param mdfeDadosMsg
     * @return returns br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.MdfeConsNaoEncResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeConsNaoEnc/mdfeConsNaoEnc")
    @WebResult(name = "mdfeConsNaoEncResult", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeConsNaoEnc", partName = "mdfeConsNaoEncResult")
    MdfeConsNaoEncResult mdfeConsNaoEnc(
            @WebParam(name = "mdfeDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeConsNaoEnc", partName = "mdfeDadosMsg")
            MdfeDadosMsg mdfeDadosMsg,
            @WebParam(name = "mdfeCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/mdfe/wsdl/MDFeConsNaoEnc", header = true, mode = WebParam.Mode.INOUT, partName = "mdfeCabecMsg")
            Holder<MdfeCabecMsg> cteCabecMsg);

}

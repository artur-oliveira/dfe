package br.inf.portalfiscal.cte.wsdl.reception.ms.hom;

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
@WebService(name = "CteRecepcaoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteRecepcaoSoap12 {


    /**
     * Transmissão de Lote de CT-e
     *
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.reception.ms.hom.CteRecepcaoLoteResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao/cteRecepcaoLote")
    @WebResult(name = "cteRecepcaoLoteResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", partName = "cteRecepcaoLoteResult")
    CteRecepcaoLoteResult cteRecepcaoLote(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg,
            @WebParam(name = "cteCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcao", header = true, mode = WebParam.Mode.INOUT, partName = "cteCabecMsg")
            Holder<CTeCabecMsg> cteCabecMsg);

}

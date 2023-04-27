package br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod;


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
@WebService(name = "CteInutilizacaoSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteInutilizacaoSoap12 {


    /**
     * Inutilização de numeração de CT-e
     *
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.CteInutilizacaoCTResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao/cteInutilizacaoCT")
    @WebResult(name = "cteInutilizacaoCTResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", partName = "cteInutilizacaoCTResult")
    CteInutilizacaoCTResult cteInutilizacaoCT(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg,
            @WebParam(name = "cteCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteInutilizacao", header = true, mode = WebParam.Mode.INOUT, partName = "cteCabecMsg")
            Holder<CTeCabecMsg> cteCabecMsg
    );

}

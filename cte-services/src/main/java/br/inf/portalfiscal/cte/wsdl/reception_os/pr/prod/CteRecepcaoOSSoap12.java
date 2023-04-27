package br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod;

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
@WebService(name = "CteRecepcaoOSSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CteRecepcaoOSSoap12 {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.CteRecepcaoOSResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS/cteRecepcaoOS")
    @WebResult(name = "cteRecepcaoOSResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", partName = "cteRecepcaoOSResult")
    CteRecepcaoOSResult cteRecepcaoOS(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", partName = "cteDadosMsg")
            CteDadosMsg cteDadosMsg,
            @WebParam(name = "cteCabecMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CteRecepcaoOS", header = true, mode = WebParam.Mode.INOUT, partName = "cteCabecMsg")
            Holder<CteCabecMsg> cteCabecMsg);

}

package br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.hom;

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
@WebService(name = "CTeRecepcaoGTVeSoap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class, br.inf.portalfiscal.cte.send.ObjectFactory.class
})
public interface CTeRecepcaoGTVeSoap12 {


    /**
     * @param cteDadosMsg
     * @return returns br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.hom.CteRecepcaoGTVeResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe/cteRecepcaoGTVe")
    @WebResult(name = "cteRecepcaoGTVeResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", partName = "cteRecepcaoGTVeResult")
    CteRecepcaoGTVeResult cteRecepcaoGTVe(
            @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoGTVe", partName = "cteDadosMsg")
            String cteDadosMsg);

}

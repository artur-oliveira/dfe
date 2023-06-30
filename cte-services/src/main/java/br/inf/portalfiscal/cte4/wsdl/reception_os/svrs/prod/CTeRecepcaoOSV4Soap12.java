
package br.inf.portalfiscal.cte4.wsdl.reception_os.svrs.prod;

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
 * 
 */
@WebService(name = "CTeRecepcaoOSV4Soap12", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class, br.inf.portalfiscal.cte.send400.ObjectFactory.class
})
public interface CTeRecepcaoOSV4Soap12 {


    /**
     * 
     * @param cteDadosMsg
     * @return
     *     returns br.inf.portalfiscal.cte4.wsdl.reception_os.svrs.prod.CteRecepcaoOSResult
     */
    @WebMethod(action = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4/cteRecepcaoOS")
    @WebResult(name = "cteRecepcaoOSResult", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", partName = "cteRecepcaoOSResult")
    public CteRecepcaoOSResult cteRecepcaoOS(
        @WebParam(name = "cteDadosMsg", targetNamespace = "http://www.portalfiscal.inf.br/cte/wsdl/CTeRecepcaoOSV4", partName = "cteDadosMsg")
        String cteDadosMsg);

}

//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.09.08 às 05:56:18 PM BRT 
//


package br.inf.portalfiscal.nfe.event_substitute_cancel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TUf.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TUf"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="preserve"/&gt;
 *     &lt;enumeration value="AC"/&gt;
 *     &lt;enumeration value="AL"/&gt;
 *     &lt;enumeration value="AM"/&gt;
 *     &lt;enumeration value="AP"/&gt;
 *     &lt;enumeration value="BA"/&gt;
 *     &lt;enumeration value="CE"/&gt;
 *     &lt;enumeration value="DF"/&gt;
 *     &lt;enumeration value="ES"/&gt;
 *     &lt;enumeration value="GO"/&gt;
 *     &lt;enumeration value="MA"/&gt;
 *     &lt;enumeration value="MG"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="MT"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="PB"/&gt;
 *     &lt;enumeration value="PE"/&gt;
 *     &lt;enumeration value="PI"/&gt;
 *     &lt;enumeration value="PR"/&gt;
 *     &lt;enumeration value="RJ"/&gt;
 *     &lt;enumeration value="RN"/&gt;
 *     &lt;enumeration value="RO"/&gt;
 *     &lt;enumeration value="RR"/&gt;
 *     &lt;enumeration value="RS"/&gt;
 *     &lt;enumeration value="SC"/&gt;
 *     &lt;enumeration value="SE"/&gt;
 *     &lt;enumeration value="SP"/&gt;
 *     &lt;enumeration value="TO"/&gt;
 *     &lt;enumeration value="EX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TUf", namespace = "http://www.portalfiscal.inf.br/nfe")
@XmlEnum
public enum TUf {

    AC,
    AL,
    AM,
    AP,
    BA,
    CE,
    DF,
    ES,
    GO,
    MA,
    MG,
    MS,
    MT,
    PA,
    PB,
    PE,
    PI,
    PR,
    RJ,
    RN,
    RO,
    RR,
    RS,
    SC,
    SE,
    SP,
    TO,
    EX;

    public static TUf fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}

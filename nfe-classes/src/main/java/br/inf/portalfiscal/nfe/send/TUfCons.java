//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.2 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2023.03.16 às 01:10:23 PM BRT 
//


package br.inf.portalfiscal.nfe.send;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TUfCons.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TUfCons"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
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
 *     &lt;enumeration value="SU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TUfCons")
@XmlEnum
public enum TUfCons {

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
    SU;

    public static TUfCons fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}

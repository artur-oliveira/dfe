package com.softart.dfe.models.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class SendMdfeReturn implements DFObject, XMLAdapter<SendMdfeReturn, TRetEnviMDFe> {
    private Object tpAmb;
    private String cuf;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private InfRec infRec;
    private String versao;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class InfRec implements DFObject, XMLAdapter<InfRec, TRetEnviMDFe.InfRec> {
        private String nRec;
        @XmlSchemaType(name = "dateTime")
        private XMLGregorianCalendar dhRecbto;
        private BigInteger tMed;
    }
}

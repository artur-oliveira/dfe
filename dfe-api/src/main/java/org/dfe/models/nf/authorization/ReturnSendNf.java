package org.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnSendNf implements DFObject, XMLAdapter<ReturnSendNf, TRetEnviNFe> {
    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String cuf;
    protected String dhRecbto;
    protected InfRec infRec;
    protected NfProtocol protNFe;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfRec implements DFObject, XMLAdapter<InfRec, TRetEnviNFe.InfRec> {
        protected String nRec;
        protected String tMed;
    }

}

package org.dfe.models.nf.cancel;


import br.inf.portalfiscal.nfe.event_cancel.SignatureType;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnNfeCancel implements DFObject, XMLAdapter<ReturnNfeCancel, TRetEnvEvento> {

    protected String idLote;
    protected String tpAmb;
    protected String verAplic;
    protected String cOrgao;
    protected String cStat;
    protected String xMotivo;
    protected List<TRetEvento> retEvento;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TRetEvento implements DFObject, XMLAdapter<TRetEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEvento> {


        protected InfEvento infEvento;
        protected SignatureType signature;
        protected String versao;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEvento.InfEvento> {
            protected String tpAmb;
            protected String verAplic;
            protected String cOrgao;
            protected String cStat;
            protected String xMotivo;
            protected String chNFe;
            protected String tpEvento;
            protected String xEvento;
            protected String nSeqEvento;
            protected String cnpjDest;
            protected String cpfDest;
            protected String emailDest;
            protected String dhRegEvento;
            protected String nProt;
            protected String id;
        }

    }
}

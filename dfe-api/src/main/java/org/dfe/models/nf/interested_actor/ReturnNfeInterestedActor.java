package org.dfe.models.nf.interested_actor;


import br.inf.portalfiscal.nfe.event_interested_actor.SignatureType;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
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
public class ReturnNfeInterestedActor implements DFObject, XMLAdapter<ReturnNfeInterestedActor, TRetEnvEvento> {

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
    public static class TRetEvento implements DFObject, XMLAdapter<TRetEvento, br.inf.portalfiscal.nfe.event_interested_actor.TRetEvento> {


        protected InfEvento infEvento;
        protected SignatureType signature;
        protected String versao;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.nfe.event_interested_actor.TRetEvento.InfEvento> {
            protected String tpAmb;
            protected String verAplic;
            protected String cOrgao;
            protected String cStat;
            protected String xMotivo;
            protected String chNFe;
            protected String tpEvento;
            protected String xEvento;
            protected String nSeqEvento;
            protected String cOrgaoAutor;
            protected String dhRegEvento;
            protected String nProt;
            protected List<String> chNFePend;
            protected String id;
        }

    }
}

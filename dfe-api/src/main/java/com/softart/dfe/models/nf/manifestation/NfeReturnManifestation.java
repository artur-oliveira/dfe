package com.softart.dfe.models.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.SignatureType;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TretEvento;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfeReturnManifestation implements DFObject, XMLAdapter<NfeReturnManifestation, TRetEnvEvento> {

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
    public static class TRetEvento implements DFObject, XMLAdapter<TRetEvento, TretEvento> {


        protected InfEvento infEvento;
        protected SignatureType signature;
        protected String versao;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfEvento implements DFObject, XMLAdapter<InfEvento, TretEvento.InfEvento> {
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

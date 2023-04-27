package com.softart.dferestapi.models.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.EvIncDFeMDFe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.mdfe.event.MdfeDfeInclusion;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class DfeInclusionMdfe {
    @JsonIgnore
    private String chMDFe;
    @Size(min = 1)
    private String nSeqEvento;
    @Size(min = 15)
    private String nProt;
    @NotEmpty
    @Size(min = 7, max = 7)
    private String cMunCarrega;
    @NotEmpty
    private String xMunCarrega;
    @Size(min = 1)
    private List<MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc> infDoc;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class InfDoc implements DFObject, XMLAdapter<MdfeDfeInclusion.InfEvento.DetEvento.EvIncDFeMDFe.InfDoc, EvIncDFeMDFe.InfDoc> {
        private String cMunDescarga;
        private String xMunDescarga;
        private String chNFe;
    }
}

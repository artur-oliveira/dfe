package org.dfe.models.cte.reception;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CteSend implements DFObject, XMLAdapter<CteSend, TEnviCTe> {

    @Builder.Default
    private String idLote = StringUtils.random();
    private List<Cte> cTe;
    @Builder.Default
    private String versao = CteVersion.getDefault().getVersion();

}

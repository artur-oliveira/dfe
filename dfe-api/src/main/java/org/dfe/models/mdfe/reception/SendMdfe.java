package org.dfe.models.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import org.dfe.enums.mdfe.version.MdfeVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.models.mdfe.reception_sync.Mdfe;
import org.dfe.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class SendMdfe implements DFObject, XMLAdapter<SendMdfe, TEnviMDFe> {
    @Builder.Default
    private String idLote = StringUtils.random();
    private Mdfe mdFe;
    @Builder.Default
    private String versao = MdfeVersion.getDefault().getVersion();
}

package com.softart.dfe.models.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import com.softart.dfe.enums.mdfe.version.MdfeVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import com.softart.dfe.util.StringUtils;
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

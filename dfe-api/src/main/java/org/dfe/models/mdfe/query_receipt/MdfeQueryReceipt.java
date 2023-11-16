package org.dfe.models.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import org.dfe.enums.mdfe.version.MdfeVersion;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class MdfeQueryReceipt implements DFObject, XMLAdapter<MdfeQueryReceipt, TConsReciMDFe> {
    private String tpAmb;
    private String nRec;
    @Builder.Default
    private String versao = MdfeVersion.getDefault().getVersion();

    public static MdfeQueryReceipt build(String receipt, MdfeConfig config) {
        return MdfeQueryReceipt.builder().tpAmb(config.environment().getCode()).nRec(receipt).build();
    }
}

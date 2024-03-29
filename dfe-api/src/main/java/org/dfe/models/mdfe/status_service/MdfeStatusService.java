package org.dfe.models.mdfe.status_service;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import org.dfe.enums.mdfe.MdfeEvent;
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
public final class MdfeStatusService implements DFObject, XMLAdapter<MdfeStatusService, TConsStatServ> {

    private String tpAmb;
    @Builder.Default
    private String xServ = MdfeEvent.STATUS_SERVICE.getCode();
    @Builder.Default
    private String versao = MdfeVersion.getDefault().getVersion();

    public static MdfeStatusService build(MdfeConfig config) {
        return MdfeStatusService.builder().tpAmb(config.environment().getCode()).build();
    }

}

package org.dfe.models.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import org.dfe.enums.mdfe.MdfeEvent;
import org.dfe.enums.mdfe.version.MdfeVersion;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeQueryUnclosed implements DFObject, XMLAdapter<MdfeQueryUnclosed, TConsMDFeNaoEnc> {

    private String tpAmb;
    @Builder.Default
    private String xServ = MdfeEvent.QUERY_UNCLOSED.getCode();
    private String cnpj;
    private String cpf;
    @Builder.Default
    private String versao = MdfeVersion.getDefault().getVersion();

    public static MdfeQueryUnclosed build(MdfeConfig config) {
        return MdfeQueryUnclosed.builder()
                .cpf(config.cpf())
                .cnpj(config.cnpj())
                .tpAmb(config.environment().getCode())
                .build();
    }
}

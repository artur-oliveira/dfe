package org.dfe.models.cte.inutilization;

import br.inf.portalfiscal.cte.send.SignatureType;
import br.inf.portalfiscal.cte.send.TInutCTe;
import org.dfe.enums.cte.CteEvent;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.enums.internal.Model;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.XMLStringUtils;
import lombok.*;

import java.time.Year;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteInutilization implements DFObject, XMLAdapter<CteInutilization, TInutCTe> {
    protected InfInut infInut;
    protected SignatureType signature;
    @Builder.Default
    protected String versao = CteVersion.getDefault().getVersion();

    public static CteInutilization build(Number ano, Number serie, Number numberStart, Number numberEnd, String motive, Model model, CteConfig config) {
        return CteInutilization
                .builder()
                .infInut(InfInut
                        .builder()
                        .ano(Short.valueOf(Year.of(ano.intValue()).toString().substring(2)))
                        .serie(Objects.toString(serie))
                        .nctIni(Objects.toString(numberStart))
                        .nctFin(Objects.toString(numberEnd))
                        .tpAmb(config.environment().getCode())
                        .xJust(motive)
                        .cnpj(config.cnpj())
                        .cuf(config.uf().getCode())
                        .mod(model.getCode()).build()).build();
    }

    public static CteInutilization build(Number ano, Number serie, Number numberStart, Number numberEnd, Model model, CteConfig config) {
        return build(ano, serie, numberStart, numberEnd, CteEvent.INUTILIZATION.getDefaultMessage(), model, config);

    }

    public static CteInutilization cte(Number ano, Number serie, Number numberStart, Number numberEnd, String motive, CteConfig config) {
        return build(ano, serie, numberStart, numberEnd, motive, Model.CTE, config);
    }

    public static CteInutilization cte(Number ano, Number serie, Number numberStart, Number numberEnd, CteConfig config) {
        return build(ano, serie, numberStart, numberEnd, Model.CTE, config);
    }

    public static CteInutilization cteOs(Number ano, Number serie, Number numberStart, Number numberEnd, String motive, CteConfig config) {
        return build(ano, serie, numberStart, numberEnd, motive, Model.CTE_OS, config);
    }

    public static CteInutilization cteOs(Number ano, Number serie, Number numberStart, Number numberEnd, CteConfig config) {
        return build(ano, serie, numberStart, numberEnd, Model.CTE_OS, config);
    }


    public static CteInutilization gtve(Number ano, Number serie, Number numberStart, Number numberEnd, String motive, CteConfig config) {
        return build(ano, serie, numberStart, numberEnd, motive, Model.GTVE, config);
    }

    public static CteInutilization gtve(Number ano, Number serie, Number numberStart, Number numberEnd, CteConfig config) {
        return build(ano, serie, numberStart, numberEnd, Model.GTVE, config);
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfInut implements DFObject, XMLAdapter<InfInut, br.inf.portalfiscal.cte.send.InfInut> {
        protected String tpAmb;
        @Builder.Default
        protected String xServ = CteEvent.INUTILIZATION.getCode();
        protected String cuf;
        protected Short ano;
        protected String cnpj;
        protected String mod;
        protected String serie;
        protected String nctIni;
        protected String nctFin;
        @Builder.Default
        protected String xJust = CteEvent.INUTILIZATION.getDefaultMessage();
        protected String id;

        @Override
        public br.inf.portalfiscal.cte.send.InfInut toObject() {
            br.inf.portalfiscal.cte.send.InfInut inut = XMLAdapter.super.toObject();
            inut.setId(XMLStringUtils.idCteInut(getCuf(), getCnpj(), getMod(), getSerie(), getNctIni(), getNctFin()));
            return inut;
        }
    }
}

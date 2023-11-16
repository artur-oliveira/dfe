package org.dfe.models.nf.inut;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.XMLStringUtils;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfeInut implements DFObject, XMLAdapter<NfeInut, TInutNFe> {

    @Builder.Default
    protected String versao = NFVersion.getDefault().getVersion();
    protected InfInut infInut;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfInut implements DFObject, XMLAdapter<InfInut, TInutNFe.InfInut> {
        protected final String xServ = NFEvent.INUTILIZATION.getCode();
        protected String tpAmb;
        protected String cuf;
        protected String ano;
        protected String cnpj;
        protected String mod;
        protected String serie;
        protected String nnfIni;
        protected String nnfFin;
        protected String xJust;
        protected String id;

        @Override
        public TInutNFe.InfInut toObject() {
            TInutNFe.InfInut inut = XMLAdapter.super.toObject();
            inut.setId(XMLStringUtils.idNfeInut(getCuf(), getAno(), getCnpj(), getMod(), getSerie(), getNnfIni(), getNnfFin()));
            return inut;
        }
    }

}

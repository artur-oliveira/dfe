package com.softart.dfe.models.nf.query_register;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TUfConsCad;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.version.NFQueryRegisterVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueryRegister implements DFObject, XMLAdapter<QueryRegister, TConsCad> {

    protected InfCons infCons;
    @Builder.Default
    protected String versao = NFQueryRegisterVersion.getDefault().getVersion();

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfCons implements DFObject, XMLAdapter<InfCons, TConsCad.InfCons> {
        @Builder.Default
        protected String xServ = NFEvent.QUERY_REGISTER.getCode();
        protected TUfConsCad uf;
        protected String ie;
        protected String cnpj;
        protected String cpf;
    }

}

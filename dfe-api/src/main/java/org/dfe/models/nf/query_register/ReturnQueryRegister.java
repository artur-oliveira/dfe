package org.dfe.models.nf.query_register;

import br.inf.portalfiscal.nfe.send.TRetConsCad;
import br.inf.portalfiscal.nfe.send.TUfCons;
import br.inf.portalfiscal.nfe.send.TUfConsCad;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnQueryRegister implements DFObject, XMLAdapter<ReturnQueryRegister, TRetConsCad> {
    protected InfCons infCons;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfCons implements DFObject, XMLAdapter<InfCons, TRetConsCad.InfCons> {
        protected String verAplic;
        protected String cStat;
        protected String xMotivo;
        protected TUfCons uf;
        protected String ie;
        protected String cnpj;
        protected String cpf;
        protected XMLGregorianCalendar dhCons;
        protected String cuf;
        protected List<InfCad> infCad;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TEnderecoConsCad implements DFObject, XMLAdapter<TEnderecoConsCad, br.inf.portalfiscal.nfe.send.TEnderecoConsCad> {
            protected String xLgr;
            protected String nro;
            protected String xCpl;
            protected String xBairro;
            protected String cMun;
            protected String xMun;
            protected String cep;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfCad implements DFObject, XMLAdapter<InfCad, TRetConsCad.InfCons.InfCad> {
            protected String ie;
            protected String cnpj;
            protected String cpf;
            protected TUfConsCad uf;
            protected String cSit;
            protected String indCredNFe;
            protected String indCredCTe;
            protected String xNome;
            protected String xFant;
            protected String xRegApur;
            protected String cnae;
            protected XMLGregorianCalendar dIniAtiv;
            protected XMLGregorianCalendar dUltSit;
            protected XMLGregorianCalendar dBaixa;
            protected String ieUnica;
            protected String ieAtual;
            protected TEnderecoConsCad ender;

        }
    }

}

package org.dfe.models.cte4.reception_gtve;

import br.inf.portalfiscal.cte.send400.TGTVe;
import br.inf.portalfiscal.cte.send400.TUFSemEX;
import br.inf.portalfiscal.cte.send400.TUf;
import org.dfe.components.internal.AccessKeyGenerator;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.enums.cte.identification.CteType;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.enums.internal.cte.QrCodeCteURL;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.DateUtils;
import org.dfe.util.RequireUtils;
import org.dfe.util.StringUtils;
import org.dfe.util.XMLStringUtils;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class Gtve implements DFObject, XMLAdapter<Gtve, TGTVe> {
    private InfCte infCte;
    private InfCTeSupl infCTeSupl;
    @Builder.Default
    private String versao = CteVersion.VERSION_400.getVersion();

    @Override
    @SneakyThrows
    public TGTVe toObject() {
        TGTVe tgtVe = XMLAdapter.super.toObject();
        tgtVe.setInfCTeSupl(
                InfCTeSupl
                        .builder()
                        .qrCodCTe(QrCodeCteURL.generate(this))
                        .build()
                        .toObject()
        );
        return tgtVe;
    }

    public InfCte infCte() {
        return RequireUtils.nonNull(getInfCte(), "infCte() cannot be null");
    }

    public InfCte.Ide ide() {
        return RequireUtils.nonNull(infCte().getIde(), "ide() cannot be null");
    }

    public InfCte.Rem rem() {
        return RequireUtils.nonNull(infCte().getRem(), "rem() cannot be null");
    }

    public InfCte.Dest dest() {
        return RequireUtils.nonNull(infCte().getDest(), "dest() cannot be null");
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public final static class InfCTeSupl implements DFObject, XMLAdapter<InfCTeSupl, TGTVe.InfCTeSupl> {
        private String qrCodCTe;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public final static class InfCte implements DFObject, XMLAdapter<InfCte, TGTVe.InfCte> {
        private Ide ide;
        private Compl compl;
        private Emit emit;
        private Rem rem;
        private Dest dest;
        private TEndeEmi origem;
        private TEndeEmi destino;
        private DetGTV detGTV;
        private List<AutXML> autXML;
        private TRespTec infRespTec;
        @Builder.Default
        private String versao = CteVersion.VERSION_400.getVersion();
        private String id;

        @Override
        public TGTVe.InfCte toObject() {
            Objects.requireNonNull(getIde(), "Cte.InfCte.Ide cannot be null in generation of ID");
            Objects.requireNonNull(getEmit(), "Cte.InfCte.Emit cannot be null in generation of ID");
            if (Objects.isNull(getIde().getCct())) getIde().setCct(StringUtils.random(8));

            getIde().setCdv(
                    AccessKeyGenerator.digit(
                            getIde().getCuf(),
                            getIde().getDhEmi(),
                            getEmit().getCnpj(),
                            getIde().getMod(),
                            getIde().getSerie(),
                            getIde().getNct(),
                            getIde().getTpEmis(),
                            getIde().getCct()
                    )
            );

            TGTVe.InfCte infCte = XMLAdapter.super.toObject();

            if (Objects.isNull(infCte.getId())) {
                setId(XMLStringUtils.idCte(infCte.getIde().getCUF(),
                        DateUtils.twoDigitsyear(infCte.getIde().getDhEmi()),
                        DateUtils.twoDigitsMonth(infCte.getIde().getDhEmi()),
                        getEmit().getCnpj(),
                        infCte.getIde().getMod(),
                        infCte.getIde().getSerie(),
                        infCte.getIde().getNCT(),
                        infCte.getIde().getTpEmis(),
                        infCte.getIde().getCCT(),
                        infCte.getIde().getCDV()
                ));
                infCte.setId(getId());
            }
            return infCte;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Ide implements DFObject, XMLAdapter<Ide, TGTVe.InfCte.Ide> {
            private String cuf;
            @Builder.Default
            private String cct = StringUtils.random(8);
            private String cfop;
            private String natOp;
            private String mod;
            private String serie;
            private String nct;
            @Builder.Default
            private String dhEmi = DateUtils.nowString();
            private String tpImp;
            private String tpEmis;
            private String cdv;
            private String tpAmb;
            private String tpCTe;
            @Builder.Default
            private String verProc = ProjectProperties.displayVersion();
            private String cMunEnv;
            private String xMunEnv;
            private TUf ufEnv;
            private String modal;
            private String tpServ;
            private String indIEToma;
            @Builder.Default
            private String dhSaidaOrig = DateUtils.nowString();
            private String dhChegadaDest;
            private Toma toma;
            private TomaTerceiro tomaTerceiro;
            private String dhCont;
            private String xJust;

            public CteType tpCTe() {
                return RequireUtils.nonNull(CteType.valueOfCode(getTpCTe()), "tpCTe() cannot be null");
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class Toma implements DFObject, XMLAdapter<Toma, TGTVe.InfCte.Ide.Toma> {
                private String toma;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class TomaTerceiro implements DFObject, XMLAdapter<TomaTerceiro, TGTVe.InfCte.Ide.TomaTerceiro> {
                private String toma;
                private String cnpj;
                private String cpf;
                private String ie;
                private String xNome;
                private String xFant;
                private String fone;
                private TEndereco enderToma;
                private String email;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Compl implements DFObject, XMLAdapter<Compl, TGTVe.InfCte.Compl> {
            private String xCaracAd;
            private String xCaracSer;
            private String xEmi;
            private String xObs;
            private List<ObsCont> obsCont;
            private List<ObsFisco> obsFisco;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class ObsCont implements DFObject, XMLAdapter<ObsCont, TGTVe.InfCte.Compl.ObsCont> {
                private String xTexto;
                private String xCampo;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class ObsFisco implements DFObject, XMLAdapter<ObsFisco, TGTVe.InfCte.Compl.ObsFisco> {
                private String xTexto;
                private String xCampo;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Emit implements DFObject, XMLAdapter<Emit, TGTVe.InfCte.Emit> {
            private String cnpj;
            private String cpf;
            private String ie;
            private String iest;
            private String xNome;
            private String xFant;
            private TEndeEmi enderEmit;
            private String crt;

            public TUFSemEX uf() {
                return getEnderEmit().getUf();
            }

        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Rem implements DFObject, XMLAdapter<Rem, TGTVe.InfCte.Rem> {
            private String cnpj;
            private String cpf;
            private String ie;
            private String xNome;
            private String xFant;
            private String fone;
            private TEndereco enderReme;
            private String email;


            public TUf uf() {
                return getEnderReme().getUf();
            }

        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Dest implements DFObject, XMLAdapter<Dest, TGTVe.InfCte.Dest> {
            private String cnpj;
            private String cpf;
            private String ie;
            private String xNome;
            private String fone;
            private String isuf;
            private TEndereco enderDest;
            private String email;


            public TUf uf() {
                return getEnderDest().getUf();
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class TEndeEmi implements DFObject, XMLAdapter<TEndeEmi, br.inf.portalfiscal.cte.send400.TEndeEmi> {
            private String xLgr;
            private String nro;
            private String xCpl;
            private String xBairro;
            private String cMun;
            private String xMun;
            private String cep;
            private TUFSemEX uf;
            private String fone;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class TEndereco implements DFObject, XMLAdapter<TEndereco, br.inf.portalfiscal.cte.send400.TEndereco> {
            private String xLgr;
            private String nro;
            private String xCpl;
            private String xBairro;
            private String cMun;
            private String xMun;
            private String cep;
            private TUf uf;
            private String cPais;
            private String xPais;
        }


        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public final static class DetGTV implements DFObject, XMLAdapter<DetGTV, TGTVe.InfCte.DetGTV> {
            private List<InfEspecie> infEspecie;
            private String qCarga;
            private List<InfVeiculo> infVeiculo;


            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class InfEspecie implements DFObject, XMLAdapter<InfEspecie, TGTVe.InfCte.DetGTV.InfEspecie> {
                private String tpEspecie;
                private String vEspecie;
                private String tpNumerario;
                private String xMoedaEstr;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class InfVeiculo implements DFObject, XMLAdapter<InfVeiculo, TGTVe.InfCte.DetGTV.InfVeiculo> {
                private String placa;
                private TUf uf;
                private String rntrc;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class AutXML implements DFObject, XMLAdapter<AutXML, TGTVe.InfCte.AutXML> {
            private String cnpj;
            private String cpf;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TRespTec implements DFObject, XMLAdapter<TRespTec, br.inf.portalfiscal.cte.send400.TRespTec> {
            protected String cnpj;
            protected String xContato;
            protected String email;
            protected String fone;
            protected String idCSRT;
        }

    }
}

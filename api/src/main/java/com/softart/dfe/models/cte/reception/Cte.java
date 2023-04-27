package com.softart.dfe.models.cte.reception;

import br.inf.portalfiscal.cte.send.TCTe;
import br.inf.portalfiscal.cte.send.TUFSemEX;
import br.inf.portalfiscal.cte.send.TUf;
import com.softart.dfe.components.internal.AccessKeyGenerator;
import com.softart.dfe.components.internal.ProjectProperties;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.enums.cte.identification.*;
import com.softart.dfe.enums.cte.tax.CteICMS;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.enums.general.Country;
import com.softart.dfe.enums.internal.cte.QrCodeCteURL;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.RequireUtils;
import com.softart.dfe.util.StringUtils;
import com.softart.dfe.util.XMLStringUtils;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class Cte implements DFObject, XMLAdapter<Cte, TCTe> {
    private InfCte infCte;
    private InfCTeSupl infCTeSupl;
    @Builder.Default
    private String versao = CteVersion.getDefault().getVersion();

    @Override
    @SneakyThrows
    public TCTe toObject() {
        TCTe tcTe = XMLAdapter.super.toObject();
        tcTe.setInfCTeSupl(
                InfCTeSupl
                        .builder()
                        .qrCodCTe(QrCodeCteURL.generate(this))
                        .build()
                        .toObject()
        );
        return tcTe;
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

    public InfCte.Exped exped() {
        return RequireUtils.nonNull(infCte().getExped(), "exped() cannot be null");
    }

    public InfCte.Receb receb() {
        return RequireUtils.nonNull(infCte().getReceb(), "receb() cannot be null");
    }

    public InfCte.Dest dest() {
        return RequireUtils.nonNull(infCte().getDest(), "dest() cannot be null");
    }

    public InfCte.InfCTeNorm.InfModal infModal() {
        return RequireUtils.nonNull(infCte().getInfCTeNorm().getInfModal(), "infModal() cannot be null");
    }

    public InfCte.Imp imp() {
        return RequireUtils.nonNull(infCte().getImp(), "imp() cannot be null");
    }

    public InfCte.Imp.TImp icms() {
        return RequireUtils.nonNull(infCte().getImp().getIcms(), "icms() cannot be null");
    }

    public CteModal modal() {
        return RequireUtils.nonNull(infModal().modal(), "modal() cannot be null");
    }

    public CteType tpCTe() {
        return RequireUtils.nonNull(ide().tpCTe(), "tpCTe() cannot be null");
    }

    public String vIcms() {
        return icms().vImcs();
    }

    public String vIcmsst() {
        return icms().vIcmsst();
    }

    public CteToma toma() {
        return RequireUtils.nonNull(ide().toma(), "toma() cannot be null");
    }

    public TUf tomaUf() {
        if (Objects.equals(toma(), CteToma.OTHER)) {
            return ide().getToma4().uf();
        }

        switch (toma()) {
            case REMITTER:
                return rem().uf();
            case DISPATCHER:
                return exped().uf();
            case RECEIVER:
                return receb().uf();
            case REMITTEE:
                return dest().uf();
            default:
                throw new IllegalArgumentException("tomaUf() not found");
        }
    }

    public String tomaCnpj() {
        if (Objects.equals(toma(), CteToma.OTHER)) {
            return ide().getToma4().getCnpj();
        }

        switch (toma()) {
            case REMITTER:
                return rem().getCnpj();
            case DISPATCHER:
                return exped().getCnpj();
            case RECEIVER:
                return receb().getCnpj();
            case REMITTEE:
                return dest().getCnpj();
            default:
                throw new IllegalArgumentException("tomaCnpj() not found");
        }
    }

    public String tomaCpf() {
        if (Objects.equals(toma(), CteToma.OTHER)) {
            return ide().getToma4().getCpf();
        }

        switch (toma()) {
            case REMITTER:
                return rem().getCpf();
            case DISPATCHER:
                return exped().getCpf();
            case RECEIVER:
                return receb().getCpf();
            case REMITTEE:
                return dest().getCpf();
            default:
                throw new IllegalArgumentException("getCpf() not found");
        }
    }

    public String tomaIe() {
        if (Objects.equals(toma(), CteToma.OTHER)) {
            return ide().getToma4().getIe();
        }

        switch (toma()) {
            case REMITTER:
                return rem().getIe();
            case DISPATCHER:
                return exped().getIe();
            case RECEIVER:
                return receb().getIe();
            case REMITTEE:
                return dest().getIe();
            default:
                throw new IllegalArgumentException("getIe() not found");
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public final static class InfCTeSupl implements DFObject, XMLAdapter<InfCTeSupl, TCTe.InfCTeSupl> {
        private String qrCodCTe;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public final static class InfCte implements DFObject, XMLAdapter<InfCte, TCTe.InfCte> {
        private Ide ide;
        private Compl compl;
        private Emit emit;
        private Rem rem;
        private Exped exped;
        private Receb receb;
        private Dest dest;
        private VPrest vPrest;
        private Imp imp;
        private InfCTeNorm infCTeNorm;
        private InfCteComp infCteComp;
        private InfCteAnu infCteAnu;
        private List<AutXML> autXML;
        private TRespTec infRespTec;
        private InfSolicNFF infSolicNFF;
        @Builder.Default
        private String versao = CteVersion.getDefault().getVersion();
        private String id;

        @Override
        public TCTe.InfCte toObject() {
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

            TCTe.InfCte infCte = XMLAdapter.super.toObject();

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
        public final static class Ide implements DFObject, XMLAdapter<Ide, TCTe.InfCte.Ide> {
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
            private String procEmi;
            @Builder.Default
            private String verProc = ProjectProperties.displayVersion();
            private String indGlobalizado;
            private String cMunEnv;
            private String xMunEnv;
            private TUf ufEnv;
            private String modal;
            private String tpServ;
            private String cMunIni;
            private String xMunIni;
            private TUf ufIni;
            private String cMunFim;
            private String xMunFim;
            private TUf ufFim;
            private String retira;
            private String xDetRetira;
            private String indIEToma;
            private Toma3 toma3;
            private Toma4 toma4;
            private String dhCont;
            private String xJust;

            public CteType tpCTe() {
                return RequireUtils.nonNull(CteType.valueOfCode(getTpCTe()), "tpCTe() cannot be null");
            }

            public CteToma toma() {
                if (Objects.nonNull(getToma4())) return CteToma.OTHER;
                else return RequireUtils.nonNull(CteToma.valueOfCode(getToma3().getToma()), "toma() cannot be null");
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class Toma3 implements DFObject, XMLAdapter<Toma3, TCTe.InfCte.Ide.Toma3> {
                private String toma;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class Toma4 implements DFObject, XMLAdapter<Toma4, TCTe.InfCte.Ide.Toma4> {
                @Builder.Default
                private String toma = "4";
                private String cnpj;
                private String cpf;
                private String ie;
                private String xNome;
                private String xFant;
                private String fone;
                private TEndereco enderToma;
                private String email;

                public TUf uf() {
                    return getEnderToma().getUf();
                }
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Compl implements DFObject, XMLAdapter<Compl, TCTe.InfCte.Compl> {
            private String xCaracAd;
            private String xCaracSer;
            private String xEmi;
            private Fluxo fluxo;
            private Entrega entrega;
            private String origCalc;
            private String destCalc;
            private String xObs;
            private List<ObsCont> obsCont;
            private List<ObsFisco> obsFisco;


            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class Fluxo implements DFObject, XMLAdapter<Fluxo, TCTe.InfCte.Compl.Fluxo> {
                private String xOrig;
                private List<Pass> pass;
                private String xDest;
                private String xRota;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class Pass implements DFObject, XMLAdapter<Pass, TCTe.InfCte.Compl.Fluxo.Pass> {
                    private String xPass;
                }
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class Entrega implements DFObject, XMLAdapter<Entrega, TCTe.InfCte.Compl.Entrega> {
                private SemData semData;
                private ComData comData;
                private NoPeriodo noPeriodo;
                private SemHora semHora;
                private ComHora comHora;
                private NoInter noInter;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class SemData implements DFObject, XMLAdapter<SemData, TCTe.InfCte.Compl.Entrega.SemData> {
                    @Builder.Default
                    private String tpPer = CteDateDelivery.UNDEFINED.getCode();
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ComData implements DFObject, XMLAdapter<ComData, TCTe.InfCte.Compl.Entrega.ComData> {
                    private String tpPer;
                    private String dProg;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class NoPeriodo implements DFObject, XMLAdapter<NoPeriodo, TCTe.InfCte.Compl.Entrega.NoPeriodo> {
                    @Builder.Default
                    private String tpPer = CteDateDelivery.PERIOD.getCode();
                    private String dIni;
                    private String dFim;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class SemHora implements DFObject, XMLAdapter<SemHora, TCTe.InfCte.Compl.Entrega.SemHora> {
                    @Builder.Default
                    private String tpHor = CteHourDelivery.UNDEFINED.getCode();
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ComHora implements DFObject, XMLAdapter<ComHora, TCTe.InfCte.Compl.Entrega.ComHora> {
                    private String tpHor;
                    private String hProg;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class NoInter implements DFObject, XMLAdapter<NoInter, TCTe.InfCte.Compl.Entrega.NoInter> {
                    @Builder.Default
                    private String tpHor = CteHourDelivery.INTERVAL.getCode();
                    private String hIni;
                    private String hFim;
                }
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class ObsCont implements DFObject, XMLAdapter<ObsCont, TCTe.InfCte.Compl.ObsCont> {
                private String xTexto;
                private String xCampo;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class ObsFisco implements DFObject, XMLAdapter<ObsFisco, TCTe.InfCte.Compl.ObsFisco> {
                private String xTexto;
                private String xCampo;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Emit implements DFObject, XMLAdapter<Emit, TCTe.InfCte.Emit> {
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
        public final static class Rem implements DFObject, XMLAdapter<Rem, TCTe.InfCte.Rem> {
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
        public final static class Exped implements DFObject, XMLAdapter<Exped, TCTe.InfCte.Exped> {
            private String cnpj;
            private String cpf;
            private String ie;
            private String xNome;
            private String fone;
            private TEndereco enderExped;
            private String email;

            public TUf uf() {
                return getEnderExped().getUf();
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Receb implements DFObject, XMLAdapter<Receb, TCTe.InfCte.Receb> {
            private String cnpj;
            private String cpf;
            private String ie;
            private String xNome;
            private String fone;
            private TEndereco enderReceb;
            private String email;

            public TUf uf() {
                return getEnderReceb().getUf();
            }
        }


        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Dest implements DFObject, XMLAdapter<Dest, TCTe.InfCte.Dest> {
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
        public final static class TEndeEmi implements DFObject, XMLAdapter<TEndeEmi, br.inf.portalfiscal.cte.send.TEndeEmi> {
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
        public final static class TEndereco implements DFObject, XMLAdapter<TEndereco, br.inf.portalfiscal.cte.send.TEndereco> {
            private String xLgr;
            private String nro;
            private String xCpl;
            private String xBairro;
            private String cMun;
            private String xMun;
            private String cep;
            private TUf uf;
            @Builder.Default
            private String cPais = Country.BRASIL.getCode();
            @Builder.Default
            private String xPais = Country.BRASIL.getDescription();
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class VPrest implements DFObject, XMLAdapter<VPrest, TCTe.InfCte.VPrest> {
            private String vtPrest;
            private String vRec;
            private List<Comp> comp;


            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class Comp implements DFObject, XMLAdapter<Comp, TCTe.InfCte.VPrest.Comp> {
                private String xNome;
                private String vComp;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Imp implements DFObject, XMLAdapter<Imp, TCTe.InfCte.Imp> {
            private TImp icms;
            private String vTotTrib;
            private String infAdFisco;
            private ICMSUFFim icmsufFim;

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class TImp implements DFObject, XMLAdapter<TImp, br.inf.portalfiscal.cte.send.TImp> {
                private ICMS00 icms00;
                private ICMS20 icms20;
                private ICMS45 icms45;
                private ICMS60 icms60;
                private ICMS90 icms90;
                private ICMSOutraUF icmsOutraUF;
                private ICMSSN icmssn;

                public String vImcs() {
                    BigDecimal icms = BigDecimal.ZERO;

                    if (Objects.nonNull(getIcms00())) icms = icms.add(new BigDecimal(getIcms00().getVicms()));
                    else if (Objects.nonNull(getIcms20())) icms = icms.add(new BigDecimal(getIcms20().getVicms()));
                    else if (Objects.nonNull(getIcms90())) icms = icms.add(new BigDecimal(getIcms90().getVicms()));
                    else if (Objects.nonNull(getIcmsOutraUF()))
                        icms = icms.add(new BigDecimal(getIcmsOutraUF().getVicmsOutraUF()));

                    return icms.setScale(2, RoundingMode.HALF_EVEN).toString();
                }

                public String vIcmsst() {
                    if (Objects.nonNull(getIcms60())) return getIcms60().getVicmsstRet();
                    return StringUtils.zero(2);
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMS00 implements DFObject, XMLAdapter<ICMS00, br.inf.portalfiscal.cte.send.TImp.ICMS00> {
                    @Builder.Default
                    private String cst = CteICMS.NORMAL.getCode();
                    private String vbc;
                    private String picms;
                    private String vicms;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMS20 implements DFObject, XMLAdapter<ICMS20, br.inf.portalfiscal.cte.send.TImp.ICMS20> {
                    @Builder.Default
                    private String cst = CteICMS.REDUCTION.getCode();
                    private String pRedBC;
                    private String vbc;
                    private String picms;
                    private String vicms;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMS45 implements DFObject, XMLAdapter<ICMS45, br.inf.portalfiscal.cte.send.TImp.ICMS45> {
                    private String cst;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMS60 implements DFObject, XMLAdapter<ICMS60, br.inf.portalfiscal.cte.send.TImp.ICMS60> {
                    @Builder.Default
                    private String cst = CteICMS.TRIBUTARY_SUBSTITUTION.getCode();
                    private String vbcstRet;
                    private String vicmsstRet;
                    private String picmsstRet;
                    private String vCred;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMS90 implements DFObject, XMLAdapter<ICMS90, br.inf.portalfiscal.cte.send.TImp.ICMS90> {
                    @Builder.Default
                    private String cst = CteICMS.OTHER.getCode();
                    private String pRedBC;
                    private String vbc;
                    private String picms;
                    private String vicms;
                    private String vCred;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMSOutraUF implements DFObject, XMLAdapter<ICMSOutraUF, br.inf.portalfiscal.cte.send.TImp.ICMSOutraUF> {
                    @Builder.Default
                    private String cst = CteICMS.OTHER_UF.getCode();
                    private String pRedBCOutraUF;
                    private String vbcOutraUF;
                    private String picmsOutraUF;
                    private String vicmsOutraUF;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMSSN implements DFObject, XMLAdapter<ICMSSN, br.inf.portalfiscal.cte.send.TImp.ICMSSN> {
                    @Builder.Default
                    private String cst = CteICMS.SIMPLES.getCode();
                    private String indSN;
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class ICMSUFFim implements DFObject, XMLAdapter<ICMSUFFim, TCTe.InfCte.Imp.ICMSUFFim> {
                private String vbcufFim;
                private String pfcpufFim;
                private String picmsufFim;
                private String picmsInter;
                private String vfcpufFim;
                private String vicmsufFim;
                private String vicmsufIni;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class InfCTeNorm implements DFObject, XMLAdapter<InfCTeNorm, TCTe.InfCte.InfCTeNorm> {
            private InfCarga infCarga;
            private InfDoc infDoc;
            private DocAnt docAnt;
            private InfModal infModal;
            private List<VeicNovos> veicNovos;
            private Cobr cobr;
            private InfCteSub infCteSub;
            private InfGlobalizado infGlobalizado;
            private InfServVinc infServVinc;

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfCarga implements DFObject, XMLAdapter<InfCarga, TCTe.InfCte.InfCTeNorm.InfCarga> {
                private String vCarga;
                private String proPred;
                private String xOutCat;
                private List<InfQ> infQ;
                private String vCargaAverb;

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class InfQ implements DFObject, XMLAdapter<InfQ, TCTe.InfCte.InfCTeNorm.InfCarga.InfQ> {
                    private String cUnid;
                    private String tpMed;
                    private String qCarga;
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfDoc implements DFObject, XMLAdapter<InfDoc, TCTe.InfCte.InfCTeNorm.InfDoc> {
                private List<InfNF> infNF;
                private List<InfNFe> infNFe;
                private List<InfOutros> infOutros;


                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class InfNF implements DFObject, XMLAdapter<InfNF, TCTe.InfCte.InfCTeNorm.InfDoc.InfNF> {
                    private String nRoma;
                    private String nPed;
                    private String mod;
                    private String serie;
                    private String nDoc;
                    private String dEmi;
                    private String vbc;
                    private String vicms;
                    private String vbcst;
                    private String vst;
                    private String vProd;
                    private String vnf;
                    private String ncfop;
                    private String nPeso;
                    private String pin;
                    private String dPrev;
                    private List<br.inf.portalfiscal.cte.send.TUnidCarga> infUnidCarga;
                    private List<br.inf.portalfiscal.cte.send.TUnidadeTransp> infUnidTransp;
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class InfNFe implements DFObject, XMLAdapter<InfNFe, TCTe.InfCte.InfCTeNorm.InfDoc.InfNFe> {
                    private String chave;
                    private String pin;
                    private String dPrev;
                    private List<TUnidCarga> infUnidCarga;
                    private List<TUnidadeTransp> infUnidTransp;
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class InfOutros implements DFObject, XMLAdapter<InfOutros, TCTe.InfCte.InfCTeNorm.InfDoc.InfOutros> {
                    private String tpDoc;
                    private String descOutros;
                    private String nDoc;
                    private String dEmi;
                    private String vDocFisc;
                    private String dPrev;
                    private List<TUnidCarga> infUnidCarga;
                    private List<TUnidadeTransp> infUnidTransp;

                }


                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class TUnidCarga implements DFObject, XMLAdapter<TUnidCarga, br.inf.portalfiscal.cte.send.TUnidCarga> {
                    private String tpUnidCarga;
                    private String idUnidCarga;
                    private List<LacUnidCarga> lacUnidCarga;
                    private String qtdRat;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class LacUnidCarga implements DFObject, XMLAdapter<LacUnidCarga, br.inf.portalfiscal.cte.send.TUnidCarga.LacUnidCarga> {
                        private String nLacre;
                    }
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class TUnidadeTransp implements DFObject, XMLAdapter<TUnidadeTransp, br.inf.portalfiscal.cte.send.TUnidadeTransp> {
                    private String tpUnidTransp;
                    private String idUnidTransp;
                    private List<LacUnidTransp> lacUnidTransp;
                    private List<TUnidCarga> infUnidCarga;
                    private String qtdRat;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class LacUnidTransp implements DFObject, XMLAdapter<LacUnidTransp, br.inf.portalfiscal.cte.send.TUnidadeTransp.LacUnidTransp> {
                        private String nLacre;
                    }
                }

            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class DocAnt implements DFObject, XMLAdapter<DocAnt, TCTe.InfCte.InfCTeNorm.DocAnt> {
                private List<EmiDocAnt> emiDocAnt;

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class EmiDocAnt implements DFObject, XMLAdapter<EmiDocAnt, TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt> {
                    private String cnpj;
                    private String cpf;
                    private String ie;
                    private TUf uf;
                    private String xNome;
                    private List<IdDocAnt> idDocAnt;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class IdDocAnt implements DFObject, XMLAdapter<IdDocAnt, TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt> {
                        private List<IdDocAntPap> idDocAntPap;
                        private List<IdDocAntEle> idDocAntEle;

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class IdDocAntPap implements DFObject, XMLAdapter<IdDocAntPap, TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntPap> {
                            private String tpDoc;
                            private String serie;
                            private String subser;
                            private String nDoc;
                            private String dEmi;
                        }

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class IdDocAntEle implements DFObject, XMLAdapter<IdDocAntEle, TCTe.InfCte.InfCTeNorm.DocAnt.EmiDocAnt.IdDocAnt.IdDocAntEle> {
                            private String chCTe;
                        }

                    }
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfModal implements DFObject, XMLAdapter<InfModal, TCTe.InfCte.InfCTeNorm.InfModal> {
                @Builder.Default
                private String versaoModal = CteVersion.getDefault().getVersion();
                private Rodo rodo;
                private Aereo aereo;
                private Aquav aquav;
                private Duto duto;
                private Ferrov ferrov;
                private Multimodal multimodal;

                @Override
                @SneakyThrows
                public TCTe.InfCte.InfCTeNorm.InfModal toObject() {
                    TCTe.InfCte.InfCTeNorm.InfModal infModal = new TCTe.InfCte.InfCTeNorm.InfModal();
                    infModal.setVersaoModal(getVersaoModal());

                    if (Objects.nonNull(getRodo())) {
                        infModal.setAny(CteUnmarshallerFactory.getInstance().toElement(getRodo().toObject()));
                    } else if (Objects.nonNull(getAereo())) {
                        infModal.setAny(CteUnmarshallerFactory.getInstance().toElement(getAereo().toObject()));
                    } else if (Objects.nonNull(getAquav())) {
                        infModal.setAny(CteUnmarshallerFactory.getInstance().toElement(getAquav().toObject()));
                    } else if (Objects.nonNull(getDuto())) {
                        infModal.setAny(CteUnmarshallerFactory.getInstance().toElement(getDuto().toObject()));
                    } else if (Objects.nonNull(getFerrov())) {
                        infModal.setAny(CteUnmarshallerFactory.getInstance().toElement(getFerrov().toObject()));
                    } else if (Objects.nonNull(getMultimodal())) {
                        infModal.setAny(CteUnmarshallerFactory.getInstance().toElement(getMultimodal().toObject()));
                    }

                    return infModal;
                }

                @Override
                public InfModal fromObject(TCTe.InfCte.InfCTeNorm.InfModal o) {
                    Object el = CteUnmarshallerFactory.getInstance().any(o.getAny()).getValue();

                    if (el instanceof br.inf.portalfiscal.cte.send.Rodo) {
                        setRodo(Rodo.builder().build().fromObject((br.inf.portalfiscal.cte.send.Rodo) el));
                    } else if (el instanceof br.inf.portalfiscal.cte.send.Aereo) {
                        setAereo(Aereo.builder().build().fromObject((br.inf.portalfiscal.cte.send.Aereo) el));
                    } else if (el instanceof br.inf.portalfiscal.cte.send.Aquav) {
                        setAquav(Aquav.builder().build().fromObject((br.inf.portalfiscal.cte.send.Aquav) el));
                    } else if (el instanceof br.inf.portalfiscal.cte.send.Duto) {
                        setDuto(Duto.builder().build().fromObject((br.inf.portalfiscal.cte.send.Duto) el));
                    } else if (el instanceof br.inf.portalfiscal.cte.send.Ferrov) {
                        setFerrov(Ferrov.builder().build().fromObject((br.inf.portalfiscal.cte.send.Ferrov) el));
                    } else if (el instanceof br.inf.portalfiscal.cte.send.Multimodal) {
                        setMultimodal(Multimodal.builder().build().fromObject((br.inf.portalfiscal.cte.send.Multimodal) el));
                    }
                    setVersaoModal(o.getVersaoModal());
                    return this;
                }

                public CteModal modal() {
                    if (Objects.nonNull(getRodo())) {
                        return CteModal.RODOVIARIO;
                    } else if (Objects.nonNull(getAereo())) {
                        return CteModal.AEREO;
                    } else if (Objects.nonNull(getAquav())) {
                        return CteModal.AQUAVIARIO;
                    } else if (Objects.nonNull(getDuto())) {
                        return CteModal.DUTOVIARIO;
                    } else if (Objects.nonNull(getFerrov())) {
                        return CteModal.FERROVIARIO;
                    } else if (Objects.nonNull(getMultimodal())) {
                        return CteModal.MULTIMODAL;
                    }
                    throw new IllegalArgumentException("modal() not found");
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class Rodo implements DFObject, XMLAdapter<Rodo, br.inf.portalfiscal.cte.send.Rodo> {
                    private String rntrc;
                    private List<Occ> occ;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class Occ implements DFObject, XMLAdapter<Occ, br.inf.portalfiscal.cte.send.Occ> {
                        private String serie;
                        private String nOcc;
                        private String dEmi;
                        private EmiOcc emiOcc;

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class EmiOcc implements DFObject, XMLAdapter<EmiOcc, br.inf.portalfiscal.cte.send.EmiOcc> {
                            private String cnpj;
                            private String cInt;
                            private String ie;
                            private TUf uf;
                            private String fone;
                        }
                    }
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class Aereo implements DFObject, XMLAdapter<Aereo, br.inf.portalfiscal.cte.send.Aereo> {
                    private String nMinu;
                    private String noca;
                    private String dPrevAereo;
                    private NatCarga natCarga;
                    private Tarifa tarifa;
                    private List<Peri> peri;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class NatCarga implements DFObject, XMLAdapter<NatCarga, br.inf.portalfiscal.cte.send.NatCarga> {
                        private String xDime;
                        private List<String> cInfManu;
                    }

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class Tarifa implements DFObject, XMLAdapter<Tarifa, br.inf.portalfiscal.cte.send.Tarifa> {
                        private String cl;
                        private String cTar;
                        private String vTar;
                    }

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class Peri implements DFObject, XMLAdapter<Peri, br.inf.portalfiscal.cte.send.Peri> {
                        private String nonu;
                        private String qTotEmb;
                        private InfTotAP infTotAP;

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class InfTotAP implements DFObject, XMLAdapter<InfTotAP, br.inf.portalfiscal.cte.send.InfTotAP> {
                            private String qTotProd;
                            private String uniAP;
                        }
                    }
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class Aquav implements DFObject, XMLAdapter<Aquav, br.inf.portalfiscal.cte.send.Aquav> {
                    private String vPrest;
                    private String vafrmm;
                    private String xNavio;
                    private List<Balsa> balsa;
                    private String nViag;
                    private String direc;
                    private String irin;
                    private List<DetCont> detCont;
                    private String tpNav;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class Balsa implements DFObject, XMLAdapter<Balsa, br.inf.portalfiscal.cte.send.Balsa> {
                        private String xBalsa;
                    }

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class DetCont implements DFObject, XMLAdapter<DetCont, br.inf.portalfiscal.cte.send.DetCont> {
                        private String nCont;
                        private List<Lacre> lacre;
                        private InfDoc infDoc;

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class Lacre implements DFObject, XMLAdapter<Lacre, br.inf.portalfiscal.cte.send.Lacre> {
                            private String nLacre;
                        }
                    }
                }


                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class Duto implements DFObject, XMLAdapter<Duto, br.inf.portalfiscal.cte.send.Duto> {
                    private String vTar;
                    private String dIni;
                    private String dFim;
                }


                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class Ferrov implements DFObject, XMLAdapter<Ferrov, br.inf.portalfiscal.cte.send.Ferrov> {
                    private String tpTraf;
                    private TrafMut trafMut;
                    private String fluxo;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class TrafMut implements DFObject, XMLAdapter<TrafMut, br.inf.portalfiscal.cte.send.TrafMut> {

                        private String respFat;
                        private String ferrEmi;
                        private String vFrete;
                        private String chCTeFerroOrigem;
                        private List<FerroEnv> ferroEnv;

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class FerroEnv implements DFObject, XMLAdapter<FerroEnv, br.inf.portalfiscal.cte.send.FerroEnv> {

                            private String cnpj;
                            private String cInt;
                            private String ie;
                            private String xNome;
                            private TEnderFer enderFerro;

                            @AllArgsConstructor
                            @NoArgsConstructor
                            @Data
                            @Builder
                            public final static class TEnderFer implements DFObject, XMLAdapter<TEnderFer, br.inf.portalfiscal.cte.send.TEnderFer> {
                                private String xLgr;
                                private String nro;
                                private String xCpl;
                                private String xBairro;
                                private String cMun;
                                private String xMun;
                                private String cep;
                                private TUf uf;
                            }
                        }
                    }
                }


                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class Multimodal implements DFObject, XMLAdapter<Multimodal, br.inf.portalfiscal.cte.send.Multimodal> {

                    private String cotm;
                    private String indNegociavel;
                    private Seg seg;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class Seg implements DFObject, XMLAdapter<Seg, br.inf.portalfiscal.cte.send.Seg> {
                        private InfSeg infSeg;
                        private String nApol;
                        private String nAver;

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class InfSeg implements DFObject, XMLAdapter<InfSeg, br.inf.portalfiscal.cte.send.InfSeg> {
                            private String xSeg;
                            private String cnpj;
                        }
                    }
                }

            }


            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class VeicNovos implements DFObject, XMLAdapter<VeicNovos, TCTe.InfCte.InfCTeNorm.VeicNovos> {
                private String chassi;
                private String cCor;
                private String xCor;
                private String cMod;
                private String vUnit;
                private String vFrete;

            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class Cobr implements DFObject, XMLAdapter<Cobr, TCTe.InfCte.InfCTeNorm.Cobr> {
                private Fat fat;
                private List<Dup> dup;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class Fat implements DFObject, XMLAdapter<Fat, TCTe.InfCte.InfCTeNorm.Cobr.Fat> {
                    private String nFat;
                    private String vOrig;
                    private String vDesc;
                    private String vLiq;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class Dup implements DFObject, XMLAdapter<Dup, TCTe.InfCte.InfCTeNorm.Cobr.Dup> {
                    private String nDup;
                    private String dVenc;
                    private String vDup;
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfCteSub implements DFObject, XMLAdapter<InfCteSub, TCTe.InfCte.InfCTeNorm.InfCteSub> {
                private String chCte;
                private String refCteAnu;
                private TomaICMS tomaICMS;
                private String indAlteraToma;


                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class TomaICMS implements DFObject, XMLAdapter<TomaICMS, TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS> {
                    private String refNFe;
                    private RefNF refNF;
                    private String refCte;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class RefNF implements DFObject, XMLAdapter<RefNF, TCTe.InfCte.InfCTeNorm.InfCteSub.TomaICMS.RefNF> {
                        private String cnpj;
                        private String cpf;
                        private String mod;
                        private String serie;
                        private String subserie;
                        private String nro;
                        private String valor;
                        private String dEmi;
                    }
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfGlobalizado implements DFObject, XMLAdapter<InfGlobalizado, TCTe.InfCte.InfCTeNorm.InfGlobalizado> {
                private String xObs;
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfServVinc implements DFObject, XMLAdapter<InfServVinc, TCTe.InfCte.InfCTeNorm.InfServVinc> {
                private List<InfCTeMultimodal> infCTeMultimodal;

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class InfCTeMultimodal implements DFObject, XMLAdapter<InfCTeMultimodal, TCTe.InfCte.InfCTeNorm.InfServVinc.InfCTeMultimodal> {
                    private String chCTeMultimodal;
                }

            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class InfCteComp implements DFObject, XMLAdapter<InfCteComp, TCTe.InfCte.InfCteComp> {
            private String chCTe;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class InfCteAnu implements DFObject, XMLAdapter<InfCteAnu, TCTe.InfCte.InfCteAnu> {
            private String chCte;
            private String dEmi;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class AutXML implements DFObject, XMLAdapter<AutXML, TCTe.InfCte.AutXML> {
            private String cnpj;
            private String cpf;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TRespTec implements DFObject, XMLAdapter<TRespTec, br.inf.portalfiscal.cte.send.TRespTec> {
            protected String cnpj;
            protected String xContato;
            protected String email;
            protected String fone;
            protected String idCSRT;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class InfSolicNFF implements DFObject, XMLAdapter<InfSolicNFF, TCTe.InfCte.InfSolicNFF> {
            private String xSolic;
        }

    }
}

package org.dfe.models.cte.reception_os;

import br.inf.portalfiscal.cte.send.TCTeOS;
import br.inf.portalfiscal.cte.send.TUFSemEX;
import br.inf.portalfiscal.cte.send.TUf;
import org.dfe.components.internal.AccessKeyGenerator;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.enums.cte.identification.CteType;
import org.dfe.enums.cte.tax.CteICMS;
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
public final class CteOs implements DFObject, XMLAdapter<CteOs, TCTeOS> {
    private InfCte infCte;
    private InfCTeSupl infCTeSupl;
    @Builder.Default
    private String versao = CteVersion.getDefault().getVersion();

    @Override
    @SneakyThrows
    public TCTeOS toObject() {
        TCTeOS tcTeOS = XMLAdapter.super.toObject();
        tcTeOS.setInfCTeSupl(
                InfCTeSupl
                        .builder()
                        .qrCodCTe(QrCodeCteURL.generate(this))
                        .build()
                        .toObject()
        );
        return tcTeOS;
    }

    public InfCte infCte() {
        return RequireUtils.nonNull(getInfCte(), "infCte() cannot be null");
    }

    public InfCte.Ide ide() {
        return RequireUtils.nonNull(infCte().getIde(), "ide() cannot be null");
    }

    public InfCte.InfCTeNorm.InfModal infModal() {
        return RequireUtils.nonNull(infCte().getInfCTeNorm().getInfModal(), "infModal() cannot be null");
    }

    public InfCte.Imp imp() {
        return RequireUtils.nonNull(infCte().getImp(), "imp() cannot be null");
    }

    public InfCte.Imp.TImpOS icms() {
        return RequireUtils.nonNull(infCte().getImp().getIcms(), "icms() cannot be null");
    }

    public CteType tpCTe() {
        return RequireUtils.nonNull(ide().tpCTe(), "tpCTe() cannot be null");
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public final static class InfCTeSupl implements DFObject, XMLAdapter<InfCTeSupl, TCTeOS.InfCTeSupl> {
        private String qrCodCTe;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public final static class InfCte implements DFObject, XMLAdapter<InfCte, TCTeOS.InfCte> {
        private Ide ide;
        private Compl compl;
        private Emit emit;
        private Toma toma;
        private VPrest vPrest;
        private Imp imp;
        private InfCTeNorm infCTeNorm;
        private InfCteComp infCteComp;
        private InfCteAnu infCteAnu;
        private List<AutXML> autXML;
        private TRespTec infRespTec;
        @Builder.Default
        private String versao = CteVersion.getDefault().getVersion();
        private String id;

        @Override
        public TCTeOS.InfCte toObject() {
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

            TCTeOS.InfCte infCte = XMLAdapter.super.toObject();

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
        public final static class Ide implements DFObject, XMLAdapter<Ide, TCTeOS.InfCte.Ide> {
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
            private String cMunEnv;
            private String xMunEnv;
            private TUf ufEnv;
            private String modal;
            private String tpServ;
            private String indIEToma;
            private String cMunIni;
            private String xMunIni;
            private TUf ufIni;
            private String cMunFim;
            private String xMunFim;
            private TUf ufFim;
            private List<InfPercurso> infPercurso;
            private String dhCont;
            private String xJust;

            public CteType tpCTe() {
                return RequireUtils.nonNull(CteType.valueOfCode(getTpCTe()), "tpCTe() cannot be null");
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfPercurso implements DFObject, XMLAdapter<InfPercurso, TCTeOS.InfCte.Ide.InfPercurso> {
                private TUf ufPer;
            }

        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Compl implements DFObject, XMLAdapter<Compl, TCTeOS.InfCte.Compl> {
            private String xCaracAd;
            private String xCaracSer;
            private String xEmi;
            private String origCalc;
            private String destCalc;
            private String xObs;
            private List<ObsCont> obsCont;
            private List<ObsFisco> obsFisco;


            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class ObsCont implements DFObject, XMLAdapter<ObsCont, TCTeOS.InfCte.Compl.ObsCont> {
                private String xTexto;
                private String xCampo;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class ObsFisco implements DFObject, XMLAdapter<ObsFisco, TCTeOS.InfCte.Compl.ObsFisco> {
                private String xTexto;
                private String xCampo;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Toma implements DFObject, XMLAdapter<Toma, TCTeOS.InfCte.Toma> {
            private String cnpj;
            private String cpf;
            private String ie;
            private String xNome;
            private String xFant;
            private String fone;
            private TEndereco enderToma;
            private String email;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Emit implements DFObject, XMLAdapter<Emit, TCTeOS.InfCte.Emit> {
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
            private String cPais;
            private String xPais;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class VPrest implements DFObject, XMLAdapter<VPrest, TCTeOS.InfCte.VPrest> {
            private String vtPrest;
            private String vRec;
            private List<Comp> comp;


            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class Comp implements DFObject, XMLAdapter<Comp, TCTeOS.InfCte.VPrest.Comp> {
                private String xNome;
                private String vComp;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class Imp implements DFObject, XMLAdapter<Imp, TCTeOS.InfCte.Imp> {

            private TImpOS icms;
            private String vTotTrib;
            private String infAdFisco;
            private ICMSUFFim icmsufFim;
            private InfTribFed infTribFed;

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class TImpOS implements DFObject, XMLAdapter<TImpOS, br.inf.portalfiscal.cte.send.TImpOS> {
                private ICMS00 icms00;
                private ICMS20 icms20;
                private ICMS45 icms45;
                private ICMS90 icms90;
                private ICMSOutraUF icmsOutraUF;
                private ICMSSN icmssn;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMS00 implements DFObject, XMLAdapter<ICMS00, br.inf.portalfiscal.cte.send.TImpOS.ICMS00> {

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
                public final static class ICMS20 implements DFObject, XMLAdapter<ICMS20, br.inf.portalfiscal.cte.send.TImpOS.ICMS20> {
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
                public final static class ICMS45 implements DFObject, XMLAdapter<ICMS45, br.inf.portalfiscal.cte.send.TImpOS.ICMS45> {
                    private String cst;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class ICMS90 implements DFObject, XMLAdapter<ICMS90, br.inf.portalfiscal.cte.send.TImpOS.ICMS90> {
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
                public final static class ICMSOutraUF implements DFObject, XMLAdapter<ICMSOutraUF, br.inf.portalfiscal.cte.send.TImpOS.ICMSOutraUF> {
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
                public final static class ICMSSN implements DFObject, XMLAdapter<ICMSSN, br.inf.portalfiscal.cte.send.TImpOS.ICMSSN> {
                    @Builder.Default
                    private String cst = CteICMS.SIMPLES.getCode();
                    private String indSN;
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class ICMSUFFim implements DFObject, XMLAdapter<ICMSUFFim, TCTeOS.InfCte.Imp.ICMSUFFim> {
                private String vbcufFim;
                private String pfcpufFim;
                private String picmsufFim;
                private String picmsInter;
                private String vfcpufFim;
                private String vicmsufFim;
                private String vicmsufIni;
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfTribFed implements DFObject, XMLAdapter<InfTribFed, TCTeOS.InfCte.Imp.InfTribFed> {
                private String vpis;
                private String vcofins;
                private String vir;
                private String vinss;
                private String vcsll;
            }
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class InfCTeNorm implements DFObject, XMLAdapter<InfCTeNorm, TCTeOS.InfCte.InfCTeNorm> {
            private InfServico infServico;
            private List<InfDocRef> infDocRef;
            private List<Seg> seg;
            private InfModal infModal;
            private InfCteSub infCteSub;
            private String refCTeCanc;
            private Cobr cobr;
            private List<InfGTVe> infGTVe;


            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class InfDocRef implements DFObject, XMLAdapter<InfDocRef, TCTeOS.InfCte.InfCTeNorm.InfDocRef> {
                private String nDoc;
                private String serie;
                private String subserie;
                private String dEmi;
                private String vDoc;
                private String chBPe;
            }


            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class InfServico implements DFObject, XMLAdapter<InfServico, TCTeOS.InfCte.InfCTeNorm.InfServico> {
                private String xDescServ;
                private InfQ infQ;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class InfQ implements DFObject, XMLAdapter<InfQ, TCTeOS.InfCte.InfCTeNorm.InfServico.InfQ> {
                    private String qCarga;
                }
            }


            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class InfGTVe implements DFObject, XMLAdapter<InfGTVe, TCTeOS.InfCte.InfCTeNorm.InfGTVe> {
                private String chCTe;
                private List<Comp> comp;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class Comp implements DFObject, XMLAdapter<InfGTVe, TCTeOS.InfCte.InfCTeNorm.InfGTVe.Comp> {
                    private String tpComp;
                    private String vComp;
                    private String xComp;
                }
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public final static class Seg implements DFObject, XMLAdapter<Seg, TCTeOS.InfCte.InfCTeNorm.Seg> {
                private String respSeg;
                private String xSeg;
                private String nApol;
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfModal implements DFObject, XMLAdapter<InfModal, TCTeOS.InfCte.InfCTeNorm.InfModal> {
                @Builder.Default
                private String versaoModal = CteVersion.getDefault().getVersion();
                private RodoOS rodoOs;

                @Override
                @SneakyThrows
                public TCTeOS.InfCte.InfCTeNorm.InfModal toObject() {
                    TCTeOS.InfCte.InfCTeNorm.InfModal infModal = new TCTeOS.InfCte.InfCTeNorm.InfModal();
                    infModal.setVersaoModal(getVersaoModal());

                    if (Objects.nonNull(getRodoOs())) {
                        infModal.setAny(CteMarshallerFactory.getInstance().toElement(getRodoOs().toObject()));
                    }

                    return infModal;
                }

                @Override
                public InfModal fromObject(TCTeOS.InfCte.InfCTeNorm.InfModal o) {
                    Object el = CteUnmarshallerFactory.getInstance().any300(o.getAny()).getValue();

                    if (el instanceof br.inf.portalfiscal.cte.send.RodoOS) {
                        setRodoOs(RodoOS.builder().build().fromObject((br.inf.portalfiscal.cte.send.RodoOS) el));
                    }
                    setVersaoModal(o.getVersaoModal());
                    return this;
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class RodoOS implements DFObject, XMLAdapter<RodoOS, br.inf.portalfiscal.cte.send.RodoOS> {
                    private String taf;
                    private String nroRegEstadual;
                    private Veic veic;
                    private InfFretamento infFretamento;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class Veic implements DFObject, XMLAdapter<Veic, br.inf.portalfiscal.cte.send.Veic> {
                        private String placa;
                        private String renavam;
                        private Prop prop;
                        private TUf uf;

                        @AllArgsConstructor
                        @NoArgsConstructor
                        @Data
                        @Builder
                        public final static class Prop implements DFObject, XMLAdapter<Prop, br.inf.portalfiscal.cte.send.Prop> {
                            private String cpf;
                            private String cnpj;
                            private String taf;
                            private String nroRegEstadual;
                            private String xNome;
                            private String ie;
                            private TUf uf;
                            private String tpProp;
                        }

                    }

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class InfFretamento implements DFObject, XMLAdapter<InfFretamento, br.inf.portalfiscal.cte.send.InfFretamento> {
                        private String tpFretamento;
                        private String dhViagem;
                    }
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class Cobr implements DFObject, XMLAdapter<Cobr, TCTeOS.InfCte.InfCTeNorm.Cobr> {
                private Fat fat;
                private List<Dup> dup;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class Fat implements DFObject, XMLAdapter<Fat, TCTeOS.InfCte.InfCTeNorm.Cobr.Fat> {
                    private String nFat;
                    private String vOrig;
                    private String vDesc;
                    private String vLiq;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public final static class Dup implements DFObject, XMLAdapter<Dup, TCTeOS.InfCte.InfCTeNorm.Cobr.Dup> {
                    private String nDup;
                    private String dVenc;
                    private String vDup;
                }
            }

            @AllArgsConstructor
            @NoArgsConstructor
            @Data
            @Builder
            public final static class InfCteSub implements DFObject, XMLAdapter<InfCteSub, TCTeOS.InfCte.InfCTeNorm.InfCteSub> {

                private String chCte;
                private String refCteAnu;
                private TomaICMS tomaICMS;


                @AllArgsConstructor
                @NoArgsConstructor
                @Data
                @Builder
                public final static class TomaICMS implements DFObject, XMLAdapter<TomaICMS, TCTeOS.InfCte.InfCTeNorm.InfCteSub.TomaICMS> {
                    private String refNFe;
                    private RefNF refNF;
                    private String refCte;

                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Data
                    @Builder
                    public final static class RefNF implements DFObject, XMLAdapter<RefNF, TCTeOS.InfCte.InfCTeNorm.InfCteSub.TomaICMS.RefNF> {
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

        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class InfCteComp implements DFObject, XMLAdapter<InfCteComp, TCTeOS.InfCte.InfCteComp> {
            private String chCTe;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class InfCteAnu implements DFObject, XMLAdapter<InfCteAnu, TCTeOS.InfCte.InfCteAnu> {
            private String chCte;
            private String dEmi;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public final static class AutXML implements DFObject, XMLAdapter<AutXML, TCTeOS.InfCte.AutXML> {
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
    }
}

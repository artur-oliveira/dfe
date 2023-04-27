package com.softart.dfe.models.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TUf;
import com.softart.dfe.components.internal.AccessKeyGenerator;
import com.softart.dfe.components.internal.ProjectProperties;
import com.softart.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.mdfe.QrCodeMdfeURL;
import com.softart.dfe.enums.mdfe.identification.MdfeProcessEmissionType;
import com.softart.dfe.enums.mdfe.version.MdfeModalVersion;
import com.softart.dfe.enums.mdfe.version.MdfeVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.StringUtils;
import com.softart.dfe.util.XMLStringUtils;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class Mdfe implements DFObject, XMLAdapter<Mdfe, TMDFe> {
    private InfMDFe infMDFe;
    private InfMDFeSupl infMDFeSupl;

    @Override
    @SneakyThrows
    public TMDFe toObject() {
        TMDFe tmdFe = XMLAdapter.super.toObject();
        tmdFe.setInfMDFeSupl(
                InfMDFeSupl
                        .builder()
                        .qrCodMDFe(QrCodeMdfeURL.generate(this))
                        .build()
                        .toObject()
        );
        return tmdFe;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class InfMDFe implements DFObject, XMLAdapter<InfMDFe, TMDFe.InfMDFe> {
        private Ide ide;
        private Emit emit;
        private InfModal infModal;
        private InfDoc infDoc;
        private List<Seg> seg;
        private ProdPred prodPred;
        private Tot tot;
        private List<Lacres> lacres;
        private List<AutXML> autXML;
        private InfAdic infAdic;
        private TRespTec infRespTec;
        private InfSolicNFF infSolicNFF;
        @Builder.Default
        private String versao = MdfeVersion.getDefault().getVersion();
        private String id;

        @Override
        public TMDFe.InfMDFe toObject() {
            Objects.requireNonNull(getIde(), "MDFe.InfMDFe.Ide cannot be null in generation of ID");
            Objects.requireNonNull(getEmit(), "MDFe.InfMDFe.Emit cannot be null in generation of ID");
            if (Objects.isNull(getIde().getCmdf())) getIde().setCmdf(StringUtils.random(8));

            getIde().setCdv(
                    AccessKeyGenerator.digit(
                            getIde().getCuf(),
                            getIde().getDhEmi(),
                            getEmit().getCnpj(),
                            getIde().getMod(),
                            getIde().getSerie(),
                            getIde().getNmdf(),
                            getIde().getTpEmis(),
                            getIde().getCmdf()
                    )
            );

            TMDFe.InfMDFe infMdfe = XMLAdapter.super.toObject();

            if (Objects.isNull(infMdfe.getId())) {
                setId(XMLStringUtils.idMdfe(infMdfe.getIde().getCUF(),
                        DateUtils.twoDigitsyear(infMdfe.getIde().getDhEmi()),
                        DateUtils.twoDigitsMonth(infMdfe.getIde().getDhEmi()),
                        getEmit().getCnpj(),
                        infMdfe.getIde().getMod(),
                        infMdfe.getIde().getSerie(),
                        infMdfe.getIde().getNMDF(),
                        infMdfe.getIde().getTpEmis(),
                        infMdfe.getIde().getCMDF(),
                        infMdfe.getIde().getCDV()
                ));
                infMdfe.setId(getId());
            }
            return infMdfe;
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class Ide implements DFObject, XMLAdapter<Ide, TMDFe.InfMDFe.Ide> {
            private String cuf;
            private String tpAmb;
            private String tpEmit;
            private String tpTransp;
            @Builder.Default
            private String mod = Model.MDFE.getCode();
            private String serie;
            private String nmdf;
            @Builder.Default
            private String cmdf = StringUtils.random(8);
            private String cdv;
            private String modal;
            @Builder.Default
            private String dhEmi = DateUtils.nowString();
            private String tpEmis;
            @Builder.Default
            private String procEmi = MdfeProcessEmissionType.APPLICATION.getCode();
            @Builder.Default
            private String verProc = ProjectProperties.displayVersion();
            private TUf ufIni;
            private TUf ufFim;
            private List<InfMunCarrega> infMunCarrega;
            private List<InfPercurso> infPercurso;

            @Builder.Default
            private String dhIniViagem = DateUtils.nowString();
            private String indCanalVerde;
            private String indCarregaPosterior;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class InfMunCarrega implements DFObject, XMLAdapter<InfMunCarrega, TMDFe.InfMDFe.Ide.InfMunCarrega> {
                private String cMunCarrega;
                private String xMunCarrega;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class InfPercurso implements DFObject, XMLAdapter<InfPercurso, TMDFe.InfMDFe.Ide.InfPercurso> {
                private TUf ufPer;
            }
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class Emit implements DFObject, XMLAdapter<Emit, TMDFe.InfMDFe.Emit> {
            private String cnpj;
            private String cpf;
            private String ie;
            private String xNome;
            private String xFant;
            private TEndeEmi enderEmit;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class TEndeEmi implements DFObject, XMLAdapter<TEndeEmi, br.inf.portalfiscal.mdfe.classes.TEndeEmi> {
                private String xLgr;
                private String nro;
                private String xCpl;
                private String xBairro;
                private String cMun;
                private String xMun;
                private String cep;
                private TUf uf;
                private String fone;
                private String email;
            }
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class InfModal implements DFObject, XMLAdapter<InfModal, TMDFe.InfMDFe.InfModal> {
            @Builder.Default
            private String versaoModal = MdfeModalVersion.getDefault().getVersion();
            private Aereo aereo;
            private Ferrov ferrov;
            private Rodo rodo;
            private Aquav aquav;

            @Override
            @SneakyThrows
            public TMDFe.InfMDFe.InfModal toObject() {
                TMDFe.InfMDFe.InfModal infModal = new TMDFe.InfMDFe.InfModal();
                if (Objects.nonNull(getRodo())) {
                    infModal.setAny(MdfeUnmarshallerFactory.getInstance().toElement(getRodo().toObject()));
                } else if (Objects.nonNull(getAereo())) {
                    infModal.setAny(MdfeUnmarshallerFactory.getInstance().toElement(getAereo().toObject()));
                } else if (Objects.nonNull(getAquav())) {
                    infModal.setAny(MdfeUnmarshallerFactory.getInstance().toElement(getAquav().toObject()));
                } else if (Objects.nonNull(getFerrov())) {
                    infModal.setAny(MdfeUnmarshallerFactory.getInstance().toElement(getFerrov().toObject()));
                }
                infModal.setVersaoModal(getVersaoModal());
                return infModal;
            }

            @Override
            public InfModal fromObject(TMDFe.InfMDFe.InfModal o) {
                Object el = MdfeUnmarshallerFactory.getInstance().any(o.getAny()).getValue();

                if (el instanceof br.inf.portalfiscal.mdfe.classes.Rodo) {
                    setRodo(Rodo.builder().build().fromObject((br.inf.portalfiscal.mdfe.classes.Rodo) el));
                } else if (el instanceof br.inf.portalfiscal.mdfe.classes.Aereo) {
                    setAereo(Aereo.builder().build().fromObject((br.inf.portalfiscal.mdfe.classes.Aereo) el));
                } else if (el instanceof br.inf.portalfiscal.mdfe.classes.Aquav) {
                    setAquav(Aquav.builder().build().fromObject((br.inf.portalfiscal.mdfe.classes.Aquav) el));
                } else if (el instanceof br.inf.portalfiscal.mdfe.classes.Ferrov) {
                    setFerrov(Ferrov.builder().build().fromObject((br.inf.portalfiscal.mdfe.classes.Ferrov) el));
                }
                setVersaoModal(o.getVersaoModal());
                return this;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class Aereo implements DFObject, XMLAdapter<Aereo, br.inf.portalfiscal.mdfe.classes.Aereo> {
                private String nac;
                private String matr;
                private String nVoo;
                private String cAerEmb;
                private String cAerDes;
                private String dVoo;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class Ferrov implements DFObject, XMLAdapter<Ferrov, br.inf.portalfiscal.mdfe.classes.Ferrov> {
                private Trem trem;
                private List<Vag> vag;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class Trem implements DFObject, XMLAdapter<Trem, br.inf.portalfiscal.mdfe.classes.Ferrov.Trem> {
                    private String xPref;
                    private String dhTrem;
                    private String xOri;
                    private String xDest;
                    private String qVag;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class Vag implements DFObject, XMLAdapter<Vag, br.inf.portalfiscal.mdfe.classes.Ferrov.Vag> {
                    private String pesoBC;
                    private String pesoR;
                    private String tpVag;
                    private String serie;
                    private String nVag;
                    private String nSeq;
                    private String tu;
                }
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class Aquav implements DFObject, XMLAdapter<Aquav, br.inf.portalfiscal.mdfe.classes.Aquav> {
                private String irin;
                private String tpEmb;
                private String cEmbar;
                private String xEmbar;
                private String nViag;
                private String cPrtEmb;
                private String cPrtDest;
                private String prtTrans;
                private String tpNav;
                private List<InfTermCarreg> infTermCarreg;
                private List<InfTermDescarreg> infTermDescarreg;
                private List<InfEmbComb> infEmbComb;
                private List<InfUnidCargaVazia> infUnidCargaVazia;
                private List<InfUnidTranspVazia> infUnidTranspVazia;


                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfTermCarreg implements DFObject, XMLAdapter<InfTermCarreg, br.inf.portalfiscal.mdfe.classes.Aquav.InfTermCarreg> {
                    private String cTermCarreg;
                    private String xTermCarreg;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfTermDescarreg implements DFObject, XMLAdapter<InfTermDescarreg, br.inf.portalfiscal.mdfe.classes.Aquav.InfTermDescarreg> {
                    private String cTermDescarreg;
                    private String xTermDescarreg;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfEmbComb implements DFObject, XMLAdapter<InfEmbComb, br.inf.portalfiscal.mdfe.classes.Aquav.InfEmbComb> {
                    private String cEmbComb;
                    private String xBalsa;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfUnidCargaVazia implements DFObject, XMLAdapter<InfUnidCargaVazia, br.inf.portalfiscal.mdfe.classes.Aquav.InfUnidCargaVazia> {
                    private String idUnidCargaVazia;
                    private String tpUnidCargaVazia;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfUnidTranspVazia implements DFObject, XMLAdapter<InfUnidTranspVazia, br.inf.portalfiscal.mdfe.classes.Aquav.InfUnidTranspVazia> {
                    private String idUnidTranspVazia;
                    private String tpUnidTranspVazia;
                }
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class Rodo implements DFObject, XMLAdapter<Rodo, br.inf.portalfiscal.mdfe.classes.Rodo> {
                private InfANTT infANTT;
                private VeicTracao veicTracao;
                private List<VeicReboque> veicReboque;
                private String codAgPorto;
                private List<LacRodo> lacRodo;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfANTT implements DFObject, XMLAdapter<InfANTT, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT> {
                    private String rntrc;
                    private List<InfCIOT> infCIOT;
                    private ValePed valePed;
                    private List<InfContratante> infContratante;
                    private List<InfPag> infPag;


                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class InfCIOT implements DFObject, XMLAdapter<InfCIOT, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.InfCIOT> {
                        private String ciot;
                        private String cpf;
                        private String cnpj;
                    }

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class ValePed implements DFObject, XMLAdapter<ValePed, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.ValePed> {
                        private List<Disp> disp;
                        private String categCombVeic;

                        @Data
                        @Builder
                        @AllArgsConstructor
                        @NoArgsConstructor
                        public static final class Disp implements DFObject, XMLAdapter<Disp, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.ValePed.Disp> {
                            private String cnpjForn;
                            private String cnpjPg;
                            private String cpfPg;
                            private String nCompra;
                            private String vValePed;
                            private String tpValePed;
                        }

                    }

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class InfContratante implements DFObject, XMLAdapter<InfContratante, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.InfContratante> {
                        private String xNome;
                        private String cpf;
                        private String cnpj;
                        private String idEstrangeiro;
                    }

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class InfPag implements DFObject, XMLAdapter<InfPag, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.InfPag> {
                        private String xNome;
                        private String cpf;
                        private String cnpj;
                        private String idEstrangeiro;
                        private List<Comp> comp;
                        private String vContrato;
                        private String indAltoDesemp;
                        private String indPag;
                        private String vAdiant;
                        private String indAntecipaAdiant;
                        private List<InfPrazo> infPrazo;
                        private String tpAntecip;
                        private InfBanc infBanc;

                        @Data
                        @Builder
                        @AllArgsConstructor
                        @NoArgsConstructor
                        public static final class Comp implements DFObject, XMLAdapter<Comp, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.InfPag.Comp> {
                            private String tpComp;
                            private String vComp;
                            private String xComp;
                        }

                        @Data
                        @Builder
                        @AllArgsConstructor
                        @NoArgsConstructor
                        public static final class InfPrazo implements DFObject, XMLAdapter<InfPrazo, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.InfPag.InfPrazo> {
                            private String nParcela;
                            private String dVenc;
                            private String vParcela;
                        }

                        @Data
                        @Builder
                        @AllArgsConstructor
                        @NoArgsConstructor
                        public static final class InfBanc implements DFObject, XMLAdapter<InfBanc, br.inf.portalfiscal.mdfe.classes.Rodo.InfANTT.InfPag.InfBanc> {
                            private String codBanco;
                            private String codAgencia;
                            private String cnpjipef;
                            private String pix;

                        }
                    }
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class VeicTracao implements DFObject, XMLAdapter<VeicTracao, br.inf.portalfiscal.mdfe.classes.Rodo.VeicTracao> {
                    private String cInt;
                    private String placa;
                    private String renavam;
                    private String tara;
                    private String capKG;
                    private String capM3;
                    private Prop prop;
                    private List<Condutor> condutor;
                    private String tpRod;
                    private String tpCar;
                    private TUf uf;

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class Prop implements DFObject, XMLAdapter<Prop, br.inf.portalfiscal.mdfe.classes.Rodo.VeicTracao.Prop> {
                        private String cpf;
                        private String cnpj;
                        private String rntrc;
                        private String xNome;
                        private String ie;
                        private TUf uf;
                        private String tpProp;
                    }

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class Condutor implements DFObject, XMLAdapter<Condutor, br.inf.portalfiscal.mdfe.classes.Rodo.VeicTracao.Condutor> {
                        private String xNome;
                        private String cpf;
                    }
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class VeicReboque implements DFObject, XMLAdapter<VeicReboque, br.inf.portalfiscal.mdfe.classes.Rodo.VeicReboque> {
                    private String cInt;
                    private String placa;
                    private String renavam;
                    private String tara;
                    private String capKG;
                    private String capM3;
                    private Prop prop;
                    private String tpCar;
                    private TUf uf;

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class Prop implements DFObject, XMLAdapter<Prop, br.inf.portalfiscal.mdfe.classes.Rodo.VeicReboque.Prop> {
                        private String cpf;
                        private String cnpj;
                        private String rntrc;
                        private String xNome;
                        private String ie;
                        private TUf uf;
                        private String tpProp;
                    }
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class LacRodo implements DFObject, XMLAdapter<LacRodo, br.inf.portalfiscal.mdfe.classes.Rodo.LacRodo> {
                    private String nLacre;
                }
            }

        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class InfDoc implements DFObject, XMLAdapter<InfDoc, TMDFe.InfMDFe.InfDoc> {
            private List<InfMunDescarga> infMunDescarga;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class InfMunDescarga implements DFObject, XMLAdapter<InfMunDescarga, TMDFe.InfMDFe.InfDoc.InfMunDescarga> {
                private String cMunDescarga;
                private String xMunDescarga;
                private List<InfCTe> infCTe;
                private List<InfNFe> infNFe;
                private List<InfMDFeTransp> infMDFeTransp;


                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class TUnidCarga implements DFObject, XMLAdapter<TUnidCarga, br.inf.portalfiscal.mdfe.classes.TUnidCarga> {
                    private String tpUnidCarga;
                    private String idUnidCarga;
                    private List<LacUnidCarga> lacUnidCarga;
                    private String qtdRat;

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class LacUnidCarga implements DFObject, XMLAdapter<TUnidCarga, br.inf.portalfiscal.mdfe.classes.TUnidCarga.LacUnidCarga> {
                        private String nLacre;
                    }
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class TUnidadeTransp implements DFObject, XMLAdapter<TUnidadeTransp, br.inf.portalfiscal.mdfe.classes.TUnidadeTransp> {
                    private String tpUnidTransp;
                    private String idUnidTransp;
                    private List<LacUnidTransp> lacUnidTransp;
                    private List<TUnidCarga> infUnidCarga;
                    private String qtdRat;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class LacUnidTransp implements DFObject, XMLAdapter<LacUnidTransp, br.inf.portalfiscal.mdfe.classes.TUnidadeTransp.LacUnidTransp> {
                    private String nLacre;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfCTe implements DFObject, XMLAdapter<InfCTe, TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe> {
                    private String chCTe;
                    private String segCodBarra;
                    private String indReentrega;
                    private List<TUnidadeTransp> infUnidTransp;
                    private List<Peri> peri;
                    private InfEntregaParcial infEntregaParcial;

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class Peri implements DFObject, XMLAdapter<Peri, TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe.Peri> {
                        private String nonu;
                        private String xNomeAE;
                        private String xClaRisco;
                        private String grEmb;
                        private String qTotProd;
                        private String qVolTipo;
                    }

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class InfEntregaParcial implements DFObject, XMLAdapter<InfEntregaParcial, TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfCTe.InfEntregaParcial> {
                        private String qtdTotal;
                        private String qtdParcial;
                    }

                }


                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfNFe implements DFObject, XMLAdapter<InfNFe, TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe> {
                    private String chNFe;
                    private String segCodBarra;
                    private String indReentrega;
                    private List<TUnidadeTransp> infUnidTransp;
                    private List<Peri> peri;

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class Peri implements DFObject, XMLAdapter<InfCTe.Peri, TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfNFe.Peri> {
                        private String nonu;
                        private String xNomeAE;
                        private String xClaRisco;
                        private String grEmb;
                        private String qTotProd;
                        private String qVolTipo;
                    }
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfMDFeTransp implements DFObject, XMLAdapter<InfMDFeTransp, TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp> {
                    private String chMDFe;
                    private String indReentrega;
                    private List<TUnidadeTransp> infUnidTransp;
                    private List<Peri> peri;

                    @Data
                    @Builder
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static final class Peri implements DFObject, XMLAdapter<InfCTe.Peri, TMDFe.InfMDFe.InfDoc.InfMunDescarga.InfMDFeTransp.Peri> {
                        private String nonu;
                        private String xNomeAE;
                        private String xClaRisco;
                        private String grEmb;
                        private String qTotProd;
                        private String qVolTipo;
                    }
                }
            }
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class Seg implements DFObject, XMLAdapter<Seg, TMDFe.InfMDFe.Seg> {
            private InfResp infResp;
            private InfSeg infSeg;
            private String nApol;
            private List<String> nAver;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class InfResp implements DFObject, XMLAdapter<InfResp, TMDFe.InfMDFe.Seg.InfResp> {
                private String respSeg;
                private String cnpj;
                private String cpf;
            }

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class InfSeg implements DFObject, XMLAdapter<InfSeg, TMDFe.InfMDFe.Seg.InfSeg> {
                private String xSeg;
                private String cnpj;
            }
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class ProdPred implements DFObject, XMLAdapter<ProdPred, TMDFe.InfMDFe.ProdPred> {
            private String tpCarga;
            private String xProd;
            private String cean;
            private String ncm;
            private InfLotacao infLotacao;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static final class InfLotacao implements DFObject, XMLAdapter<InfLotacao, TMDFe.InfMDFe.ProdPred.InfLotacao> {
                private InfLocalCarrega infLocalCarrega;
                private InfLocalDescarrega infLocalDescarrega;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfLocalCarrega implements DFObject, XMLAdapter<InfLocalCarrega, TMDFe.InfMDFe.ProdPred.InfLotacao.InfLocalCarrega> {
                    private String cep;
                    private String latitude;
                    private String longitude;
                }

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                public static final class InfLocalDescarrega implements DFObject, XMLAdapter<InfLocalDescarrega, TMDFe.InfMDFe.ProdPred.InfLotacao.InfLocalDescarrega> {
                    private String cep;
                    private String latitude;
                    private String longitude;
                }

            }
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class Tot implements DFObject, XMLAdapter<Tot, TMDFe.InfMDFe.Tot> {
            private String qcTe;
            private String qnFe;
            private String qmdFe;
            private String vCarga;
            private String cUnid;
            private String qCarga;
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class Lacres implements DFObject, XMLAdapter<Lacres, TMDFe.InfMDFe.Lacres> {
            private String nLacre;
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class AutXML implements DFObject, XMLAdapter<AutXML, TMDFe.InfMDFe.AutXML> {
            private String cnpj;
            private String cpf;
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class InfAdic implements DFObject, XMLAdapter<InfAdic, TMDFe.InfMDFe.InfAdic> {
            private String infAdFisco;
            private String infCpl;
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class InfSolicNFF implements DFObject, XMLAdapter<InfSolicNFF, TMDFe.InfMDFe.InfSolicNFF> {
            private String xSolic;
        }

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static final class TRespTec implements DFObject, XMLAdapter<TRespTec, br.inf.portalfiscal.mdfe.classes.TRespTec> {
            private String cnpj;
            private String xContato;
            private String email;
            private String fone;
            private String idCSRT;
            private byte[] hashCSRT;
        }

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class InfMDFeSupl implements DFObject, XMLAdapter<InfMDFeSupl, TMDFe.InfMDFeSupl> {
        private String qrCodMDFe;
    }

}

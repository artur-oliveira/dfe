package com.softart.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.AccessKeyGenerator;
import com.softart.dfe.components.internal.ProjectProperties;
import com.softart.dfe.enums.general.Country;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.enums.nf.version.NFVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.StringUtils;
import com.softart.dfe.util.XMLStringUtils;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Nf implements DFObject, XMLAdapter<Nf, TNFe> {

    protected InfNFe infNFe;
    protected InfNFeSupl infNFeSupl;

    public InfNFe infNFe() {
        return Objects.requireNonNull(getInfNFe(), "getInfNFe() cannot be null");
    }

    public InfNFe.Total total() {
        return Objects.requireNonNull(getInfNFe().getTotal(), "getTotal() cannot be null");
    }

    public InfNFe.Total.ICMSTot icmsTot() {
        return Objects.requireNonNull(total().getIcmsTot(), "getIcmsTot() cannot be null");
    }

    public InfNFe.Ide ide() {
        return Objects.requireNonNull(infNFe().getIde(), "getIde() cannot be null");
    }

    public String id() {
        return Objects.requireNonNull(infNFe().getId(), "getId() cannot be null");
    }

    public String dhEmi() {
        return Objects.requireNonNull(ide().getDhEmi(), "getDhEmi() cannot be null");
    }

    public String VNF() {
        return Objects.requireNonNull(icmsTot().getVnf(), "getVnf() cannot be null");
    }


    public boolean isNfce() {
        return Model.NFCE.getCode().equals(ide().getMod());
    }

    public boolean isOffline() {
        return NFEmissionType.OFFLINE.getCode().equals(ide().getTpEmis());
    }

    public boolean isNfe() {
        return Model.NFE.getCode().equals(ide().getMod());
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfNFeSupl implements DFObject, XMLAdapter<InfNFeSupl, TNFe.InfNFeSupl> {
        protected String qrCode;
        protected String urlChave;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfNFe implements DFObject, XMLAdapter<InfNFe, TNFe.InfNFe> {
        @Builder.Default
        protected String versao = NFVersion.getDefault().getVersion();
        protected Ide ide;
        protected Emit emit;
        protected Avulsa avulsa;
        protected Dest dest;
        protected TLocal retirada;
        protected TLocal entrega;
        protected List<AutXML> autXML;
        protected List<Det> det;
        protected Total total;
        protected Transp transp;
        protected Cobr cobr;
        protected Pag pag;
        protected InfIntermed infIntermed;
        protected InfAdic infAdic;
        protected Exporta exporta;
        protected Compra compra;
        protected Cana cana;
        protected TInfRespTec infRespTec;
        protected InfSolicNFF infSolicNFF;
        protected String id;

        @Override
        public TNFe.InfNFe toObject() {
            Objects.requireNonNull(getIde(), "Nfe.InfNfe.Ide cannot be null in generation of ID");
            Objects.requireNonNull(getEmit(), "Nfe.InfNfe.Emit cannot be null in generation of ID");
            if (Objects.isNull(getIde().getCnf())) getIde().setCnf(StringUtils.random(8));

            getIde().setCdv(
                    AccessKeyGenerator.digit(
                            getIde().getCuf(),
                            getIde().getDhEmi(),
                            getEmit().getCnpj(),
                            getIde().getMod(),
                            getIde().getSerie(),
                            getIde().getNnf(),
                            getIde().getTpEmis(),
                            getIde().getCnf()
                    )
            );

            TNFe.InfNFe infNFe = XMLAdapter.super.toObject();

            if (Objects.isNull(infNFe.getId())) infNFe.setId(XMLStringUtils.idNf(infNFe.getIde().getCUF(),
                    DateUtils.twoDigitsyear(infNFe.getIde().getDhEmi()),
                    DateUtils.twoDigitsMonth(infNFe.getIde().getDhEmi()),
                    getEmit().getCnpj(),
                    infNFe.getIde().getMod(),
                    infNFe.getIde().getSerie(),
                    infNFe.getIde().getNNF(),
                    infNFe.getIde().getTpEmis(),
                    infNFe.getIde().getCNF(),
                    infNFe.getIde().getCDV()
            ));

            infNFe.getDet().forEach(it -> it.setNItem(String.valueOf(infNFe.getDet().indexOf(it) + 1)));

            return infNFe;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Ide implements DFObject, XMLAdapter<Ide, TNFe.InfNFe.Ide> {
            protected String cuf;
            @Builder.Default
            protected String cnf = StringUtils.random(8);
            protected String natOp;
            protected String mod;
            protected String serie;
            protected String nnf;
            protected String dhSaiEnt;
            protected String tpNF;
            protected String idDest;
            protected String cMunFG;
            protected String tpImp;
            protected String tpEmis;
            protected String cdv;
            protected String tpAmb;
            protected String finNFe;
            protected String indFinal;
            protected String indPres;
            protected String indIntermed;
            protected String procEmi;
            @Builder.Default
            protected String verProc = ProjectProperties.displayVersion();
            protected String dhCont;
            protected String xJust;
            protected List<NFref> nFref;
            @Builder.Default
            private String dhEmi = DateUtils.nowString();

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class NFref implements DFObject, XMLAdapter<NFref, TNFe.InfNFe.Ide.NFref> {
                protected String refNFe;
                protected RefNF refNF;
                protected RefNFP refNFP;
                protected String refCTe;
                protected RefECF refECF;


                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class RefNF implements DFObject, XMLAdapter<RefNF, TNFe.InfNFe.Ide.NFref.RefNF> {
                    protected String cuf;
                    protected String aamm;
                    protected String cnpj;
                    protected String mod;
                    protected String serie;
                    protected String nnf;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class RefNFP implements DFObject, XMLAdapter<RefNFP, TNFe.InfNFe.Ide.NFref.RefNFP> {
                    protected String cuf;
                    protected String aamm;
                    protected String cnpj;
                    protected String cpf;
                    protected String ie;
                    protected String mod;
                    protected String serie;
                    protected String nnf;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class RefECF implements DFObject, XMLAdapter<RefECF, TNFe.InfNFe.Ide.NFref.RefECF> {
                    protected String mod;
                    protected String necf;
                    protected String ncoo;
                }
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Emit implements DFObject, XMLAdapter<Emit, TNFe.InfNFe.Emit> {
            protected String cnpj;
            protected String cpf;
            protected String xNome;
            protected String xFant;
            protected EnderEmi enderEmit;
            protected String ie;
            protected String iest;
            protected String im;
            protected String cnae;
            protected String crt;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class EnderEmi implements DFObject, XMLAdapter<EnderEmi, TEnderEmi> {
                protected String xLgr;
                protected String nro;
                protected String xCpl;
                protected String xBairro;
                protected String cMun;
                protected String xMun;
                protected TUfEmi uf;
                protected String cep;
                @Builder.Default
                protected String cPais = Country.BRASIL.getCode();
                @Builder.Default
                protected String xPais = Country.BRASIL.getDescription();
                protected String fone;
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Avulsa implements DFObject, XMLAdapter<Avulsa, TNFe.InfNFe.Avulsa> {
            protected String cnpj;
            protected String xOrgao;
            protected String matr;
            protected String xAgente;
            protected String fone;
            protected TUfEmi uf;
            protected String ndar;
            protected String dEmi;
            protected String vdar;
            protected String repEmi;
            protected String dPag;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Dest implements DFObject, XMLAdapter<Dest, TNFe.InfNFe.Dest> {
            protected String cnpj;
            protected String cpf;
            protected String idEstrangeiro;
            protected String xNome;
            protected Endereco enderDest;
            protected String indIEDest;
            protected String ie;
            protected String isuf;
            protected String im;
            protected String email;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Endereco implements DFObject, XMLAdapter<Endereco, TEndereco> {
                protected String xLgr;
                protected String nro;
                protected String xCpl;
                protected String xBairro;
                protected String cMun;
                protected String xMun;
                protected TUf uf;
                protected String cep;
                protected String cPais;
                protected String xPais;
                protected String fone;
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Local implements DFObject, XMLAdapter<Local, TLocal> {
            protected String cnpj;
            protected String cpf;
            protected String xNome;
            protected String xLgr;
            protected String nro;
            protected String xCpl;
            protected String xBairro;
            protected String cMun;
            protected String xMun;
            protected TUf uf;
            protected String cep;
            protected String cPais;
            protected String xPais;
            protected String fone;
            protected String email;
            protected String ie;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class AutXML implements DFObject, XMLAdapter<AutXML, TNFe.InfNFe.AutXML> {
            protected String cnpj;
            protected String cpf;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Det implements DFObject, XMLAdapter<Det, TNFe.InfNFe.Det> {
            protected Prod prod;
            protected Imposto imposto;
            protected ImpostoDevol impostoDevol;
            protected String infAdProd;
            protected ObsItem obsItem;
            protected String nItem;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Prod implements DFObject, XMLAdapter<Prod, TNFe.InfNFe.Det.Prod> {
                protected String cProd;
                protected String cean;
                protected String cBarra;
                protected String xProd;
                protected String ncm;
                protected List<String> nve;
                protected String cest;
                protected String indEscala;
                protected String cnpjFab;
                protected String cBenef;
                protected String extipi;
                protected String cfop;
                protected String uCom;
                protected String qCom;
                protected String vUnCom;
                protected String vProd;
                protected String ceanTrib;
                protected String cBarraTrib;
                protected String uTrib;
                protected String qTrib;
                protected String vUnTrib;
                protected String vFrete;
                protected String vSeg;
                protected String vDesc;
                protected String vOutro;
                protected String indTot;
                protected List<DI> di;
                protected List<DetExport> detExport;
                protected String xPed;
                protected String nItemPed;
                protected String nfci;
                protected List<Rastro> rastro;
                protected InfProdNFF infProdNFF;
                protected InfProdEmb infProdEmb;
                protected VeicProd veicProd;
                protected Med med;
                protected List<Arma> arma;
                protected Comb comb;
                protected String nrecopi;

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class DI implements DFObject, XMLAdapter<DI, TNFe.InfNFe.Det.Prod.DI> {
                    protected String ndi;
                    protected String ddi;
                    protected String xLocDesemb;
                    protected TUfEmi ufDesemb;
                    protected String dDesemb;
                    protected String tpViaTransp;
                    protected String vafrmm;
                    protected String tpIntermedio;
                    protected String cnpj;
                    protected TUfEmi ufTerceiro;
                    protected String cExportador;
                    protected List<Adi> adi;

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class Adi implements DFObject, XMLAdapter<Adi, TNFe.InfNFe.Det.Prod.DI.Adi> {
                        protected String nAdicao;
                        protected String nSeqAdic;
                        protected String cFabricante;
                        protected String vDescDI;
                        protected String nDraw;
                    }
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class DetExport implements DFObject, XMLAdapter<DetExport, TNFe.InfNFe.Det.Prod.DetExport> {
                    protected String nDraw;
                    protected ExportInd exportInd;

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ExportInd implements DFObject, XMLAdapter<ExportInd, TNFe.InfNFe.Det.Prod.DetExport.ExportInd> {
                        protected String nre;
                        protected String chNFe;
                        protected String qExport;
                    }
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class Rastro implements DFObject, XMLAdapter<Rastro, TNFe.InfNFe.Det.Prod.Rastro> {
                    protected String nLote;
                    protected String qLote;
                    protected String dFab;
                    protected String dVal;
                    protected String cAgreg;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class InfProdNFF implements DFObject, XMLAdapter<InfProdNFF, TNFe.InfNFe.Det.Prod.InfProdNFF> {
                    protected String cProdFisco;
                    protected String cOperNFF;

                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class InfProdEmb implements DFObject, XMLAdapter<InfProdEmb, TNFe.InfNFe.Det.Prod.InfProdEmb> {
                    protected String xEmb;
                    protected String qVolEmb;
                    protected String uEmb;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class VeicProd implements DFObject, XMLAdapter<VeicProd, TNFe.InfNFe.Det.Prod.VeicProd> {
                    protected String tpOp;
                    protected String chassi;
                    protected String cCor;
                    protected String xCor;
                    protected String pot;
                    protected String cilin;
                    protected String pesoL;
                    protected String pesoB;
                    protected String nSerie;
                    protected String tpComb;
                    protected String nMotor;
                    protected String cmt;
                    protected String dist;
                    protected String anoMod;
                    protected String anoFab;
                    protected String tpPint;
                    protected String tpVeic;
                    protected String espVeic;
                    protected String vin;
                    protected String condVeic;
                    protected String cMod;
                    protected String cCorDENATRAN;
                    protected String lota;
                    protected String tpRest;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class Med implements DFObject, XMLAdapter<Med, TNFe.InfNFe.Det.Prod.Med> {
                    protected String cProdANVISA;
                    protected String xMotivoIsencao;
                    protected String vpmc;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class Arma implements DFObject, XMLAdapter<Arma, TNFe.InfNFe.Det.Prod.Arma> {
                    protected String tpArma;
                    protected String nSerie;
                    protected String nCano;
                    protected String descr;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class Comb implements DFObject, XMLAdapter<Comb, TNFe.InfNFe.Det.Prod.Comb> {
                    protected String cProdANP;
                    protected String descANP;
                    protected String pglp;
                    protected String pgNn;
                    protected String pgNi;
                    protected String vPart;
                    protected String codif;
                    protected String qTemp;
                    protected TUf ufCons;
                    protected CIDE cide;
                    protected Encerrante encerrante;

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class CIDE implements DFObject, XMLAdapter<CIDE, TNFe.InfNFe.Det.Prod.Comb.CIDE> {
                        protected String qbcProd;
                        protected String vAliqProd;
                        protected String vcide;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class Encerrante implements DFObject, XMLAdapter<Encerrante, TNFe.InfNFe.Det.Prod.Comb.Encerrante> {
                        protected String nBico;
                        protected String nBomba;
                        protected String nTanque;
                        protected String vEncIni;
                        protected String vEncFin;
                    }
                }
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Imposto implements DFObject, XMLAdapter<Imposto, TNFe.InfNFe.Det.Imposto> {
                protected String vTotTrib;
                protected PISST pisst;
                protected IPI ipi;
                protected II ii;
                protected PIS pis;
                protected COFINS cofins;
                protected ISSQN issqn;
                protected ICMS icms;
                protected COFINSST cofinsst;
                protected ICMSUFDest icmsufDest;

                @Override
                public TNFe.InfNFe.Det.Imposto toObject() {
                    TNFe.InfNFe.Det.Imposto imposto = new TNFe.InfNFe.Det.Imposto();
                    ObjectFactory fc = new ObjectFactory();

                    if (Objects.nonNull(getVTotTrib()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoVTotTrib(getVTotTrib()));
                    if (Objects.nonNull(getIcms()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoICMS(getIcms().toObject()));
                    if (Objects.nonNull(getIcmsufDest()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoICMSUFDest(getIcmsufDest().toObject()));
                    if (Objects.nonNull(getIpi()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoIPI(getIpi().toObject()));
                    if (Objects.nonNull(getIi()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoII(getIi().toObject()));
                    if (Objects.nonNull(getPis()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoPIS(getPis().toObject()));
                    if (Objects.nonNull(getPisst()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoPISST(getPisst().toObject()));
                    if (Objects.nonNull(getCofins()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoCOFINS(getCofins().toObject()));
                    if (Objects.nonNull(getCofinsst()))
                        imposto.getContent().add(fc.createTNFeInfNFeDetImpostoCOFINSST(getCofinsst().toObject()));
                    if (Objects.nonNull(getIssqn()))
                        imposto.getContent().add((fc.createTNFeInfNFeDetImpostoISSQN(getIssqn().toObject())));

                    return imposto;
                }

                @Override
                public Imposto fromObject(TNFe.InfNFe.Det.Imposto fromInstance) {
                    fromInstance.getContent().forEach(content -> {
                        switch (content.getName().getLocalPart().toUpperCase()) {
                            case "VTOTTRIB": {
                                setVTotTrib(Objects.toString(content.getValue()));
                                break;
                            }
                            case "ICMS": {
                                setIcms(new ICMS().fromObject((TNFe.InfNFe.Det.Imposto.ICMS) content.getValue()));
                                break;
                            }
                            case "ICMSUFDEST": {
                                setIcmsufDest(new ICMSUFDest().fromObject((TNFe.InfNFe.Det.Imposto.ICMSUFDest) content.getValue()));
                                break;
                            }
                            case "IPI": {
                                setIpi(new IPI().fromObject((TIpi) content.getValue()));
                                break;
                            }
                            case "II": {
                                setIi(new II().fromObject((TNFe.InfNFe.Det.Imposto.II) content.getValue()));
                                break;
                            }
                            case "PIS": {
                                setPis(new PIS().fromObject((TNFe.InfNFe.Det.Imposto.PIS) content.getValue()));
                                break;
                            }
                            case "PISST": {
                                setPisst(new PISST().fromObject((TNFe.InfNFe.Det.Imposto.PISST) content.getValue()));
                                break;
                            }
                            case "COFINS": {
                                setCofins(new COFINS().fromObject((TNFe.InfNFe.Det.Imposto.COFINS) content.getValue()));
                                break;
                            }
                            case "COFINSST": {
                                setCofinsst(new COFINSST().fromObject((TNFe.InfNFe.Det.Imposto.COFINSST) content.getValue()));
                                break;
                            }
                            case "ISSQN": {
                                setIssqn(new ISSQN().fromObject((TNFe.InfNFe.Det.Imposto.ISSQN) content.getValue()));
                                break;
                            }
                            default:
                                throw new IllegalStateException("Não implementado " + content.getName());
                        }
                    });
                    return this;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class PISST implements DFObject, XMLAdapter<PISST, TNFe.InfNFe.Det.Imposto.PISST> {
                    protected String vbc;
                    protected String ppis;
                    protected String qbcProd;
                    protected String vAliqProd;
                    protected String vpis;
                    protected String indSomaPISST;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class IPI implements DFObject, XMLAdapter<IPI, TIpi> {
                    protected String cnpjProd;
                    protected String cSelo;
                    protected String qSelo;
                    protected String cEnq;
                    protected IPITrib ipiTrib;
                    protected IPINT ipint;

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class IPITrib implements DFObject, XMLAdapter<IPITrib, TIpi.IPITrib> {
                        protected String cst;
                        protected String vbc;
                        protected String pipi;
                        protected String qUnid;
                        protected String vUnid;
                        protected String vipi;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class IPINT implements DFObject, XMLAdapter<IPINT, TIpi.IPINT> {
                        protected String cst;
                    }

                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class II implements DFObject, XMLAdapter<II, TNFe.InfNFe.Det.Imposto.II> {
                    protected String vbc;
                    protected String vDespAdu;
                    protected String vii;
                    protected String viof;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class PIS implements DFObject, XMLAdapter<PIS, TNFe.InfNFe.Det.Imposto.PIS> {
                    protected PISAliq pisAliq;
                    protected PISQtde pisQtde;
                    protected PISNT pisnt;
                    protected PISOutr pisOutr;

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class PISAliq implements DFObject, XMLAdapter<PISAliq, TNFe.InfNFe.Det.Imposto.PIS.PISAliq> {
                        protected String cst;
                        protected String vbc;
                        protected String ppis;
                        protected String vpis;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class PISQtde implements DFObject, XMLAdapter<PISQtde, TNFe.InfNFe.Det.Imposto.PIS.PISQtde> {
                        protected String cst;
                        protected String qbcProd;
                        protected String vAliqProd;
                        protected String vpis;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class PISNT implements DFObject, XMLAdapter<PISNT, TNFe.InfNFe.Det.Imposto.PIS.PISNT> {
                        protected String cst;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class PISOutr implements DFObject, XMLAdapter<PISOutr, TNFe.InfNFe.Det.Imposto.PIS.PISOutr> {
                        protected String cst;
                        protected String vbc;
                        protected String ppis;
                        protected String qbcProd;
                        protected String vAliqProd;
                        protected String vpis;
                    }
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class COFINS implements DFObject, XMLAdapter<COFINS, TNFe.InfNFe.Det.Imposto.COFINS> {
                    protected COFINSAliq cofinsAliq;
                    protected COFINSQtde cofinsQtde;
                    protected COFINSNT cofinsnt;
                    protected COFINSOutr cofinsOutr;

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class COFINSAliq implements DFObject, XMLAdapter<COFINSAliq, TNFe.InfNFe.Det.Imposto.COFINS.COFINSAliq> {
                        protected String cst;
                        protected String vbc;
                        protected String pcofins;
                        protected String vcofins;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class COFINSQtde implements DFObject, XMLAdapter<COFINSQtde, TNFe.InfNFe.Det.Imposto.COFINS.COFINSQtde> {
                        protected String cst;
                        protected String qbcProd;
                        protected String vAliqProd;
                        protected String vcofins;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class COFINSNT implements DFObject, XMLAdapter<COFINSNT, TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT> {
                        protected String cst;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class COFINSOutr implements DFObject, XMLAdapter<COFINSOutr, TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr> {
                        protected String cst;
                        protected String vbc;
                        protected String pcofins;
                        protected String qbcProd;
                        protected String vAliqProd;
                        protected String vcofins;
                    }
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class ISSQN implements DFObject, XMLAdapter<ISSQN, TNFe.InfNFe.Det.Imposto.ISSQN> {
                    protected String vbc;
                    protected String vAliq;
                    protected String vissqn;
                    protected String cMunFG;
                    protected String cListServ;
                    protected String vDeducao;
                    protected String vOutro;
                    protected String vDescIncond;
                    protected String vDescCond;
                    protected String vissRet;
                    protected String indISS;
                    protected String cServico;
                    protected String cMun;
                    protected String cPais;
                    protected String nProcesso;
                    protected String indIncentivo;

                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class ICMS implements DFObject, XMLAdapter<ICMS, TNFe.InfNFe.Det.Imposto.ICMS> {
                    protected ICMS00 icms00;
                    protected ICMS02 icms02;
                    protected ICMS10 icms10;
                    protected ICMS15 icms15;
                    protected ICMS20 icms20;
                    protected ICMS30 icms30;
                    protected ICMS40 icms40;
                    protected ICMS51 icms51;
                    protected ICMS53 icms53;
                    protected ICMS60 icms60;
                    protected ICMS61 icms61;
                    protected ICMS70 icms70;
                    protected ICMS90 icms90;
                    protected ICMSPart icmsPart;
                    protected ICMSST icmsst;
                    protected ICMSSN101 icmssn101;
                    protected ICMSSN102 icmssn102;
                    protected ICMSSN201 icmssn201;
                    protected ICMSSN202 icmssn202;
                    protected ICMSSN500 icmssn500;
                    protected ICMSSN900 icmssn900;

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS00 implements DFObject, XMLAdapter<ICMS00, TNFe.InfNFe.Det.Imposto.ICMS.ICMS00> {
                        protected String orig;
                        protected String cst;
                        protected String modBC;
                        protected String vbc;
                        protected String picms;
                        protected String vicms;
                        protected String pfcp;
                        protected String vfcp;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS02 implements DFObject, XMLAdapter<ICMS02, TNFe.InfNFe.Det.Imposto.ICMS.ICMS02> {
                        protected String orig;
                        protected String cst;
                        protected String qbcMono;
                        protected String adRemICMS;
                        protected String vicmsMono;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS10 implements DFObject, XMLAdapter<ICMS10, TNFe.InfNFe.Det.Imposto.ICMS.ICMS10> {
                        protected String orig;
                        protected String cst;
                        protected String modBC;
                        protected String vbc;
                        protected String picms;
                        protected String vicms;
                        protected String vbcfcp;
                        protected String pfcp;
                        protected String vfcp;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String vbcfcpst;
                        protected String pfcpst;
                        protected String vfcpst;
                        protected String vicmsstDeson;
                        protected String motDesICMSST;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS15 implements DFObject, XMLAdapter<ICMS15, TNFe.InfNFe.Det.Imposto.ICMS.ICMS15> {
                        protected String orig;
                        protected String cst;
                        protected String qbcMono;
                        protected String adRemICMS;
                        protected String vicmsMono;
                        protected String qbcMonoReten;
                        protected String adRemICMSReten;
                        protected String vicmsMonoReten;
                        protected String pRedAdRem;
                        protected String motRedAdRem;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS20 implements DFObject, XMLAdapter<ICMS20, TNFe.InfNFe.Det.Imposto.ICMS.ICMS20> {
                        protected String orig;
                        protected String cst;
                        protected String modBC;
                        protected String pRedBC;
                        protected String vbc;
                        protected String picms;
                        protected String vicms;
                        protected String vbcfcp;
                        protected String pfcp;
                        protected String vfcp;
                        protected String vicmsDeson;
                        protected String motDesICMS;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS30 implements DFObject, XMLAdapter<ICMS30, TNFe.InfNFe.Det.Imposto.ICMS.ICMS30> {
                        protected String orig;
                        protected String cst;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String vbcfcpst;
                        protected String pfcpst;
                        protected String vfcpst;
                        protected String vicmsDeson;
                        protected String motDesICMS;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS40 implements DFObject, XMLAdapter<ICMS40, TNFe.InfNFe.Det.Imposto.ICMS.ICMS40> {
                        protected String orig;
                        protected String cst;
                        protected String vicmsDeson;
                        protected String motDesICMS;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS51 implements DFObject, XMLAdapter<ICMS51, TNFe.InfNFe.Det.Imposto.ICMS.ICMS51> {
                        protected String orig;
                        protected String cst;
                        protected String modBC;
                        protected String pRedBC;
                        protected String vbc;
                        protected String picms;
                        protected String vicmsOp;
                        protected String pDif;
                        protected String vicmsDif;
                        protected String vicms;
                        protected String vbcfcp;
                        protected String pfcp;
                        protected String vfcp;
                        protected String pfcpDif;
                        protected String vfcpDif;
                        protected String vfcpEfet;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS53 implements DFObject, XMLAdapter<ICMS53, TNFe.InfNFe.Det.Imposto.ICMS.ICMS53> {
                        protected String orig;
                        protected String cst;
                        protected String qbcMonoDif;
                        protected String adRemICMSDif;
                        protected String vicmsMonoDif;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS60 implements DFObject, XMLAdapter<ICMS60, TNFe.InfNFe.Det.Imposto.ICMS.ICMS60> {
                        protected String orig;
                        protected String cst;
                        protected String vbcstRet;
                        protected String pst;
                        protected String vicmsSubstituto;
                        protected String vicmsstRet;
                        protected String vbcfcpstRet;
                        protected String pfcpstRet;
                        protected String vfcpstRet;
                        protected String pRedBCEfet;
                        protected String vbcEfet;
                        protected String picmsEfet;
                        protected String vicmsEfet;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS61 implements DFObject, XMLAdapter<ICMS61, TNFe.InfNFe.Det.Imposto.ICMS.ICMS61> {
                        protected String orig;
                        protected String cst;
                        protected String qbcMonoRet;
                        protected String adRemICMSRet;
                        protected String vicmsMonoRet;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS70 implements DFObject, XMLAdapter<ICMS70, TNFe.InfNFe.Det.Imposto.ICMS.ICMS70> {
                        protected String orig;
                        protected String cst;
                        protected String modBC;
                        protected String pRedBC;
                        protected String vbc;
                        protected String picms;
                        protected String vicms;
                        protected String vbcfcp;
                        protected String pfcp;
                        protected String vfcp;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String vbcfcpst;
                        protected String pfcpst;
                        protected String vfcpst;
                        protected String vicmsDeson;
                        protected String motDesICMS;
                        protected String vicmsstDeson;
                        protected String motDesICMSST;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSPart implements DFObject, XMLAdapter<ICMSPart, TNFe.InfNFe.Det.Imposto.ICMS.ICMSPart> {
                        protected String orig;
                        protected String cst;
                        protected String modBC;
                        protected String vbc;
                        protected String pRedBC;
                        protected String picms;
                        protected String vicms;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String pbcOp;
                        protected TUf ufst;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSST implements DFObject, XMLAdapter<ICMSST, TNFe.InfNFe.Det.Imposto.ICMS.ICMSST> {
                        protected String orig;
                        protected String cst;
                        protected String vbcstRet;
                        protected String pst;
                        protected String vicmsSubstituto;
                        protected String vicmsstRet;
                        protected String vbcfcpstRet;
                        protected String pfcpstRet;
                        protected String vfcpstRet;
                        protected String vbcstDest;
                        protected String vicmsstDest;
                        protected String pRedBCEfet;
                        protected String vbcEfet;
                        protected String picmsEfet;
                        protected String vicmsEfet;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMS90 implements DFObject, XMLAdapter<ICMS90, TNFe.InfNFe.Det.Imposto.ICMS.ICMS90> {
                        protected String orig;
                        protected String cst;
                        protected String modBC;
                        protected String vbc;
                        protected String pRedBC;
                        protected String picms;
                        protected String vicms;
                        protected String vbcfcp;
                        protected String pfcp;
                        protected String vfcp;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String vbcfcpst;
                        protected String pfcpst;
                        protected String vfcpst;
                        protected String vicmsDeson;
                        protected String motDesICMS;
                        protected String vicmsstDeson;
                        protected String motDesICMSST;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSSN101 implements DFObject, XMLAdapter<ICMSSN101, TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN101> {
                        protected String orig;
                        protected String csosn;
                        protected String pCredSN;
                        protected String vCredICMSSN;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSSN102 implements DFObject, XMLAdapter<ICMSSN102, TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN102> {
                        protected String orig;
                        protected String csosn;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSSN201 implements DFObject, XMLAdapter<ICMSSN201, TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN201> {
                        protected String orig;
                        protected String csosn;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String vbcfcpst;
                        protected String pfcpst;
                        protected String vfcpst;
                        protected String pCredSN;
                        protected String vCredICMSSN;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSSN202 implements DFObject, XMLAdapter<ICMSSN202, TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN202> {
                        protected String orig;
                        protected String csosn;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String vbcfcpst;
                        protected String pfcpst;
                        protected String vfcpst;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSSN500 implements DFObject, XMLAdapter<ICMSSN500, TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500> {
                        protected String orig;
                        protected String csosn;
                        protected String vbcstRet;
                        protected String pst;
                        protected String vicmsSubstituto;
                        protected String vicmsstRet;
                        protected String vbcfcpstRet;
                        protected String pfcpstRet;
                        protected String vfcpstRet;
                        protected String pRedBCEfet;
                        protected String vbcEfet;
                        protected String picmsEfet;
                        protected String vicmsEfet;
                    }

                    @Getter
                    @Setter
                    @Builder
                    @ToString
                    @AllArgsConstructor
                    @NoArgsConstructor
                    public static class ICMSSN900 implements DFObject, XMLAdapter<ICMSSN900, TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN900> {
                        protected String orig;
                        protected String csosn;
                        protected String modBC;
                        protected String vbc;
                        protected String pRedBC;
                        protected String picms;
                        protected String vicms;
                        protected String modBCST;
                        protected String pmvast;
                        protected String pRedBCST;
                        protected String vbcst;
                        protected String picmsst;
                        protected String vicmsst;
                        protected String vbcfcpst;
                        protected String pfcpst;
                        protected String vfcpst;
                        protected String pCredSN;
                        protected String vCredICMSSN;
                    }
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class COFINSST implements DFObject, XMLAdapter<COFINSST, TNFe.InfNFe.Det.Imposto.COFINSST> {
                    protected String vbc;
                    protected String pcofins;
                    protected String qbcProd;
                    protected String vAliqProd;
                    protected String vcofins;
                    protected String indSomaCOFINSST;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class ICMSUFDest implements DFObject, XMLAdapter<ICMSUFDest, TNFe.InfNFe.Det.Imposto.ICMSUFDest> {
                    protected String vbcufDest;
                    protected String vbcfcpufDest;
                    protected String pfcpufDest;
                    protected String picmsufDest;
                    protected String picmsInter;
                    protected String picmsInterPart;
                    protected String vfcpufDest;
                    protected String vicmsufDest;
                    protected String vicmsufRemet;
                }

            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ImpostoDevol implements DFObject, XMLAdapter<ImpostoDevol, TNFe.InfNFe.Det.ImpostoDevol> {
                protected String pDevol;
                protected IPI ipi;

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class IPI implements DFObject, XMLAdapter<IPI, TNFe.InfNFe.Det.ImpostoDevol.IPI> {
                    protected String vipiDevol;
                }

            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ObsItem implements DFObject, XMLAdapter<ObsItem, TNFe.InfNFe.Det.ObsItem> {
                protected ObsCont obsCont;
                protected ObsFisco obsFisco;

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class ObsCont implements DFObject, XMLAdapter<ObsCont, TNFe.InfNFe.Det.ObsItem.ObsCont> {
                    protected String xTexto;
                    protected String xCampo;
                }

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class ObsFisco implements DFObject, XMLAdapter<ObsFisco, TNFe.InfNFe.Det.ObsItem.ObsFisco> {
                    protected String xTexto;
                    protected String xCampo;
                }
            }

        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Total implements DFObject, XMLAdapter<Total, TNFe.InfNFe.Total> {
            protected ICMSTot icmsTot;
            protected ISSQNtot issqNtot;
            protected RetTrib retTrib;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ICMSTot implements DFObject, XMLAdapter<ICMSTot, TNFe.InfNFe.Total.ICMSTot> {
                protected String vbc;
                protected String vicms;
                protected String vicmsDeson;
                protected String vfcpufDest;
                protected String vicmsufDest;
                protected String vicmsufRemet;
                protected String vfcp;
                protected String vbcst;
                protected String vst;
                protected String vfcpst;
                protected String vfcpstRet;
                protected String vProd;
                protected String vFrete;
                protected String vSeg;
                protected String vDesc;
                protected String vii;
                protected String vipi;
                protected String vipiDevol;
                protected String vpis;
                protected String vcofins;
                protected String vOutro;
                protected String vnf;
                protected String vTotTrib;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ISSQNtot implements DFObject, XMLAdapter<ISSQNtot, TNFe.InfNFe.Total.ISSQNtot> {
                protected String vServ;
                protected String vbc;
                protected String viss;
                protected String vpis;
                protected String vcofins;
                protected String dCompet;
                protected String vDeducao;
                protected String vOutro;
                protected String vDescIncond;
                protected String vDescCond;
                protected String vissRet;
                protected String cRegTrib;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class RetTrib implements DFObject, XMLAdapter<RetTrib, TNFe.InfNFe.Total.RetTrib> {
                protected String vRetPIS;
                protected String vRetCOFINS;
                protected String vRetCSLL;
                protected String vbcirrf;
                protected String virrf;
                protected String vbcRetPrev;
                protected String vRetPrev;
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Transp implements DFObject, XMLAdapter<Transp, TNFe.InfNFe.Transp> {
            protected String modFrete;
            protected Transporta transporta;
            protected RetTransp retTransp;
            protected Veiculo veicTransp;
            protected List<Veiculo> reboque;
            protected String vagao;
            protected String balsa;
            protected List<Vol> vol;


            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Veiculo implements DFObject, XMLAdapter<Veiculo, TVeiculo> {
                protected String placa;
                protected TUf uf;
                protected String rntc;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Transporta implements DFObject, XMLAdapter<Transporta, TNFe.InfNFe.Transp.Transporta> {
                protected String cnpj;
                protected String cpf;
                protected String xNome;
                protected String ie;
                protected String xEnder;
                protected String xMun;
                protected TUf uf;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class RetTransp implements DFObject, XMLAdapter<RetTransp, TNFe.InfNFe.Transp.RetTransp> {
                protected String vServ;
                protected String vbcRet;
                protected String picmsRet;
                protected String vicmsRet;
                protected String cfop;
                protected String cMunFG;
            }


            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Vol implements DFObject, XMLAdapter<Vol, TNFe.InfNFe.Transp.Vol> {
                protected String qVol;
                protected String esp;
                protected String marca;
                protected String nVol;
                protected String pesoL;
                protected String pesoB;
                protected List<Lacres> lacres;

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class Lacres implements DFObject, XMLAdapter<Lacres, TNFe.InfNFe.Transp.Vol.Lacres> {
                    protected String nLacre;
                }
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Cobr implements DFObject, XMLAdapter<Cobr, TNFe.InfNFe.Cobr> {
            protected Fat fat;
            protected List<Dup> dup;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Fat implements DFObject, XMLAdapter<Fat, TNFe.InfNFe.Cobr.Fat> {
                protected String nFat;
                protected String vOrig;
                protected String vDesc;
                protected String vLiq;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Dup implements DFObject, XMLAdapter<Dup, TNFe.InfNFe.Cobr.Dup> {
                protected String nDup;
                protected String dVenc;
                protected String vDup;
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Pag implements DFObject, XMLAdapter<Pag, TNFe.InfNFe.Pag> {
            protected List<DetPag> detPag;
            protected String vTroco;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class DetPag implements DFObject, XMLAdapter<DetPag, TNFe.InfNFe.Pag.DetPag> {
                protected String indPag;
                protected String tPag;
                protected String xPag;
                protected String vPag;
                protected Card card;

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class Card implements DFObject, XMLAdapter<Card, TNFe.InfNFe.Pag.DetPag.Card> {
                    protected String tpIntegra;
                    protected String cnpj;
                    protected String tBand;
                    protected String cAut;
                }
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfIntermed implements DFObject, XMLAdapter<InfIntermed, TNFe.InfNFe.InfIntermed> {
            protected String cnpj;
            protected String idCadIntTran;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfAdic implements DFObject, XMLAdapter<InfAdic, TNFe.InfNFe.InfAdic> {
            protected String infAdFisco;
            protected String infCpl;
            protected List<ObsCont> obsCont;
            protected List<ObsFisco> obsFisco;
            protected List<ProcRef> procRef;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ObsCont implements DFObject, XMLAdapter<ObsCont, TNFe.InfNFe.InfAdic.ObsCont> {
                protected String xTexto;
                protected String xCampo;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ObsFisco implements DFObject, XMLAdapter<ObsFisco, TNFe.InfNFe.InfAdic.ObsFisco> {
                protected String xTexto;
                protected String xCampo;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ProcRef implements DFObject, XMLAdapter<ProcRef, TNFe.InfNFe.InfAdic.ProcRef> {
                protected String nProc;
                protected String indProc;
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Exporta implements DFObject, XMLAdapter<Exporta, TNFe.InfNFe.Exporta> {
            protected TUfEmi ufSaidaPais;
            protected String xLocExporta;
            protected String xLocDespacho;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Compra implements DFObject, XMLAdapter<Compra, TNFe.InfNFe.Compra> {
            protected String xnEmp;
            protected String xPed;
            protected String xCont;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Cana implements DFObject, XMLAdapter<Cana, TNFe.InfNFe.Cana> {
            protected String safra;
            protected String ref;
            protected List<ForDia> forDia;
            protected String qTotMes;
            protected String qTotAnt;
            protected String qTotGer;
            protected List<Deduc> deduc;
            protected String vFor;
            protected String vTotDed;
            protected String vLiqFor;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ForDia implements DFObject, XMLAdapter<ForDia, TNFe.InfNFe.Cana.ForDia> {
                protected String qtde;
                protected String dia;
            }

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Deduc implements DFObject, XMLAdapter<Deduc, TNFe.InfNFe.Cana.Deduc> {
                protected String xDed;
                protected String vDed;
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfSolicNFF implements DFObject, XMLAdapter<InfSolicNFF, TNFe.InfNFe.InfSolicNFF> {
            protected String xSolic;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TInfRespTec implements DFObject, XMLAdapter<TInfRespTec, br.inf.portalfiscal.nfe.send.TInfRespTec> {
            protected String cnpj;
            protected String xContato;
            protected String email;
            protected String fone;
            protected String idCSRT;
        }

    }

}

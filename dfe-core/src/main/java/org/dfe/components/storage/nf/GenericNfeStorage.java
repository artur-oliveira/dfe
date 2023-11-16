package org.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.distribution.*;
import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TProcEvento;
import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TNfeProc;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.enums.internal.nf.NFStorageKey;
import org.dfe.enums.nf.NFReturnCode;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.nf.NfeStorage;
import org.dfe.interfaces.xml.generic.XML;
import org.dfe.models.internal.xml.XMLStore;
import org.dfe.models.nf.distribution.NfeReturnDistribution;
import org.dfe.util.GZIPUtils;

import java.util.Objects;
import java.util.Optional;

public abstract class GenericNfeStorage extends GenericNfCommonStorage implements NfeStorage {

    @Override
    public void storeRetDistribution(Store<TRetDistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                Long maxNsu = Optional.ofNullable(o.data().getMaxNSU()).map(Long::parseLong).orElse(null);
                Long ultNsu = Optional.ofNullable(o.data().getUltNSU()).map(Long::parseLong).orElse(null);

                String xml = "";
                if (Objects.nonNull(maxNsu) && Objects.nonNull(ultNsu)) {
                    xml = ultNsu + "_" + maxNsu;
                }

                getStorageService().writeReturn(o, NFStorageKey.NF_DISTRIBUTION, xmlNameWithTime(xml));

                storeReturnDistributionXml(o.config(), o.data().getLoteDistDFeInt());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private void storeReturnDistributionXml(Config config, LoteDistDFeInt loteDistDFeInt) {
        if (Objects.isNull(loteDistDFeInt) || Objects.isNull(loteDistDFeInt.getDocZip())) return;
        for (DocZip docZip : loteDistDFeInt.getDocZip()) {
            try {
                String xml = GZIPUtils.decompress(docZip.getValue());

                if (docZip.getSchema().toLowerCase().startsWith("resnfe")) {
                    TResNFe val = (TResNFe) NfUnmarshallerFactory.getInstance().anyDistributionNfe(xml).getValue();
                    getStorageService().writeReturn(new Store<>() {
                        @Override
                        public Config config() {
                            return config;
                        }

                        @Override
                        public XML data() {
                            return null;
                        }

                        @Override
                        public String xml() {
                            return xml;
                        }
                    }, NFStorageKey.NF_RES_NFE, xmlNameWithTime(String.join("-", val.getChNFe())));
                } else if (docZip.getSchema().toLowerCase().startsWith("resevento")) {
                    TResEvento val = (TResEvento) NfUnmarshallerFactory.getInstance().anyDistributionNfe(xml).getValue();
                    getStorageService().writeReturn(new Store<>() {
                        @Override
                        public Config config() {
                            return config;
                        }

                        @Override
                        public XML data() {
                            return null;
                        }

                        @Override
                        public String xml() {
                            return xml;
                        }
                    }, NFStorageKey.NF_RES_EVENT, xmlNameWithTime(String.join("-", val.getChNFe(), val.getTpEvento(), val.getNSeqEvento())));
                } else if (docZip.getSchema().toLowerCase().startsWith("procnfe")) {
                    TNfeProc val = (TNfeProc) NfUnmarshallerFactory.getInstance().anySendNfe(xml).getValue();
                    getStorageService().writeProc(new Store<>() {
                        @Override
                        public Config config() {
                            return config;
                        }

                        @Override
                        public XML data() {
                            return null;
                        }

                        @Override
                        public String xml() {
                            return xml;
                        }
                    }, NFStorageKey.NF_AUTHORIZATION, xmlNameWithTime(val.getProtNFe().getInfProt().getChNFe()));
                } else if (docZip.getSchema().toLowerCase().startsWith("procevento")) {
                    TProcEvento tProcEvento = NfUnmarshallerFactory.getInstance().procEventNfe(xml).getValue();
                    getStorageService().writeProc(new Store<>() {
                        @Override
                        public Config config() {
                            return config;
                        }

                        @Override
                        public XML data() {
                            return null;
                        }

                        @Override
                        public String xml() {
                            return xml;
                        }
                    }, NFStorageKey.NF_EVENT, xmlNameWithTime(String.join("-", tProcEvento.getRetEvento().getInfEvento().getChNFe(), tProcEvento.getRetEvento().getInfEvento().getTpEvento(), tProcEvento.getRetEvento().getInfEvento().getNSeqEvento())));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void storeEnvDistribution(Store<TDistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                Long consNSU = Optional.ofNullable(o.data().getConsNSU()).map(it -> Long.parseLong(it.getNSU())).orElse(null);
                String chNFe = Optional.ofNullable(o.data().getConsChNFe()).map(ConsChNFe::getChNFe).orElse(null);
                Long distNSU = Optional.ofNullable(o.data().getDistNSU()).map(it -> Long.parseLong(it.getUltNSU())).orElse(null);
                String xmlName = "";
                if (Objects.nonNull(consNSU)) {
                    xmlName = "ConsNSU_" + consNSU + "_" + System.currentTimeMillis();
                } else if (Objects.nonNull(distNSU)) {
                    xmlName = "DistNSU_" + distNSU + "_" + System.currentTimeMillis();
                } else if (Objects.nonNull(chNFe)) {
                    xmlName = "ConsChNFe_" + chNFe + "_" + System.currentTimeMillis();
                }
                getStorageService().writeSend(o, NFStorageKey.NF_DISTRIBUTION, xmlNameWithTime(xmlName));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcManifestation(Store<br.inf.portalfiscal.nfe.event_manifestation.TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getEvento()) && Objects.nonNull(o.data().getRetEvento()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getRetEvento().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().getInfEvento().getChNFe() + "-" + o.data().getEvento().getInfEvento().getTpEvento() + "-" + o.data().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetManifestation(Store<br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getRetEvento().size(); i++) {
                    getStorageService().writeReturn(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getRetEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getRetEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendManifestation(Store<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && !o.data().getEvento().isEmpty() && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getEvento().size(); i++) {
                    getStorageService().writeSend(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcCorrectionLetter(Store<br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getEvento()) && Objects.nonNull(o.data().getRetEvento()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getRetEvento().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().getInfEvento().getChNFe() + "-" + o.data().getEvento().getInfEvento().getTpEvento() + "-" + o.data().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetCorrectionLetter(Store<TRetEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getRetEvento().size(); i++) {
                    getStorageService().writeReturn(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getRetEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getRetEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendCorrectionLetter(Store<TEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && !o.data().getEvento().isEmpty() && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getEvento().size(); i++) {
                    getStorageService().writeSend(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcEpec(Store<br.inf.portalfiscal.nfe.event_epec.TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getEvento()) && Objects.nonNull(o.data().getRetEvento()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getRetEvento().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().getInfEvento().getChNFe() + "-" + o.data().getEvento().getInfEvento().getTpEvento() + "-" + o.data().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetEpec(Store<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getRetEvento().size(); i++) {
                    getStorageService().writeReturn(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getRetEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getRetEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendEpec(Store<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && !o.data().getEvento().isEmpty() && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getEvento().size(); i++) {
                    getStorageService().writeSend(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeProcInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getEvento()) && Objects.nonNull(o.data().getRetEvento()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getRetEvento().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().getInfEvento().getChNFe() + "-" + o.data().getEvento().getInfEvento().getTpEvento() + "-" + o.data().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeRetInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getRetEvento().size(); i++) {
                    getStorageService().writeReturn(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getRetEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getRetEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && !o.data().getEvento().isEmpty() && Objects.nonNull(o.xml())) {
                for (int i = 0; i < o.data().getEvento().size(); i++) {
                    getStorageService().writeSend(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().get(i).getInfEvento().getChNFe() + "-" + o.data().getEvento().get(i).getInfEvento().getTpEvento()));
                }
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnQueryRegister(Store<TRetConsCad> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfCons())) {
                getStorageService().writeReturn(o.config(), NFStorageKey.NF_QUERY_REGISTER, xmlNameWithTime(""), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendQueryRegister(Store<TConsCad> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getInfCons())) {
                getStorageService().writeReturn(o.config(), NFStorageKey.NF_QUERY_REGISTER, xmlNameWithTime(""), o.xml());
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}

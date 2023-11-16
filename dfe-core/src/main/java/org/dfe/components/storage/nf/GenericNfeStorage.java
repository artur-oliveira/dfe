package org.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import org.dfe.enums.internal.nf.NFStorageKey;
import org.dfe.enums.nf.NFReturnCode;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.nf.NfeStorage;

import java.util.Objects;

public abstract class GenericNfeStorage extends GenericNfCommonStorage implements NfeStorage {

    @Override
    public void storeRetDistribution(Store<TRetDistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeReturn(o, NFStorageKey.NF_DISTRIBUTION, xmlNameWithTime(System.currentTimeMillis()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeEnvDistribution(Store<TDistDFeInt> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.xml())) {
                getStorageService().writeSend(o, NFStorageKey.NF_DISTRIBUTION, xmlNameWithTime(System.currentTimeMillis()));
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

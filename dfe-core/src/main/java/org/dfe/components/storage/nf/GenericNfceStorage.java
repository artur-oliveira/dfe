package org.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import org.dfe.enums.internal.nf.NFStorageKey;
import org.dfe.enums.nf.NFReturnCode;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.nf.NfceStorage;

import java.util.Objects;

public abstract class GenericNfceStorage extends GenericNfCommonStorage implements NfceStorage {
    @Override
    public void storeProcSubstituteCancel(Store<TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.data()) && Objects.nonNull(o.data().getEvento()) && Objects.nonNull(o.data().getRetEvento()) && Objects.nonNull(o.xml()) && NFReturnCode.generateProc(o.data().getRetEvento().getInfEvento().getCStat())) {
                getStorageService().writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.data().getEvento().getInfEvento().getChNFe() + "-" + o.data().getEvento().getInfEvento().getTpEvento() + "-" + o.data().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnSubstituteCancel(Store<TRetEnvEvento> o) throws StorageException {
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
    public void storeSendSubstituteCancel(Store<TEnvEvento> o) throws StorageException {
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
}

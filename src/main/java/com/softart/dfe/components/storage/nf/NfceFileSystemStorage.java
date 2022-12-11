package com.softart.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.enums.internal.nf.NFStorageKey;
import com.softart.dfe.enums.nf.NFReturnCode;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;

import java.util.Objects;

public final class NfceFileSystemStorage extends NfCommonFileSystemStorage implements NfceStorage {
    @Override
    public void storeProcSubstituteCancel(Store<TProcEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getData().getEvento()) && Objects.nonNull(o.getData().getRetEvento()) && Objects.nonNull(o.getXml()) && NFReturnCode.generateProc(o.getData().getRetEvento().getInfEvento().getCStat())) {
                writeProc(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.getData().getEvento().getInfEvento().getChNFe() + "-" + o.getData().getEvento().getInfEvento().getTpEvento() + "-" + o.getData().getEvento().getInfEvento().getNSeqEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeReturnSubstituteCancel(Store<TRetEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && Objects.nonNull(o.getXml())) {
                writeReturn(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.getData().getRetEvento().get(0).getInfEvento().getChNFe() + "-" + o.getData().getRetEvento().get(0).getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public void storeSendSubstituteCancel(Store<TEnvEvento> o) throws StorageException {
        try {
            if (Objects.nonNull(o.getData()) && !o.getData().getEvento().isEmpty() && Objects.nonNull(o.getXml())) {
                writeSend(o, NFStorageKey.NF_EVENT, xmlNameWithTime(o.getData().getEvento().get(0).getInfEvento().getChNFe() + "-" + o.getData().getEvento().get(0).getInfEvento().getTpEvento()));
            }
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }
}

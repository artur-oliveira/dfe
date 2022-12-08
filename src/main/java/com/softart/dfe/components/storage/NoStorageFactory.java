package com.softart.dfe.components.storage;

import com.softart.dfe.components.storage.cte.CteNoStorage;
import com.softart.dfe.components.storage.nf.NfceNoStorage;
import com.softart.dfe.components.storage.nf.NfeNoStorage;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;

final class NoStorageFactory extends StorageFactory {
    @Override
    public NfeStorage getNfeStorage() {
        return new NfeNoStorage();
    }

    @Override
    public NfceStorage getNfceStorage() {
        return new NfceNoStorage();
    }

    @Override
    public CteStorage getCteStorage() {
        return new CteNoStorage();
    }
}

package com.softart.dfe.components.storage;

import com.softart.dfe.components.storage.cte.CteNoStorage;
import com.softart.dfe.components.storage.mdfe.MdfeNoStorage;
import com.softart.dfe.components.storage.nf.NfceNoStorage;
import com.softart.dfe.components.storage.nf.NfeNoStorage;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import com.softart.dfe.interfaces.storage.nf.NfceStorage;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;
import lombok.Getter;

@Getter
final class NoStorageFactory extends StorageFactory {
    private final NfeStorage nfeStorage = new NfeNoStorage();
    private final NfceStorage nfceStorage = new NfceNoStorage();
    private final CteStorage cteStorage = new CteNoStorage();
    private final com.softart.dfe.interfaces.storage.cte4.CteStorage cte4Storage = new com.softart.dfe.components.storage.cte4.CteNoStorage();
    private final MdfeStorage mdfeStorage = new MdfeNoStorage();

}

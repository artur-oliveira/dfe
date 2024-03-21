package org.dfe.components.storage;

import lombok.Getter;
import org.dfe.components.storage.mdfe.MdfeNoStorage;
import org.dfe.components.storage.nf.NfceNoStorage;
import org.dfe.components.storage.nf.NfeNoStorage;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import org.dfe.interfaces.storage.nf.NfceStorage;
import org.dfe.interfaces.storage.nf.NfeStorage;

@Getter
final class NoStorageFactory extends StorageFactory {
    private final NfeStorage nfeStorage = new NfeNoStorage();
    private final NfceStorage nfceStorage = new NfceNoStorage();
    private final org.dfe.interfaces.storage.cte4.CteStorage cte4Storage = new org.dfe.components.storage.cte4.CteNoStorage();
    private final MdfeStorage mdfeStorage = new MdfeNoStorage();

}

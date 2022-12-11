package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TProcEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeEventStorage extends Storage {

    void storeRetEvent(Store<TRetEvento> o) throws StorageException;

    void storeSendEvent(Store<TEvento> o) throws StorageException;

    void storeProcEvent(Store<TProcEvento> o) throws StorageException;

}

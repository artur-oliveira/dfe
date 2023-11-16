package org.dfe.interfaces.storage.nf.common;

import org.dfe.interfaces.storage.nf.NfInutStorage;

public interface NfCommonStorage extends NfInutStorage, NfCancelStorage, NfAuthorizationStorage, NfReturnAuthorizationStorage, NfQueryProtocolStorage, NfQueryGtinStorage, NfQueryStatusServiceStorage {
}

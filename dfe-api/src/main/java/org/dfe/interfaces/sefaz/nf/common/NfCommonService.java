package org.dfe.interfaces.sefaz.nf.common;

import org.dfe.interfaces.internal.allow.NfServiceAllow;

/**
 * This code is defining a Java interface called `NfCommonService` that extends several other interfaces: `NfCancel`,
 * `NfInut`, `NfAuthorization`, `NfReturnAuthorization`, `NfQueryProtocol`, `NfServiceAllow`, and `NfQueryStatusService`.
 * By extending these interfaces, `NfCommonService` inherits their methods and can be used to provide a common set of
 * functionality across different classes that implement this interface.
 */
public interface NfCommonService extends NfCancel, NfInut, NfAuthorization, NfReturnAuthorization, NfQueryProtocol, NfServiceAllow, NfQueryStatusService {
}

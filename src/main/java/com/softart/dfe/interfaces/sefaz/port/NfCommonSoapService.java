package com.softart.dfe.interfaces.sefaz.port;

import com.softart.dfe.interfaces.internal.config.NfConfig;

public interface NfCommonSoapService extends SoapService {
    <T> T prodAuthorization();

    <T> T homAuthorization();

    <T> T prodCancel();

    <T> T homCancel();

    <T> T prodInutilization();

    <T> T homInutilization();

    <T> T prodQueryProtocol();

    <T> T homQueryProtocol();

    <T> T prodQueryStatusService();

    <T> T homQueryStatusService();

    <T> T prodReturnAuthorization();

    <T> T homReturnAuthorization();

    NfConfig getConfig();

}

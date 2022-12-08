package com.softart.dfe.interfaces.sefaz.port;

public interface NfceSoapService extends NfCommonSoapService {
    <T> T prodSubstituteCancel();

    <T> T homSubstituteCancel();
}

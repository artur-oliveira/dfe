package com.softart.dfe.services.nf.query_gtin;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.query_gtin.ReturnQueryGtinNf;

public interface NfQueryGtinService extends NfSefazService {

    ReturnQueryGtinNf queryGtin(String gtin) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}

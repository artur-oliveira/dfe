package com.softart.dfe.services.nf.manifestation;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import com.softart.dfe.models.nf.manifestation.NfeSendManifestation;

public interface NfeManifestationService extends NfSefazService {

    NfeReturnManifestation manifestation(NfeSendManifestation manifestation) throws NoProviderFound, ProcessException, ValidationException, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation confirmation(String accessKey, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation science(String accessKey, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation ignorance(String accessKey, String motive, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation notPerformed(String accessKey, String motive, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation confirmation(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation science(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation ignorance(String accessKey, String motive) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

    NfeReturnManifestation notPerformed(String accessKey, String motive) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException;

}

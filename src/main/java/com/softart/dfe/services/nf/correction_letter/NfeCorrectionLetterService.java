package com.softart.dfe.services.nf.correction_letter;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;

public interface NfeCorrectionLetterService extends NfSefazService {

    ReturnNfeCorrectionLetter correctionLetter(String accessKey, String correction, String nseq) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    ReturnNfeCorrectionLetter correctionLetter(String accessKey, String correction) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}

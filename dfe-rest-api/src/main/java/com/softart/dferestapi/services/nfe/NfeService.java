package com.softart.dferestapi.services.nfe;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import com.softart.dferestapi.models.nfe.cancel.CancelMultipleNfe;
import com.softart.dferestapi.models.nfe.cancel.CancelNfe;
import com.softart.dferestapi.models.nfe.correction_letter.CorrectionMultipleNfe;
import com.softart.dferestapi.models.nfe.correction_letter.CorrectionNfe;
import com.softart.dferestapi.models.nfe.manifestation.ManifestMultipleNfe;
import com.softart.dferestapi.models.nfe.manifestation.ManifestNfe;
import com.softart.dferestapi.services.DfeGenericService;

public interface NfeService extends DfeGenericService {

    NfConfig getConfig();

    ReturnSendNf authorization(SendNf sendNf) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCancel cancel(CancelMultipleNfe cancelMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCancel cancel(CancelNfe withAccessKey) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCorrectionLetter correctionLetter(CorrectionNfe correctionNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCorrectionLetter correctionLetter(CorrectionMultipleNfe correctionMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    NfeReturnManifestation manifestation(ManifestNfe manifestNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    NfeReturnManifestation manifestation(ManifestMultipleNfe manifestMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;


}

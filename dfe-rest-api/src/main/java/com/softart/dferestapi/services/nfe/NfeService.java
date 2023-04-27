package com.softart.dferestapi.services.nfe;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.correction_letter.ReturnNfeCorrectionLetter;
import com.softart.dfe.models.nf.distribution.NfeReturnDistribution;
import com.softart.dfe.models.nf.epec.ReturnNfeEpec;
import com.softart.dfe.models.nf.interested_actor.ReturnNfeInterestedActor;
import com.softart.dfe.models.nf.inut.ReturnNfeInut;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import com.softart.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;
import com.softart.dfe.models.nf.query_register.ReturnQueryRegister;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import com.softart.dferestapi.models.nfe.event.*;
import com.softart.dferestapi.models.nfe.inutilization.Inutilization;
import com.softart.dferestapi.services.DfeGenericService;

public interface NfeService extends DfeGenericService {

    default NfeConfig getConfig() {
        return getDfeConfigurationService().getNfeConfig();
    }

    ReturnSendNf authorization(SendNf o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCancel cancel(CancelMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCancel cancel(CancelNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCorrectionLetter correctionLetter(CorrectionNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCorrectionLetter correctionLetter(CorrectionMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    NfeReturnManifestation manifestation(ManifestNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    NfeReturnManifestation manifestation(ManifestMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeEpec epec(EpecNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeEpec epec(EpecMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeInterestedActor interestedActor(InterestedActorNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeInterestedActor interestedActor(InterestedActorMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    NfeReturnDistribution distribution(Long ultNSU, Long nsu, String chNFe, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryRegister queryRegister(String cnpj, String cpf, String ie, UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryProtocolNfe queryProtocol(String accessKey, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryReceiptNfe queryReceipt(String nrec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryStatusServiceNf queryStatusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeInut inutilization(Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;
}

package com.softart.dferestapi.services.nfce;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.inut.ReturnNfeInut;
import com.softart.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;
import com.softart.dfe.models.nf.query_status_service.ReturnQueryStatusServiceNf;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import com.softart.dfe.models.nf.substitute_cancel.ReturnNfceSubstituteCancel;
import com.softart.dferestapi.models.nfe.event.CancelMultipleNfe;
import com.softart.dferestapi.models.nfe.event.CancelNfe;
import com.softart.dferestapi.models.nfe.event.SubstituteCancelMultipleNfce;
import com.softart.dferestapi.models.nfe.event.SubstituteCancelNfce;
import com.softart.dferestapi.models.nfe.inutilization.Inutilization;
import com.softart.dferestapi.services.DfeGenericService;

public interface NfceService extends DfeGenericService {

    @Override
    default NfceConfig getConfig() {
        return getDfeConfigurationService().getNfceConfig();
    }

    ReturnSendNf authorization(SendNf o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCancel cancel(CancelMultipleNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeCancel cancel(CancelNfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfceSubstituteCancel substituteCancel(SubstituteCancelNfce o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfceSubstituteCancel substituteCancel(SubstituteCancelMultipleNfce o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryProtocolNfe queryProtocol(String accessKey, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryReceiptNfe queryReceipt(String nRec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryStatusServiceNf queryStatusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnNfeInut inutilization(Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;
}

package com.softart.dferestapi.services.mdfe;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeCompression;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeSolicitation;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.models.mdfe.distribution.MdfeReturnDistribution;
import com.softart.dfe.models.mdfe.event.MdfeReturnEvent;
import com.softart.dfe.models.mdfe.query_receipt.MdfeReturnQueryReceipt;
import com.softart.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;
import com.softart.dfe.models.mdfe.query_unclosed.MdfeReturnQueryUnclosed;
import com.softart.dfe.models.mdfe.reception.SendMdfe;
import com.softart.dfe.models.mdfe.reception.SendMdfeReturn;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import com.softart.dfe.models.mdfe.reception_sync.MdfeReturn;
import com.softart.dfe.models.mdfe.status_service.MdfeReturnStatusService;
import com.softart.dferestapi.models.mdfe.event.*;
import com.softart.dferestapi.services.DfeGenericService;

public interface MdfeService extends DfeGenericService {
    @Override
    default MdfeConfig getConfig() {
        return getDfeConfigurationService().getMdfeConfig();
    }

    MdfeReturnStatusService statusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnQueryUnclosed unclosed(Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnQuerySituation querySituation(String chMDFe, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnQueryReceipt queryReceipt(String nRec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    SendMdfeReturn reception(SendMdfe sendMdfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturn receptionSync(Mdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnDistribution distribution(Long ultNSU, MdfeDfeSolicitation solicitation, MdfeDfeCompression compression, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnEvent cancel(CancelMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnEvent close(CloseMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnEvent dfeInclusion(DfeInclusionMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnEvent driverInclusion(DriverInclusionMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnEvent paymentModification(PaymentModificationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnEvent paymentOperation(PaymentOperationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    MdfeReturnEvent transportConfirmation(TransportConfirmationMdfe o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;
}

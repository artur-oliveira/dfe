package com.softart.dferestapi.services.cte;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.models.cte.distribution.CteReturnDistribution;
import com.softart.dfe.models.cte.event.CteReturnEvent;
import com.softart.dfe.models.cte.inutilization.CteReturnInutilization;
import com.softart.dfe.models.cte.query_receipt.ReturnQueryReceipt;
import com.softart.dfe.models.cte.query_situation.CteReturnQuerySituation;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception.CteReturnSend;
import com.softart.dfe.models.cte.reception.CteSend;
import com.softart.dfe.models.cte.reception_gtve.Gtve;
import com.softart.dfe.models.cte.reception_gtve.GtveReturn;
import com.softart.dfe.models.cte.reception_os.CteOs;
import com.softart.dfe.models.cte.reception_os.CteOsReturn;
import com.softart.dfe.models.cte.reception_sync.CteReturn;
import com.softart.dfe.models.cte.status_service.CteReturnStatusService;
import com.softart.dferestapi.models.cte.event.*;
import com.softart.dferestapi.models.cte.inutilization.Inutilization;
import com.softart.dferestapi.services.DfeGenericService;

public interface CteService extends DfeGenericService {
    @Override
    default CteConfig getConfig() {
        return getDfeConfigurationService().getCteConfig();
    }

    CteReturnStatusService statusService(UF uf, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnQuerySituation querySituation(String chCTe, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    ReturnQueryReceipt queryReceipt(String nRec, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnSend reception(CteSend o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturn receptionSync(Cte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnEvent cancel(CancelCte o) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException;

    CteReturnInutilization inutilization(Inutilization o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnEvent correctionLetter(CorrectionLetterCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnEvent deliveryReceipt(DeliveryReceiptCte o) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException;

    CteReturnEvent cancelDeliveryReceipt(CancelDeliveryReceiptCte o) throws ProcessException, SoapServiceGeneralException, ValidationException, NoProviderFound, SecurityException;

    CteReturnEvent epec(EpecCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnEvent gtv(GtvCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnEvent provisionDisagreement(ProvisionDisagreementCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteReturnEvent multimodal(MultimodalCte o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    CteOsReturn receptionOs(CteOs o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;

    GtveReturn receptionGtve(Gtve o) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;
    CteReturnDistribution distribution(Long ultNSU, Long nsu, Environment environment) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException;
}

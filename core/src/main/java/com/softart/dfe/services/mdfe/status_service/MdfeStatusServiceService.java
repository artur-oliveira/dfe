package com.softart.dfe.services.mdfe.status_service;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.status_service.MdfeReturnStatusService;
import com.softart.dfe.models.mdfe.status_service.MdfeStatusService;
import com.softart.dfe.models.mdfe.status_service.MdfeStatusServiceRequest;

public interface MdfeStatusServiceService extends MdfeSefazService {

    /**
     * It creates a MdfeReturnStatusService object from the response of the statusService function of the MdfeService
     * object
     *
     * @param tConsStatServ The object that contains the parameters for the status service.
     * @return A MdfeReturnStatusService object.
     */
    default MdfeReturnStatusService statusService(TConsStatServ tConsStatServ) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return MdfeReturnStatusService
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(getConfig())
                        .statusService(MdfeStatusServiceRequest
                                .builder()
                                .data(tConsStatServ)
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .validators(getValidatorFactory().mdfeValidator().statusServiceValidators())
                                .afterRequest(getProcess().afterStatusService())
                                .beforeRequest(getProcess().beforeStatusService())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }

    /**
     * It returns the status of the MDF-e service
     *
     * @param statusService The status service object.
     * @return The status of the MDF-e  service.
     */
    default MdfeReturnStatusService statusService(MdfeStatusService statusService) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return statusService(statusService.toObject());
    }

    /**
     * It returns the status of the MDF-e service
     *
     * @return The status of the MDF-e  service.
     */
    default MdfeReturnStatusService statusService() throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return statusService(MdfeStatusService.build(getConfig()));
    }

}

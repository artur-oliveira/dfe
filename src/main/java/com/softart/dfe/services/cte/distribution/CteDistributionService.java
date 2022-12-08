package com.softart.dfe.services.cte.distribution;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.distribution.CteDistribution;
import com.softart.dfe.models.cte.distribution.CteReturnDistribution;

public interface CteDistributionService extends CteSefazService {

    CteReturnDistribution distribution(CteDistribution cteDistribution) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CteReturnDistribution distributionUniqueNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    CteReturnDistribution distributionUltNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}

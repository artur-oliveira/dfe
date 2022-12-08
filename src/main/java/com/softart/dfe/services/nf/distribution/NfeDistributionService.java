package com.softart.dfe.services.nf.distribution;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.distribution.NfeDistribution;
import com.softart.dfe.models.nf.distribution.NfeReturnDistribution;

public interface NfeDistributionService extends NfSefazService {

    NfeReturnDistribution distribution(NfeDistribution nfeDistribution) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    NfeReturnDistribution distributionUniqueNsu(Long nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    NfeReturnDistribution distributionAccessKey(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    NfeReturnDistribution distributionUltNsu(Long nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

}

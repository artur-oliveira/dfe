package com.softart.dfe.services.cte.inutilization;

import com.softart.dfe.enums.internal.Model;

public interface CteOsInutilizationService extends InutilizationService {

    @Override
    default Model getModel() {
        return Model.CTE_OS;
    }
}

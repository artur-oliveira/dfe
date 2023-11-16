package org.dfe.services.cte.inutilization;

import org.dfe.enums.internal.Model;

public interface CteOsInutilizationService extends InutilizationService {

    @Override
    default Model getModel() {
        return Model.CTE_OS;
    }
}

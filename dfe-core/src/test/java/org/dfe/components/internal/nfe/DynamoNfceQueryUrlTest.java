package org.dfe.components.internal.nfe;

import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.services.NoProviderFound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DynamoNfceQueryUrlTest {
    @Test
    @DisplayName("Test DynamoNfceQueryUrl: Should get all urls from all ufs")
    void testGetQueryUrlForAllUf() throws NoProviderFound {
        for (UF uf : UF.states()) {
            assertNotNull(new DynamoNfceQueryUrl().get(uf, Environment.PRODUCTION));
            assertNotNull(new DynamoNfceQueryUrl().get(uf, Environment.HOMOLOGATION));
        }
    }
}
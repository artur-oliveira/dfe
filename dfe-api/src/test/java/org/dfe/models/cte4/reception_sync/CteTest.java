package org.dfe.models.cte4.reception_sync;

import br.inf.portalfiscal.cte.send400.*;
import org.dfe.util.StubsClassComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CteTest {
    @Test
    void testIfNotNewFields() {
        Assertions.assertTrue(StubsClassComparator.compare(Cte.class, TCTe.class, true, true, "any", "infPAA", "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Cte.InfCte.InfCTeNorm.InfModal.Aereo.class, Aereo.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Cte.InfCte.InfCTeNorm.InfModal.Aquav.class, Aquav.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Cte.InfCte.InfCTeNorm.InfModal.Duto.class, Duto.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Cte.InfCte.InfCTeNorm.InfModal.Ferrov.class, Ferrov.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Cte.InfCte.InfCTeNorm.InfModal.Multimodal.class, Multimodal.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Cte.InfCte.Imp.class, TCTe.InfCte.Imp.class, true, true, "signature", "content", "hashCSRT").isEmpty());
    }
}
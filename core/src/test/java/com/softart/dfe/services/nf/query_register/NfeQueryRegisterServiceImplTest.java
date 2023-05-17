package com.softart.dfe.services.nf.query_register;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.models.nf.query_register.ReturnQueryRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NfeQueryRegisterServiceImplTest {
    @Test
    void testQueryRegisterWithUfIsPi() throws Exception {
        NfeQueryRegisterService service = new NfeQueryRegisterServiceImpl(
                new PfxNfeConfigImpl(
                        UF.PI,
                        "11520224000140",
                        Environment.PRODUCTION,
                        KeyStoreFactory.getInstance(),
                        NFEmissionType.NORMAL,
                        NFSend.SYNC
                ));

        ReturnQueryRegister o = service.queryRegister("11520224000140", UF.PI);
        assertNotNull(o);
    }
}
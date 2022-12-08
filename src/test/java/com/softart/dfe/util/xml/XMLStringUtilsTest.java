package com.softart.dfe.util.xml;

import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.util.XMLStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class XMLStringUtilsTest {

    @Test
    void idEvento() {
        Assertions.assertEquals("ID1101119999999999999999999999999999999999999999999901", XMLStringUtils.idEvento(NFEvent.CANCEL.getCode(), "99999999999999999999999999999999999999999999", "1"));
    }

    @Test
    void idInut() {
        Assertions.assertEquals("ID22220000000000000055001000000001000000001", XMLStringUtils.idNfeInut("22", "22", "00000000000000", "55", "1", "1", "1"));
    }
}
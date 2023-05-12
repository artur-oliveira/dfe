package com.softart.dfe.components.internal.parser;

import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessKeyParserFactoryImplTest {

    @Test
    void testYearMonth() {
        assertEquals(YearMonth.of(2023, 5), new AccessKeyParserFactoryImpl().yearMonth("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testMonth() {
        assertEquals(5, new AccessKeyParserFactoryImpl().month("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testYear() {
        assertEquals(2023, new AccessKeyParserFactoryImpl().year("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testCnpj() {
        assertEquals("99999999999999", new AccessKeyParserFactoryImpl().cnpj("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testModel() {
        assertEquals(Model.NFCE, new AccessKeyParserFactoryImpl().model("22230599999999999999650010001700611843992638"));
        assertEquals(Model.NFE, new AccessKeyParserFactoryImpl().model("22230599999999999999550010001700611843992638"));
        assertEquals(Model.CTE, new AccessKeyParserFactoryImpl().model("22230599999999999999570010001700611843992638"));
        assertEquals(Model.CTE_OS, new AccessKeyParserFactoryImpl().model("22230599999999999999670010001700611843992638"));
        assertEquals(Model.MDFE, new AccessKeyParserFactoryImpl().model("22230599999999999999580010001700611843992638"));
        assertEquals(Model.GTVE, new AccessKeyParserFactoryImpl().model("22230599999999999999640010001700611843992638"));
    }

    @Test
    void testSerie() {
        assertEquals(1, new AccessKeyParserFactoryImpl().serie("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testNumber() {
        assertEquals(170061, new AccessKeyParserFactoryImpl().number("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testCode() {
        assertEquals(84399263, new AccessKeyParserFactoryImpl().code("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testDigit() {
        assertEquals(8, new AccessKeyParserFactoryImpl().digit("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testUf() {
        assertEquals(UF.PI, new AccessKeyParserFactoryImpl().uf("22230599999999999999650010001700611843992638"));
    }

    @Test
    void testFormat() {
        assertEquals("2223 0599 9999 9999 9999 6500 1000 1700 6118 4399 2638", new AccessKeyParserFactoryImpl().format("22230599999999999999650010001700611843992638"));
    }
    @Test
    void testPrettyFormat() {
        assertEquals("22 23/05 97.185.385/0001-40 65 001 000-170-061 1 84399263-8", new AccessKeyParserFactoryImpl().prettyFormat("22230597185385000140650010001700611843992638"));
        assertEquals("22 23/05 861.302.780-63 65 001 000-170-061 1 84399263-8", new AccessKeyParserFactoryImpl().prettyFormat("22230500086130278063650010001700611843992638"));
    }
}
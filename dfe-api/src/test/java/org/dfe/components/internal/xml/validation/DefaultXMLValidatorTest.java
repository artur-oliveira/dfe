package org.dfe.components.internal.xml.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultXMLValidatorTest {

    DefaultXMLValidator xmlValidator = new DefaultXMLValidator();

    @Test
    @DisplayName("Test DefaultXmlValidator: Should initialize default schemas")
    void testInitializationDefaultSchemas() {
        Assertions.assertEquals(14, new DefaultXMLValidator().getSchemaMapping().size());
    }

    @Test
    void testGetSchemasCtePL_CTe_300a_NT2022_001() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/consReciCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/consReciCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/consSitCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/consSitCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/consStatServCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/consStatServTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cte_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAereo_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAquaviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalDutoviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalFerroviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalRodoviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalRodoviarioOS_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteMultiModal_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteOS_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/enviCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCancCECTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCancCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCCeCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCECTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/eventoCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/eventoCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evEPECCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evGTV_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evPrestDesacordo_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/evRegMultimodal_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/GTVe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/inutCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/inutCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/procCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/procCTeOS_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/procEventoCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/procGTVe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/procInutCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/protCTe.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/protCteOS.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/protGTVe.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retConsReciCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retConsSitCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retConsStatServCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retCTeOS_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retEnviCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retEventoCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retGTVe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/retInutCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/tiposGeralCTe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_300a_NT2022.001/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasCtePL_CTe_400() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/consSitCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/consSitCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/consStatServCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/consStatServTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cte_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteModalAereo_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteModalAquaviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteModalDutoviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteModalFerroviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteModalRodoviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteModalRodoviarioOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteMultiModal_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/cteTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evCancCECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evCancCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evCancIECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evCancPrestDesacordo_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evCCeCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evCECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/eventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/eventoCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evEPECCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evGTV_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evIECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evPrestDesacordo_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/evRegMultimodal_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/GTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/inutCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/inutCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/procCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/procCTeOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/procEventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/procGTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/procInutCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/protCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/protCteOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/protGTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/retConsSitCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/retConsStatServCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/retCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/retCTeOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/retEventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/retGTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/retInutCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/tiposGeralCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasCtePL_CTe_400_NT2025_001_RTC_101a() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/consSitCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/consSitCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/consStatServCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/consStatServTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cte_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteModalAereo_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteModalAquaviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteModalDutoviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteModalFerroviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteModalRodoviario_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteModalRodoviarioOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteMultiModal_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/cteTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evCancCECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evCancCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evCancIECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evCancPrestDesacordo_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evCCeCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evCECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/eventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/eventoCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evEPECCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evGTV_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evIECTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evPrestDesacordo_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/evRegMultimodal_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/GTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/procCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/procCTeOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/procEventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/procGTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/protCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/protCteOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/protGTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/retConsSitCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/retConsStatServCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/retCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/retCTeOS_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/retEventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/retGTVe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/tiposGeralCTe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTe_400_NT2025_001_RTC_101a/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasCtePL_CTeDistDFe_100() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTeDistDFe_100/distDFeInt_v1.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTeDistDFe_100/retDistDFeInt_v1.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTeDistDFe_100/tiposDistDFe_v1.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/cte/PL_CTeDistDFe_100/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasMdfePL_MDFe_300b() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consMDFeNaoEnc_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consMDFeNaoEncTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consReciMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consReciMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consSitMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consSitMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consStatServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/consStatServTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/distMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/enviMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/evAlteracaoPagtoServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/evCancMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/evConfirmaServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/evEncMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/eventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/eventoMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/evIncCondutorMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/evInclusaoDFeMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/evPagtoOperMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/leiauteDistMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfeConsultaDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfeConsultaDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalAereo_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalAquaviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalFerroviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalRodoviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/mdfeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/procEventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/procMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/protMDFe.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retConsMDFeNaoEnc_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retConsReciMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retConsSitMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retConsStatServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retDistMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retEnviMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retEventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/retMDFeConsultaDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/tiposGeralMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b/xmldsig-core-schema_v1.01.xsd"));

    }

    @Test
    void testGetSchemasMdfePL_MDFe_300b_NT012025_100() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consMDFeNaoEnc_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consMDFeNaoEncTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consReciMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consReciMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consSitMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consSitMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consStatServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/consStatServTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/distMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/enviMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/evAlteracaoPagtoServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/evCancMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/evConfirmaServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/evEncMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/eventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/eventoMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/evIncCondutorMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/evInclusaoDFeMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/evPagtoOperMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/leiauteDistMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeConsultaDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeConsultaDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeModalAereo_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeModalAquaviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeModalFerroviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeModalRodoviario_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/mdfeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/procEventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/procMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/protMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retConsMDFeNaoEnc_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retConsReciMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retConsSitMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retConsStatServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retDistMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retEnviMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retEventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/retMDFeConsultaDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/tiposGeralMDFe_v3.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/mdfe/PL_MDFe_300b_NT012025_100/xmldsig-core-schema_v1.01.xsd"));
    }


    @Test
    void testGetSchemasNfePL_010b_NT2025_002_v121() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/consCad_v2.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/consReciNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/consSitNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/consStatServ_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/enviNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/inutNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/leiauteConsSitNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/leiauteConsStatServ_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/leiauteConsultaCadastro_v2.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/leiauteInutNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/leiauteNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/nfe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/procInutNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/procNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/retConsCad_v2.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/retConsReciNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/retConsSitNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/retConsStatServ_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/retEnviNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/retInutNFe_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/tiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_010b_NT2025_002_v1.21/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfePL_ConsultaGTIN_v100() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/consGTIN_v1.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/leiauteCcgConsGTIN_v1.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/retConsGTIN_v1.00.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/tiposBasicosCcgConsGTIN_v1.00.xsd"));
    }

    @Test
    void testGetSchemasNfePL_NFeDistDFe_103() {
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_NFeDistDFe_103/distDFeInt_v1.01.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_NFeDistDFe_103/resEvento_v1.01.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_NFeDistDFe_103/resNFe_v1.01.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_NFeDistDFe_103/retDistDFeInt_v1.01.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_NFeDistDFe_103/tiposDistDFe_v1.01.xsd"));
        Assertions.assertNotNull(xmlValidator.loadSchema("xsds/nfe/PL_NFeDistDFe_103/xmldsig-core-schema_v1.01.xsd"));
    }
}
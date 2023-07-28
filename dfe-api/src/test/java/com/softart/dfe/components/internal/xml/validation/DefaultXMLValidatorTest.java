package com.softart.dfe.components.internal.xml.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultXMLValidatorTest {

    @Test
    void testGetSchemasCtePL_CTe_300a_NT2022_001() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/consReciCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/consReciCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/consSitCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/consSitCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/consStatServCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/consStatServTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cte_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAereo_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalAquaviario_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalDutoviario_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalFerroviario_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalRodoviario_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteModalRodoviarioOS_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteMultiModal_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteOS_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/cteTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/enviCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCancCECTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCancCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCCeCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evCECTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/eventoCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/eventoCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evEPECCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evGTV_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evPrestDesacordo_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/evRegMultimodal_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/GTVe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/inutCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/inutCTeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/procCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/procCTeOS_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/procEventoCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/procGTVe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/procInutCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/protCTe.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/protCteOS.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/protGTVe.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retConsReciCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retConsSitCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retConsStatServCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retCTeOS_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retEnviCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retEventoCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retGTVe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/retInutCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/tiposGeralCTe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_300a_NT2022.001/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasCtePL_CTe_400() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/consSitCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/consSitCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/consStatServCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/consStatServTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cte_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteModalAereo_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteModalAquaviario_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteModalDutoviario_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteModalFerroviario_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteModalRodoviario_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteModalRodoviarioOS_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteMultiModal_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteOS_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/cteTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evCancCECTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evCancCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evCancIECTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evCancPrestDesacordo_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evCCeCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evCECTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/eventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/eventoCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evEPECCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evGTV_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evIECTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evPrestDesacordo_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/evRegMultimodal_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/GTVe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/inutCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/inutCTeTiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/procCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/procCTeOS_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/procEventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/procGTVe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/procInutCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/protCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/protCteOS_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/protGTVe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/retConsSitCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/retConsStatServCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/retCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/retCTeOS_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/retEventoCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/retGTVe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/retInutCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/tiposGeralCTe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTe_400/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasCtePL_CTeDistDFe_100() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTeDistDFe_100/distDFeInt_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTeDistDFe_100/retDistDFeInt_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTeDistDFe_100/tiposDistDFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/cte/PL_CTeDistDFe_100/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasMdfePL_MDFe_300b() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consMDFeNaoEnc_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consMDFeNaoEncTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consReciMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consReciMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consSitMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consSitMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consStatServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/consStatServTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/distMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/enviMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/evAlteracaoPagtoServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/evCancMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/evConfirmaServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/evEncMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/eventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/eventoMDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/evIncCondutorMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/evInclusaoDFeMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/evPagtoOperMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/leiauteDistMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfeConsultaDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfeConsultaDFeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalAereo_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalAquaviario_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalFerroviario_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfeModalRodoviario_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/mdfeTiposBasico_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/procEventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/procMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/protMDFe.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retConsMDFeNaoEnc_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retConsReciMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retConsSitMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retConsStatServMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retDistMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retEnviMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retEventoMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/retMDFeConsultaDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/tiposGeralMDFe_v3.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/mdfe/PL_MDFe_300b/xmldsig-core-schema_v1.01.xsd"));

    }

    @Test
    void testGetSchemasNfeEvento_AtorInteressado_PL_v102() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/110150_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/envEventoAtorInteressado_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/eventoAtorInteressado_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/leiauteEventoAtorInteressado_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/procEventoAtorInteressado_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/retEnvEventoAtorInteressado_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_AtorInteressado_PL_v1.02/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfeEvento_Averb_PL_v100() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/Averb_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/e790700_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/envAverb_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/leiauteAverb_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/procAverbNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/retEnvAverb_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Averb_PL_v1.00/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfeEvento_Canc_PL_v101_NT_2018_004() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/e110111_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/envEventoCancNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/eventoCancNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/leiauteEventoCancNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/procEventoCancNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/retEnvEventoCancNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_Canc_PL_v1.01_NT_2018_004/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfeEvento_CancSubst_v101_NT_2018_004() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/e110112_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/envEventoCancSubst_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/eventoCancSubst_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/leiauteEventoCancSubst_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/procEventoCancSubst_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/retEnvEventoCancSubst_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CancSubst_v1.01_NT_2018_004/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfeEvento_CCe_PL_v101() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/CCe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/e110110_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/envCCe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/leiauteCCe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/procCCeNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/retEnvCCe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_CCe_PL_v1.01/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfeEvento_EntregaNFe_PL_v101() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/e110130_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/envEventoEntregaNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/EventoEntregaNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/leiauteEventoEntregaNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/procEventoEntregaNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/retEventoEntregaNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EntregaNFe_PL_v1.01/xmldsig-core-schema_v1.01.xsd"));
    }


    @Test
    void testGetSchemasNfeEvento_EPEC_PL_v101() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/e110140_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/envEPEC_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/EPEC_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/leiauteEPEC_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/procEPEC_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/retEnvEPEC_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_EPEC_PL_v1.01/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfeEvento_ManifestaDest_PL_v101() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_ManifestaDest_PL_v1.01/confRecebto_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_ManifestaDest_PL_v1.01/leiauteConfRecebto_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_ManifestaDest_PL_v1.01/procConfRecebtoNFe_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_ManifestaDest_PL_v1.01/retEnvConfRecebto_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_ManifestaDest_PL_v1.01/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/Evento_ManifestaDest_PL_v1.01/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfePL_009k_NT2023_001_v110a() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/consCad_v2.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/consReciNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/consSitNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/consStatServ_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/enviNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/inutNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/leiauteConsSitNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/leiauteConsStatServ_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/leiauteConsultaCadastro_v2.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/leiauteInutNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/leiauteNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/nfe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/procInutNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/procNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/retConsCad_v2.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/retConsReciNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/retConsSitNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/retConsStatServ_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/retEnviNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/retInutNFe_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/tiposBasico_v1.03.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/tiposBasico_v4.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_009k_NT2023_001_v110a/xmldsig-core-schema_v1.01.xsd"));
    }

    @Test
    void testGetSchemasNfePL_ConsultaGTIN_v100() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/consGTIN_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/leiauteCcgConsGTIN_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/retConsGTIN_v1.00.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_ConsultaGTIN_v1.00/tiposBasicosCcgConsGTIN_v1.00.xsd"));
    }

    @Test
    void testGetSchemasNfePL_NFeDistDFe_103() {
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_NFeDistDFe_103/distDFeInt_v1.01.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_NFeDistDFe_103/resEvento_v1.01.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_NFeDistDFe_103/resNFe_v1.01.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_NFeDistDFe_103/retDistDFeInt_v1.01.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_NFeDistDFe_103/tiposDistDFe_v1.01.xsd"));
        Assertions.assertNotNull(new DefaultXMLValidator().getSchema("xsds/nfe/PL_NFeDistDFe_103/xmldsig-core-schema_v1.01.xsd"));
    }
}
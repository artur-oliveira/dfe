import br.inf.portalfiscal.nfe.send.TUf;
import br.inf.portalfiscal.nfe.send.TUfEmi;
import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.components.internal.ProjectProperties;
import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfceConfigImpl;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.components.security.signer.DefaultXmlSigner;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.*;
import com.softart.dfe.enums.nf.payment.NFPaymentIndicative;
import com.softart.dfe.enums.nf.payment.NFPaymentType;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.nf.authorization.Nf;
import com.softart.dfe.models.nf.authorization.NfProtocol;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.epec.ReturnNfeEpec;
import com.softart.dfe.models.nf.return_authorization.ReturnQueryReceiptNfe;
import com.softart.dfe.services.nf.authorization.NfAuthorizationService;
import com.softart.dfe.services.nf.authorization.NfceAuthorizationServiceImpl;
import com.softart.dfe.services.nf.authorization.NfeAuthorizationServiceImpl;
import com.softart.dfe.services.nf.cancel.NfCancelService;
import com.softart.dfe.services.nf.cancel.NfceCancelServiceImpl;
import com.softart.dfe.services.nf.cancel.NfeCancelServiceImpl;
import com.softart.dfe.services.nf.correction_letter.NfeCorrectionLetterService;
import com.softart.dfe.services.nf.correction_letter.NfeCorrectionLetterServiceImpl;
import com.softart.dfe.services.nf.distribution.NfeDistributionService;
import com.softart.dfe.services.nf.distribution.NfeDistributionServiceImpl;
import com.softart.dfe.services.nf.epec.NfeEpecService;
import com.softart.dfe.services.nf.epec.NfeEpecServiceImpl;
import com.softart.dfe.services.nf.interested_actor.NfeInterestedActorService;
import com.softart.dfe.services.nf.interested_actor.NfeInterestedActorServiceImpl;
import com.softart.dfe.services.nf.inutilization.NfInutilizationService;
import com.softart.dfe.services.nf.inutilization.NfceInutilizationServiceImpl;
import com.softart.dfe.services.nf.inutilization.NfeInutilizationServiceImpl;
import com.softart.dfe.services.nf.manifestation.NfeManifestationService;
import com.softart.dfe.services.nf.manifestation.NfeManifestationServiceImpl;
import com.softart.dfe.services.nf.query_gtin.NfQueryGtinService;
import com.softart.dfe.services.nf.query_gtin.NfQueryGtinServiceImpl;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;
import com.softart.dfe.services.nf.query_protocol.NfceQueryProtocolServiceImpl;
import com.softart.dfe.services.nf.query_protocol.NfeQueryProtocolServiceImpl;
import com.softart.dfe.services.nf.query_register.NfeQueryRegisterService;
import com.softart.dfe.services.nf.query_register.NfeQueryRegisterServiceImpl;
import com.softart.dfe.services.nf.query_status_service.NfQueryStatusService;
import com.softart.dfe.services.nf.query_status_service.NfceQueryStatusServiceImpl;
import com.softart.dfe.services.nf.query_status_service.NfeQueryStatusServiceImpl;
import com.softart.dfe.services.nf.return_authorization.NfReturnAuthorizationService;
import com.softart.dfe.services.nf.return_authorization.NfceReturnAuthorizationServiceImpl;
import com.softart.dfe.services.nf.return_authorization.NfeReturnAuthorizationServiceImpl;
import com.softart.dfe.services.nf.substitute_cancel.NfceSubstituteCancelService;
import com.softart.dfe.services.nf.substitute_cancel.NfceSubstituteCancelServiceImpl;
import com.softart.dfe.util.DateUtils;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Log4j2
public final class App {

    public static void main(String[] args) throws Exception {
        NfUnmarshallerFactory.getInstance().nfeProc("<?xml version=\"1.0\" encoding=\"UTF-8\"?><nfeProc xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\"><NFe><infNFe Id=\"NFe22230511520224000140550010000450351673414066\" versao=\"4.00\"><ide><cUF>22</cUF><cNF>67341406</cNF><natOp>Remessa de vasilhame ou sacaria</natOp><mod>55</mod><serie>1</serie><nNF>45035</nNF><dhEmi>2023-05-09T09:18:25-03:00</dhEmi><dhSaiEnt>2023-05-09T09:18:25-03:00</dhSaiEnt><tpNF>1</tpNF><idDest>1</idDest><cMunFG>2211001</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>6</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>0</indPres><procEmi>0</procEmi><verProc>rev-nfe-old_0.0.1</verProc></ide><emit><CNPJ>11520224000140</CNPJ><xNome>Tartigrado Tecnologia LTDA</xNome><xFant>RevGás</xFant><enderEmit><xLgr>Avenida Raul Lopes</xLgr><nro>333</nro><xBairro>Fátima</xBairro><cMun>2211001</cMun><xMun>Teresina</xMun><UF>PI</UF><CEP>64049548</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>558632622414</fone></enderEmit><IE>194739350</IE><CRT>3</CRT></emit><dest><CNPJ>11520224000140</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><enderDest><xLgr>Avenida Raul Lopes</xLgr><nro>333</nro><xBairro>Fátima</xBairro><cMun>2211001</cMun><xMun>Teresina</xMun><UF>PI</UF><CEP>64049548</CEP><cPais>1058</cPais><xPais>BRASIL</xPais></enderDest><indIEDest>1</indIEDest><IE>194739350</IE></dest><autXML><CPF>16909879015</CPF></autXML><det nItem=\"1\"><prod><cProd>1225</cProd><cEAN>SEM GTIN</cEAN><xProd>VASILHAME 13KG - ONU 1075 GLP 2.1</xProd><NCM>73110000</NCM><CEST>0101900</CEST><CFOP>5920</CFOP><uCom>UNID</uCom><qCom>1</qCom><vUnCom>160.0000000000</vUnCom><vProd>160.00</vProd><cEANTrib>SEM GTIN</cEANTrib><uTrib>UNID</uTrib><qTrib>1</qTrib><vUnTrib>160.0000000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMS40><orig>0</orig><CST>40</CST></ICMS40></ICMS><PIS><PISOutr><CST>49</CST><vBC>0.00</vBC><pPIS>0.00</pPIS><vPIS>0.00</vPIS></PISOutr></PIS><COFINS><COFINSOutr><CST>49</CST><vBC>0.00</vBC><pCOFINS>0.00</pCOFINS><vCOFINS>0.00</vCOFINS></COFINSOutr></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vICMSDeson>0.00</vICMSDeson><vFCP>0.00</vFCP><vBCST>0.00</vBCST><vST>0.00</vST><vFCPST>0.00</vFCPST><vFCPSTRet>0.00</vFCPSTRet><vProd>160.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vIPIDevol>0.00</vIPIDevol><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>160.00</vNF><vTotTrib>0.00</vTotTrib></ICMSTot></total><transp><modFrete>9</modFrete><vol><qVol>1</qVol><esp>VASILHAME</esp><marca>INDEPENDENTE</marca><pesoL>13.000</pesoL><pesoB>13.000</pesoB></vol></transp><pag><detPag><indPag>0</indPag><tPag>90</tPag><vPag>0.00</vPag></detPag></pag><infAdic/><infRespTec><CNPJ>11520224000140</CNPJ><xContato>Rafael Ferreira da Costa</xContato><email>rafael@revgas.com</email><fone>01149508005</fone></infRespTec></infNFe><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe22230511520224000140550010000450351673414066\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>ZPapSkkw+aqPgxMRw601rFYUt3Q=</DigestValue></Reference></SignedInfo><SignatureValue>QbUjufEaBTjeouSGHF/3/b/wsJaQrkNf77nPRrWnjxqVExyy3ZgscFV3citzlCmnQ3OMmxsX//9jQQEfftWTnyraeb4Uo2y4aquUHeMHiWlU0NGrHu0MlwZj/2K8Dg9JFX5+9q5bZwIiJZla7FU/Ng1PFKfaORgHnzfw00TkCpkk262EvUvF/XjKX7fd3A3/CrHhha5SVoJBuFQ2zMi+UOFF4TvcpJa3Ze9PbtTWtAyBc/c3yB754dz/e9hmTIuqVdL5jtOpCrFNx3kjkVFADZccdAzQr5XFG+2iQa5e/99JFjAQryO2hIydfjPAlU+29RIDLNuoF50/CexAmF1HwQ==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIHMTCCBRmgAwIBAgIIYiQjBCZAwTwwDQYJKoZIhvcNAQELBQAwWTELMAkGA1UEBhMCQlIxEzARBgNVBAoTCklDUC1CcmFzaWwxFTATBgNVBAsTDEFDIFNPTFVUSSB2NTEeMBwGA1UEAxMVQUMgU09MVVRJIE11bHRpcGxhIHY1MB4XDTIzMDQyNjE0MzkwMFoXDTI0MDQyNTE0MzkwMFowgeAxCzAJBgNVBAYTAkJSMRMwEQYDVQQKEwpJQ1AtQnJhc2lsMQswCQYDVQQIEwJQSTERMA8GA1UEBxMIVGVyZXNpbmExHjAcBgNVBAsTFUFDIFNPTFVUSSBNdWx0aXBsYSB2NTEXMBUGA1UECxMOMzM0MTYwNzkwMDAxOTUxEzARBgNVBAsTClByZXNlbmNpYWwxGjAYBgNVBAsTEUNlcnRpZmljYWRvIFBKIEExMTIwMAYDVQQDEylUQVJUSUdSQURPIFRFQ05PTE9HSUEgTFREQToxMTUyMDIyNDAwMDE0MDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBANSORuVn5ALwi6X5N71/Q5NhfWmdzYbmyZBTvY2lswgpcRTBV8cHRNRWdp1ogksp5vSSC4GP4mCintoUuaWKTtMUSI20gsp7VWXH0NZaak33yMLo7m8uMdW93jtBX4bH2LDXsWES8PgoGmnP2xWRFBvKVTgGjmkQSU0RsbZ7wbN1Tcilog8rRHy7rNi+pQ+u0dxiI9hN7TKtaJtfes0aw32n9GFqf/fAOwr72SwLOa0l0hc6zRJhX7lNTBPfI0/5EYdXyk7lgBsssWhGtOYATjwBABYfoRLeaJn5yyBC1WwMjgiagOwRtYFsDUkc6miE1adkWc0fAjt+HsaqMk3k+dUCAwEAAaOCAnMwggJvMAkGA1UdEwQCMAAwHwYDVR0jBBgwFoAUxVLtJYAJ35yCyJ9Hxt20XzHdubEwVAYIKwYBBQUHAQEESDBGMEQGCCsGAQUFBzAChjhodHRwOi8vY2NkLmFjc29sdXRpLmNvbS5ici9sY3IvYWMtc29sdXRpLW11bHRpcGxhLXY1LnA3YjCBrgYDVR0RBIGmMIGjgRVoaWdvbWF0b3NAaG90bWFpbC5jb22gHAYFYEwBAwKgExMRSElHTyBTT0FSRVMgTUFUT1OgGQYFYEwBAwOgEBMOMTE1MjAyMjQwMDAxNDCgOAYFYEwBAwSgLxMtMjAxMjE5ODI4ODMzMjgxMDM1MzAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwoBcGBWBMAQMHoA4TDDAwMDAwMDAwMDAwMDBdBgNVHSAEVjBUMFIGBmBMAQIBJjBIMEYGCCsGAQUFBwIBFjpodHRwOi8vY2NkLmFjc29sdXRpLmNvbS5ici9kb2NzL2RwYy1hYy1zb2x1dGktbXVsdGlwbGEucGRmMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDCBjAYDVR0fBIGEMIGBMD6gPKA6hjhodHRwOi8vY2NkLmFjc29sdXRpLmNvbS5ici9sY3IvYWMtc29sdXRpLW11bHRpcGxhLXY1LmNybDA/oD2gO4Y5aHR0cDovL2NjZDIuYWNzb2x1dGkuY29tLmJyL2xjci9hYy1zb2x1dGktbXVsdGlwbGEtdjUuY3JsMB0GA1UdDgQWBBQyrIk1yS8wKf4E1OgGN+6RkWqANzAOBgNVHQ8BAf8EBAMCBeAwDQYJKoZIhvcNAQELBQADggIBALcDFddSCfzw+320hiPYH4uRVhq712mpgJl+o0IJBQCa4BVTABqnx3gAt5lg1Dwhie878k7g6E+EoBaXFo3Zh9K8W8cCkDEssPWLBS5DvrCn3E4Bc6cX3jVmDjzWOjXwOUsl1jHfXz3RKjvb23vWKLBEfZmPfnr+aA0ZQ7oF58hj79vDQ1fpCshiaNtE1ZNkWW8PDAUpoRd8+8+gXLBKiUthE97DTOaScbrmdQUQ2rVgJSnMmLS3lCXSeAJmWWmswhSDvIB2/8moEK5Xy/OJMABRG7+pjUlZTUCFuWMm0POKofhgYRQTUWVhN9lFW7QXsXeQUReN2A2cd/M+5/3T5V/sU9yvSEs428p+Oh9pORpN4ToFI0zu4Ox0jSqNx4PlG9dFXaT5xSE24OVnaF5BVvIEoITTaVM4CFXoh4J2KxtQgQcCTkZmzr0OOYLFK3j/YOx9t7UNdWRn5HiK9JBYCq8+BFFmmTm8XRVuPVHTAE/uJ3FI4Y1cV12vq7xtfPJZJV1jsFtFhrOOm/GX8vwER0fMp0wD+Z6qXpE8BabC78PcImvBu0Y+eFGQPnwCpDMr51pUtBlAz+rYkF5xbNaAIA0I/iO1Oqi1k0AzFpsSHaWSDp/v/7HR66M+WtziGc/uRRE5ZxkvbZRSOsuxwqQAgvBwLA//t+GBwhNG5ESragpT</X509Certificate></X509Data></KeyInfo></Signature></NFe><protNFe versao=\"4.00\"><infProt><tpAmb>2</tpAmb><verAplic>SVRS202304271238</verAplic><chNFe>22230511520224000140550010000450351673414066</chNFe><dhRecbto>2023-05-09T09:18:25-03:00</dhRecbto><nProt>322230000007863</nProt><digVal>ZPapSkkw+aqPgxMRw601rFYUt3Q=</digVal><cStat>100</cStat><xMotivo>Autorizado o uso da NF-e</xMotivo></infProt></protNFe></nfeProc>");
        System.setProperty("com.softart.certificate.path", "path/to/certificate.pfx");
        System.setProperty("com.softart.certificate.password", "*");
        System.setProperty("com.softart.dfe.storage.nf.logxml", "true");
        System.setProperty("com.softart.dfe.handler.log.request", "true");
        System.setProperty("com.softart.dfe.handler.log.response", "true");

//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
//        cancelarNf("22221211520224000140550010000036481434788272", "322220000036984");
//        cancelarNfc("22220911520224000140650010000046781605558739");
//        substituteCancelNfc("22220911520224000140650010000046851087679555", "22220911520224000140650010000046869703887050");
//        queryGtin("7891249061166");
//        all();
//        autorizarNf();
        consultaCadastro();
//        autorizarNfc();
//        consultarLoteNfce("223065113228925");
//        consultarLote("291100011499320");
//        consultarProtocoloNfe("");
//        consultarProtocoloNfce("51230131085374000180650010000059521786181100");
//        generateProcNfce(Arrays.asList("<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><idLote>138564689</idLote><indSinc>1</indSinc><NFe><infNFe Id=\"NFe51230131085374000180650010000059521786181100\" versao=\"4.00\"><ide><cUF>51</cUF><cNF>78618110</cNF><natOp>Venda de combustivel ou lubrificante, adquiridos ou receb...</natOp><mod>65</mod><serie>1</serie><nNF>5952</nNF><dhEmi>2023-01-14T17:28:11-03:00</dhEmi><tpNF>1</tpNF><idDest>1</idDest><cMunFG>5107602</cMunFG><tpImp>4</tpImp><tpEmis>1</tpEmis><cDV>0</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>1</indPres><procEmi>0</procEmi><verProc>1.4.0</verProc></ide><emit><CNPJ>31085374000180</CNPJ><xNome>WILLYAN BOAVENTURA FERREIRA</xNome><xFant>ZYZZ DEPOSITO DE GAS E AGUA</xFant><enderEmit><xLgr>Barao Do Rio Branco</xLgr><nro>2689</nro><xBairro>Jardim Guanabara</xBairro><cMun>5107602</cMun><xMun>Rondonopolis</xMun><UF>MT</UF><CEP>78710185</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>6699826777</fone></enderEmit><IE>137321082</IE><CRT>1</CRT></emit><det nItem=\"1\"><prod><cProd>7709</cProd><cEAN>SEM GTIN</cEAN><xProd>ONU 1075 GLP 2.1 - 13KG</xProd><NCM>27111910</NCM><CEST>0601100</CEST><CFOP>5656</CFOP><uCom>UNID</uCom><qCom>1.0000</qCom><vUnCom>140.0000000000</vUnCom><vProd>140.00</vProd><cEANTrib>SEM GTIN</cEANTrib><uTrib>KG</uTrib><qTrib>13.0000</qTrib><vUnTrib>10.7692307692</vUnTrib><vDesc>5.00</vDesc><indTot>1</indTot><comb><cProdANP>210203001</cProdANP><descANP>GLP</descANP><pGLP>100.0000</pGLP><vPart>3.24</vPart><UFCons>MT</UFCons></comb></prod><imposto><vTotTrib>0.00</vTotTrib><ICMS><ICMSSN500><orig>0</orig><CSOSN>500</CSOSN><vBCSTRet>0.00</vBCSTRet><pST>0.00</pST><vICMSSubstituto>0.00</vICMSSubstituto><vICMSSTRet>0.00</vICMSSTRet></ICMSSN500></ICMS><PIS><PISNT><CST>04</CST></PISNT></PIS><COFINS><COFINSNT><CST>04</CST></COFINSNT></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vICMSDeson>0.00</vICMSDeson><vFCP>0.00</vFCP><vBCST>0.00</vBCST><vST>0.00</vST><vFCPST>0.00</vFCPST><vFCPSTRet>0.00</vFCPSTRet><vProd>140.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>5.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vIPIDevol>0.00</vIPIDevol><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>135.00</vNF><vTotTrib>0.00</vTotTrib></ICMSTot></total><transp><modFrete>9</modFrete><vol><qVol>1</qVol><esp>GLP</esp><marca>COPAGAZ</marca><pesoL>13.000</pesoL><pesoB>13.000</pesoB></vol></transp><pag><detPag><indPag>0</indPag><tPag>03</tPag><vPag>135.00</vPag></detPag></pag><infAdic><infCpl>DOCUMENTO EMITIDO POR ME OU EPP OPTANTE PELO SIMPLES NACIONAL - NAO GERA DIREITO A CREDITO FISCAL DE IPI - PROCON - MT Rua Baltazar Navarros, n. 567 (antigo Sine), Bairro Bandeirantes, Cuiaba - MT | CEP 78010-020 Tel.: (65) 3613-2100</infCpl></infAdic><infRespTec><CNPJ>11520224000140</CNPJ><xContato>Rafael Ferreira da Costa</xContato><email>falecom@revgas.com</email><fone>5511943582313</fone></infRespTec></infNFe><infNFeSupl><qrCode>http://www.sefaz.mt.gov.br/nfce/consultanfce?p=51230131085374000180650010000059521786181100|2|1|1|0804D13E28833161F56CFD7CFC5039D66AD7BB42</qrCode><urlChave>http://www.sefaz.mt.gov.br/nfce/consultanfce</urlChave></infNFeSupl><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe51230131085374000180650010000059521786181100\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>5jVKcB+moeYcTNTEGmeya08YMk0=</DigestValue></Reference></SignedInfo><SignatureValue>LT3nTJRj1BJ/nds+GJ2bV2eZci8VBkwz7eids2fGO29hpFFrs21zzTksabOs+O+iXHUWMcMUQjYZ+2pkY50yiosPIvi1mV4ppocAduFRV5J657B1AkSDHX2UoxkoT3o1TndSSxOxHl6JkYVCcsc8iqklU84hgvFg4uXPrnG5FSH0J17U8+4ZjiIZBRt4bhJ/KsWOmHycTxkRFNyeo5ih7tdeFi7IUfAKrcCpAZWoq0lRsiKp9JWzGuV9+wEgxOYqi174HLVm6qNhM1Cls+mdAj0DABUWd3BRKdHxG68RGu1/5o6yMXU/befqqa+VSxWKBFvBGI7FCP2Dh5jQK91yjQ==</SignatureValue><KeyInfo><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe>", "<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><idLote>645438593</idLote><indSinc>1</indSinc><NFe><infNFe Id=\"NFe51230131085374000180650010000059551647060845\" versao=\"4.00\"><ide><cUF>51</cUF><cNF>64706084</cNF><natOp>Venda de combustivel ou lubrificante, adquiridos ou receb...</natOp><mod>65</mod><serie>1</serie><nNF>5955</nNF><dhEmi>2023-01-18T16:42:40-03:00</dhEmi><tpNF>1</tpNF><idDest>1</idDest><cMunFG>5107602</cMunFG><tpImp>4</tpImp><tpEmis>1</tpEmis><cDV>5</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>1</indPres><procEmi>0</procEmi><verProc>1.4.0</verProc></ide><emit><CNPJ>31085374000180</CNPJ><xNome>WILLYAN BOAVENTURA FERREIRA</xNome><xFant>ZYZZ DEPOSITO DE GAS E AGUA</xFant><enderEmit><xLgr>Barao Do Rio Branco</xLgr><nro>2689</nro><xBairro>Jardim Guanabara</xBairro><cMun>5107602</cMun><xMun>Rondonopolis</xMun><UF>MT</UF><CEP>78710185</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>6699826777</fone></enderEmit><IE>137321082</IE><CRT>1</CRT></emit><det nItem=\"1\"><prod><cProd>7709</cProd><cEAN>SEM GTIN</cEAN><xProd>ONU 1075 GLP 2.1 - 13KG</xProd><NCM>27111910</NCM><CEST>0601100</CEST><CFOP>5656</CFOP><uCom>UNID</uCom><qCom>1.0000</qCom><vUnCom>140.0000000000</vUnCom><vProd>140.00</vProd><cEANTrib>SEM GTIN</cEANTrib><uTrib>KG</uTrib><qTrib>13.0000</qTrib><vUnTrib>10.7692307692</vUnTrib><vDesc>10.00</vDesc><indTot>1</indTot><comb><cProdANP>210203001</cProdANP><descANP>GLP</descANP><pGLP>100.0000</pGLP><vPart>3.24</vPart><UFCons>MT</UFCons></comb></prod><imposto><vTotTrib>0.00</vTotTrib><ICMS><ICMSSN500><orig>0</orig><CSOSN>500</CSOSN><vBCSTRet>0.00</vBCSTRet><pST>0.00</pST><vICMSSubstituto>0.00</vICMSSubstituto><vICMSSTRet>0.00</vICMSSTRet></ICMSSN500></ICMS><PIS><PISNT><CST>04</CST></PISNT></PIS><COFINS><COFINSNT><CST>04</CST></COFINSNT></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vICMSDeson>0.00</vICMSDeson><vFCP>0.00</vFCP><vBCST>0.00</vBCST><vST>0.00</vST><vFCPST>0.00</vFCPST><vFCPSTRet>0.00</vFCPSTRet><vProd>140.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>10.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vIPIDevol>0.00</vIPIDevol><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>130.00</vNF><vTotTrib>0.00</vTotTrib></ICMSTot></total><transp><modFrete>9</modFrete><vol><qVol>1</qVol><esp>GLP</esp><marca>COPAGAZ</marca><pesoL>13.000</pesoL><pesoB>13.000</pesoB></vol></transp><pag><detPag><indPag>0</indPag><tPag>17</tPag><vPag>130.00</vPag></detPag></pag><infAdic><infCpl>DOCUMENTO EMITIDO POR ME OU EPP OPTANTE PELO SIMPLES NACIONAL - NAO GERA DIREITO A CREDITO FISCAL DE IPI - PROCON - MT Rua Baltazar Navarros, n. 567 (antigo Sine), Bairro Bandeirantes, Cuiaba - MT | CEP 78010-020 Tel.: (65) 3613-2100</infCpl></infAdic><infRespTec><CNPJ>11520224000140</CNPJ><xContato>Rafael Ferreira da Costa</xContato><email>falecom@revgas.com</email><fone>5511943582313</fone></infRespTec></infNFe><infNFeSupl><qrCode>http://www.sefaz.mt.gov.br/nfce/consultanfce?p=51230131085374000180650010000059551647060845|2|1|1|6CE5720F90311721319F51C562F0B2CBC2A18E14</qrCode><urlChave>http://www.sefaz.mt.gov.br/nfce/consultanfce</urlChave></infNFeSupl><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe51230131085374000180650010000059551647060845\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>RkXaF6cVBKICvWsNAk7djKJuzy8=</DigestValue></Reference></SignedInfo><SignatureValue>DSfYlpsJ8M6zShZja/Nk4fRoV5wIxzu3D4b1KGdv/ZEDEWY5p+ezyBxRK1xDhxRPrU6xyXIY5unFCS0zkaEja55IgIWxBgrcWcKhkRIOLdjQESBbZtDmhvUr8YkIYDdwIeYDylFv4XemN7vXU16cec0O+X3VH/S/iPYosY3+VSx04VbF+WguUnXfzgrKAh+untqph+Xq2Lox8ykloiPOuauCiO7sa6+mXqXPMdePSQHSSnhcTQmpPBV/nh7G1aVqbGFWM+ZoxPAhFuhR9dHnExjEm6vDsXaXaemtHWmzBEUgbZNgqhVqJLvnxYA7NuN/G9VpL8jJrqbQAVVD5JYTxQ==</SignatureValue><KeyInfo><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe>"));
//        inutilizarNf();
//        inutilizarNfce();
//        distributionNfAccessKey();
//        distributionNfUniqueNsu();
//        distributionNf();
//        operationScienceNf();
//        correctionLetterNf();
//        queryStatusServiceNf();
//        queryStatusServiceNfc();
//        epec();
//        interestedActor();
    }

    private static void consultaCadastro() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);

        NfeQueryRegisterService queryRegisterService = new NfeQueryRegisterServiceImpl(config);
        System.out.println(queryRegisterService.queryRegister("11520224000140", UF.PI));

    }

    private static void all() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfAuthorizationService service = new NfeAuthorizationServiceImpl(config);

        ReturnSendNf returnNf = service.authorization(Arrays.asList(getNfe(config, 50000), getNfe(config, 50001)));

        ReturnSendNf.InfRec rec = Objects.requireNonNull(returnNf.getInfRec());
        NfReturnAuthorizationService returnAuthorizationService = new NfeReturnAuthorizationServiceImpl(config);
        ReturnQueryReceiptNfe returnQueryReceiptNfe;
        do {
            Thread.sleep(1000L * Integer.parseInt((Objects.nonNull(rec.getTMed()) ? rec.getTMed() : "5")));
            returnQueryReceiptNfe = returnAuthorizationService.queryReceipt(rec.getNRec());
        } while (returnQueryReceiptNfe.getProtNFe().isEmpty());

        NfeCorrectionLetterService correction = new NfeCorrectionLetterServiceImpl(config);

        for (NfProtocol protNFe : returnQueryReceiptNfe.getProtNFe()) {
            correction.correctionLetter(protNFe.getInfProt().getChNFe(), "TESTE CARTA CORREÇÃO");
        }


        NfeCancelServiceImpl cancelService = new NfeCancelServiceImpl(config);

        for (NfProtocol protNFe : returnQueryReceiptNfe.getProtNFe()) {
            cancelService.cancel(protNFe.getInfProt().getChNFe(), protNFe.getInfProt().getNProt());
        }
    }

    private static void interestedActor() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
//
        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfeInterestedActorService service = new NfeInterestedActorServiceImpl(config);

        System.out.println(service.interestedActor("22220911520224000140550010000035361187602778", "05213730345", null));
    }

    private static void queryGtin(String gtin) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
//
        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfQueryGtinService service = new NfQueryGtinServiceImpl(config);

        System.out.println(service.queryGtin(gtin));
    }

    private static void epec() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();
//
        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfeEpecService epecService = new NfeEpecServiceImpl(config);

        Nf n = getNfe(config, 3532);
        ReturnNfeEpec returnepec = epecService.epec(n);

        System.out.println(returnepec);
    }

    private static void operationScienceNf() throws Exception {
        Collection<String> aks = Arrays.asList("22221211520224000140550010000036941623271229", "22221211520224000140550010000036931656073631");
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfeManifestationService service = new NfeManifestationServiceImpl(config);
        System.out.println(service.science(aks));

    }

    private static void correctionLetterNf() throws Exception {
        Collection<String> aks = Collections.singletonList("22220911520224000140550010000035101745364806");
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfeCorrectionLetterService service = new NfeCorrectionLetterServiceImpl(config);
        for (String ak : aks) {
            System.out.println(service.correctionLetter(ak, "LOREM IPSUM DOLOR SIT AMET"));
        }
    }

    private static void inutilizarNf() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfInutilizationService service = new NfeInutilizationServiceImpl(config);
        System.out.println(service.inutilization(1, 1, 1).getInfInut().getXMotivo());
    }

    private static void inutilizarNfce() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        XMLSignerService signer = new DefaultXmlSigner();
        NfInutilizationService service = new NfceInutilizationServiceImpl(config);

        for (int i = 1; i <= 4664; i++) {
            System.out.println(service.inutilization(1, i, i).getInfInut());
        }

    }

    private static void distributionNf() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfeDistributionService service = new NfeDistributionServiceImpl(config);
        System.out.println(service.distributionUltNsu(0L));
    }

    private static void distributionNfAccessKey() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfeDistributionService service = new NfeDistributionServiceImpl(config);
        System.out.println(service.distributionAccessKey("22220111520224000140550010000017131070903776"));
    }

    private static void distributionNfUniqueNsu() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfeDistributionService service = new NfeDistributionServiceImpl(config);
        System.out.println(service.distributionUniqueNsu(78L));
    }

    private static void autorizarNf() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        XMLSignerService signer = new DefaultXmlSigner();
        NfAuthorizationService service = new NfeAuthorizationServiceImpl(config);

        System.out.println(service.authorization(Collections.singletonList(getNfe(config, 1))));
    }

    private static void autorizarNfc() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.SC, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, "1", "115202241607220426225340");
        XMLSignerService signer = new DefaultXmlSigner();
        NfAuthorizationService service = new NfceAuthorizationServiceImpl(config);

        System.out.println(service.authorization(Collections.singletonList(getNfe(config, 1, Model.NFCE))));
    }

    private static void consultarLote(String lote) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        NfReturnAuthorizationService service = new NfeReturnAuthorizationServiceImpl(config);

        System.out.println(service.queryReceipt(lote));
    }

    private static void consultarLoteNfce(String lote) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);
        NfReturnAuthorizationService service = new NfceReturnAuthorizationServiceImpl(config);

        System.out.println(service.queryReceipt(lote));
    }

    private static void queryStatusServiceNf() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        NfQueryStatusService service = new NfeQueryStatusServiceImpl(config);

        System.out.println(service.queryStatusService());
    }

    private static void queryStatusServiceNfc() throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL, null, null);
        NfQueryStatusService service = new NfceQueryStatusServiceImpl(config);

        System.out.println(service.queryStatusService());
    }

    private static void consultarProtocoloNfe(String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);
        NfQueryProtocolService service = new NfeQueryProtocolServiceImpl(config);

        System.out.println(service.queryProtocol(accessKey));
    }

    private static void consultarProtocoloNfce(String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL, null, null);
        NfQueryProtocolService service = new NfceQueryProtocolServiceImpl(config);

        System.out.println(service.queryProtocol(accessKey));
    }

    private static void generateProcNfce(Collection<String> sendNfs) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.MT, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL, null, null);
        NfQueryProtocolService service = new NfceQueryProtocolServiceImpl(config);

        sendNfs.forEach(it -> service.getProcessed(it).forEach(proc -> log.info(NfMarshallerFactory.getInstance().procNfe(proc))));
    }

    private static Nf getNfe(NfConfig config, int number, Model model) {
        DFEnum.Codeable city = config.uf().getCities().stream().findAny().orElseThrow(RuntimeException::new);

        Nf nfe = Nf.builder().build();
        Nf.InfNFe infNFe = Nf.InfNFe.builder().build();

        Nf.InfNFe.Ide ide = Nf.InfNFe.Ide.builder().build();
        ide.setCuf(config.uf().getCode());
        ide.setNatOp("OPERACAO DE TESTE");
        ide.setSerie("2");
        ide.setNnf(String.valueOf(number));
        ide.setDhEmi(DateUtils.nowString());
        ide.setTpNF(NFType.OUTGOING.getCode());
        ide.setIdDest(NFOperationDestiny.INTERNAL.getCode());
        ide.setCMunFG(city.getCode());

        switch (model) {
            case NFE:
                ide.setTpImp(NFPrintType.PORTRAIT_DANFE.getCode());
                break;
            case NFCE:
                ide.setTpImp(NFPrintType.NFCE_DANFE.getCode());
            default:
                break;
        }

        ide.setTpEmis(config.emission().getCode());
        ide.setMod(model.getCode());

        if (!ide.getTpEmis().equals(NFEmissionType.NORMAL.getCode())) {
            ide.setDhCont(DateUtils.nowString());
            ide.setXJust("TESTE DE EMISSAO EM CONTIGENCIA");
        }

        ide.setTpAmb(config.environment().getCode());
        ide.setFinNFe(NFFinality.NORMAL.getCode());
        ide.setIndFinal(NFFinalConsumer.YES.getCode());
        ide.setVerProc(ProjectProperties.displayVersion());
        ide.setProcEmi(NFProcessEmission.APPLICATION.getCode());

        if (model.equals(Model.NFE)) {
            ide.setIndPres(NFPresenceIndicative.NOT_APPLY.getCode());
        } else {
            ide.setIndPres(NFPresenceIndicative.PRESENTIAL.getCode());
        }


        infNFe.setEmit(Nf.InfNFe.Emit.builder().cnpj(config.cnpj()).xNome("Teste Nome").xFant("Teste").ie("194739350").crt("1").enderEmit(Nf.InfNFe.Emit.EnderEmi.builder().cep("64014220").xBairro("Bairro Teste").xCpl("Complemento teste").cMun(city.getCode()).xMun(city.getDescription()).xLgr("Rua teste").nro("666").uf(TUfEmi.valueOf(config.uf().name())).build()).build());

        if (model.equals(Model.NFE)) {
            infNFe.setDest(Nf.InfNFe.Dest.builder().cnpj(config.cnpj()).ie("194739350").xNome("NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL").enderDest(Nf.InfNFe.Dest.Endereco.builder().cep("64014220").xBairro("Bairro Teste").xCpl("Complemento teste").cMun(city.getCode()).xMun(city.getDescription()).xLgr("Rua teste").nro("666").uf(TUf.valueOf(config.uf().name())).build()).indIEDest("9").build());
        }

        infNFe.setDet(Collections.singletonList(Nf.InfNFe.Det.builder().nItem("1").prod(Nf.InfNFe.Det.Prod.builder().cProd("1").xProd("NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL").cfop("5102").ncm("73110000").cest("0101900").vProd("70.00").qCom("1").vUnCom("70.0000000000").uCom("UNID").qTrib("1").vUnTrib("70.0000000000").uTrib("UNID").ceanTrib("SEM GTIN").cean("SEM GTIN").indTot("1").build()).imposto(Nf.InfNFe.Det.Imposto.builder().icms(Nf.InfNFe.Det.Imposto.ICMS.builder().icmssn102(Nf.InfNFe.Det.Imposto.ICMS.ICMSSN102.builder().csosn("400").orig("0").build()).build()).pis(Nf.InfNFe.Det.Imposto.PIS.builder().pisOutr(Nf.InfNFe.Det.Imposto.PIS.PISOutr.builder().cst("99").vpis("0.00").vbc("0.00").ppis("0.00").build()).build()).cofins(Nf.InfNFe.Det.Imposto.COFINS.builder().cofinsOutr(Nf.InfNFe.Det.Imposto.COFINS.COFINSOutr.builder().cst("99").vcofins("0.00").vbc("0.00").pcofins("0.00").build()).build()).build()).build()));
        infNFe.setTotal(Nf.InfNFe.Total.builder().icmsTot(Nf.InfNFe.Total.ICMSTot.builder().vbc("0.00").vicms("0.00").vicmsDeson("0.00").vfcp("0.00").vbcst("0.00").vst("0.00").vfcpst("0.00").vfcpstRet("0.00").vProd("70.00").vFrete("0.00").vSeg("0.00").vDesc("0.00").vii("0.00").vipi("0.00").vipiDevol("0.00").vpis("0.00").vcofins("0.00").vOutro("0.00").vnf("70.00").vTotTrib("0.00").build()).build());
        infNFe.setTransp(Nf.InfNFe.Transp.builder().modFrete("9").build());
        infNFe.setPag(Nf.InfNFe.Pag.builder().detPag(Collections.singletonList(Nf.InfNFe.Pag.DetPag.builder().indPag(NFPaymentIndicative.IN_CASH.getCode()).tPag(NFPaymentType.MONEY.getCode()).vPag("70.00").build())).build());
        infNFe.setIde(ide);
        infNFe.setInfRespTec(Nf.InfNFe.TInfRespTec.builder()
                .cnpj("11520224000140")
                .xContato("TARTIGRADO TECNOLOGIA TLDA")
                .email("falecom@tartigrado.com")
                .fone("86988033430")
                .build());
        nfe.setInfNFe(infNFe);

        return nfe;
    }

    private static Nf getNfe(NfConfig config, int number) {
        return getNfe(config, number, Model.NFE);
    }

    private static void cancelarNf(String accessKey, String protocol) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfeConfig config = new PfxNfeConfigImpl(UF.PE, "11520224000140", Environment.PRODUCTION, info, NFEmissionType.NORMAL);

        XMLSignerService signer = new DefaultXmlSigner();
        NfCancelService service = new NfeCancelServiceImpl(config);
        System.out.println(service.cancel(accessKey, protocol, "Quero Cancelar essa nota", "1").getRetEvento().get(0).getInfEvento().getXMotivo());
    }

    private static void cancelarNfc(final String accessKey) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);

        XMLSignerService signer = new DefaultXmlSigner();
        NfCancelService service = new NfceCancelServiceImpl(config);
        System.out.println(service.cancel(accessKey));
    }

    private static void substituteCancelNfc(final String accessKey, final String accessKeyRef) throws Exception {
        KeyStoreInfo info = KeyStoreFactory.getInstance();

        NfceConfig config = new PfxNfceConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, info, NFEmissionType.NORMAL, null, null);

        XMLSignerService signer = new DefaultXmlSigner();
        NfceSubstituteCancelService service = new NfceSubstituteCancelServiceImpl(config);
        System.out.println(service.substituteCancel(accessKey, accessKeyRef));
    }
}

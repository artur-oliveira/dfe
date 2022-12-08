package com.softart.dfe.util.xml.nf;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshaller;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBElement;

import static org.junit.jupiter.api.Assertions.*;

class NfUnmarshallerTest {

    @Test
    void correctionLetterNfe() {
        JAXBElement<TEnvEvento> element = NfUnmarshaller.correctionLetterNfe("<envEvento xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"1.00\"><idLote>383723176816708</idLote><evento versao=\"1.00\"><infEvento Id=\"ID1101102222091152022400014055001000003510174536480611\"><cOrgao>22</cOrgao><tpAmb>2</tpAmb><CNPJ>11520224000140</CNPJ><chNFe>22220911520224000140550010000035101745364806</chNFe><dhEvento>2022-10-07T11:36:18-03:00</dhEvento><tpEvento>110110</tpEvento><nSeqEvento>11</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Carta de Correcao</descEvento><xCorrecao>LOREM IPSUM DOLOR SIT AMET</xCorrecao><xCondUso>A Carta de Correção é disciplinada pelo § 1º-A do art. 7º do Convênio S/N, de 15 de dezembro de 1970 e pode ser utilizada para regularização de erro ocorrido na emissão de documento fiscal, desde que o erro não esteja relacionado com: I - as variáveis que determinam o valor do imposto tais como: base de cálculo, alíquota, diferença de preço, quantidade, valor da operação ou da prestação; II - a correção de dados cadastrais que implique mudança do remetente ou do destinatário; III - a data de emissão ou de saída.</xCondUso></detEvento></infEvento><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#ID1101102222091152022400014055001000003510174536480611\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>gRWwl95l7RgYHcrE59Y0IfglwbI=</DigestValue></Reference></SignedInfo><SignatureValue>tDO0o4IAaODOd9jkI0ew7KZfgWMFztwxEWDmnFIZ7okLTYMUhNH9WPpO8IeA4r08m6mLm1FeVzHF&#13;\n" +
                "TKZ1bijrvHvR2GOCGbVFOOy29ntyH1jx3aBctTyTDCGwwdQcofT/SEpb4amRP6Y07Vepv+OMGqjH&#13;\n" +
                "Q3vD+JVBD7CMfL+1pwDQgGMOdEJ+Fds4ZABv7VSRctClZrIXoAHwp3Tgnd8s3QXUzq30D7Z+87d6&#13;\n" +
                "tmoLHWozxYogp7fwpmoKNnsKzB+SaGhmpgL/w2UCt31vQShM5t2XmPmyWNMwamk9SFmfL2ga0M0c&#13;\n" +
                "e1coBeJEJjKmUXq4UXrepkbDo1H2mpoUxUXVIw==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIHPDCCBSSgAwIBAgIIYiQiBQI7PswwDQYJKoZIhvcNAQELBQAwWTELMAkGA1UEBhMCQlIxEzAR&#13;\n" +
                "BgNVBAoTCklDUC1CcmFzaWwxFTATBgNVBAsTDEFDIFNPTFVUSSB2NTEeMBwGA1UEAxMVQUMgU09M&#13;\n" +
                "VVRJIE11bHRpcGxhIHY1MB4XDTIyMDUwMzE5MDkwMFoXDTIzMDUwMzE5MDkwMFowgeYxCzAJBgNV&#13;\n" +
                "BAYTAkJSMRMwEQYDVQQKEwpJQ1AtQnJhc2lsMQswCQYDVQQIEwJQSTERMA8GA1UEBxMIVGVyZXNp&#13;\n" +
                "bmExHjAcBgNVBAsTFUFDIFNPTFVUSSBNdWx0aXBsYSB2NTEXMBUGA1UECxMOMzM0MTYwNzkwMDAx&#13;\n" +
                "OTUxGTAXBgNVBAsTEFZpZGVvY29uZmVyZW5jaWExGjAYBgNVBAsTEUNlcnRpZmljYWRvIFBKIEEx&#13;\n" +
                "MTIwMAYDVQQDEylUQVJUSUdSQURPIFRFQ05PTE9HSUEgTFREQToxMTUyMDIyNDAwMDE0MDCCASIw&#13;\n" +
                "DQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAPD2wmylr1VxonzmaGqb/YPrlQQkRuM7HbVMCSDX&#13;\n" +
                "2KeD6PO6A0Q61DBZtaThDP9sNlzp3GoQ2IArdNZ74C2IKLmmyS7HOIIgXeKOljijbZKB7D1OtJGH&#13;\n" +
                "2xgfJcGN/OilP4ZDY0c826aVwt8IYbjWTRxYK4PFGcDAl1QiouxrugfLsA5x1LKdVt0ChZQ/xGva&#13;\n" +
                "xZ5tLbMgvd0MH59Pz3X8w2Csgdme5ySpPHN7DAV6OtQDCpdQV8HcvWflSdpgpvtkxqAUzq42BAQ8&#13;\n" +
                "xDDIiJJCaJpMCfAKZeHISBZ7G62aO6Mpz/vYC4NiURbxKdDCh8kfPwvi3/LZxZ+TyWflAwLn8GMC&#13;\n" +
                "AwEAAaOCAngwggJ0MAkGA1UdEwQCMAAwHwYDVR0jBBgwFoAUxVLtJYAJ35yCyJ9Hxt20XzHdubEw&#13;\n" +
                "VAYIKwYBBQUHAQEESDBGMEQGCCsGAQUFBzAChjhodHRwOi8vY2NkLmFjc29sdXRpLmNvbS5ici9s&#13;\n" +
                "Y3IvYWMtc29sdXRpLW11bHRpcGxhLXY1LnA3YjCBswYDVR0RBIGrMIGogRVoaWdvbWF0b3NAaG90&#13;\n" +
                "bWFpbC5jb22gHAYFYEwBAwKgExMRSElHTyBTT0FSRVMgTUFUT1OgGQYFYEwBAwOgEBMOMTE1MjAy&#13;\n" +
                "MjQwMDAxNDCgPQYFYEwBAwSgNBMyMjAxMjE5ODI4ODMzMjgxMDM1MzAwMDAwMDAwMDAwMDAwMDAw&#13;\n" +
                "MDAyMDAxOTEwU1NQUEmgFwYFYEwBAwegDhMMMDAwMDAwMDAwMDAwMF0GA1UdIARWMFQwUgYGYEwB&#13;\n" +
                "AgEmMEgwRgYIKwYBBQUHAgEWOmh0dHA6Ly9jY2QuYWNzb2x1dGkuY29tLmJyL2RvY3MvZHBjLWFj&#13;\n" +
                "LXNvbHV0aS1tdWx0aXBsYS5wZGYwHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMIGMBgNV&#13;\n" +
                "HR8EgYQwgYEwPqA8oDqGOGh0dHA6Ly9jY2QuYWNzb2x1dGkuY29tLmJyL2xjci9hYy1zb2x1dGkt&#13;\n" +
                "bXVsdGlwbGEtdjUuY3JsMD+gPaA7hjlodHRwOi8vY2NkMi5hY3NvbHV0aS5jb20uYnIvbGNyL2Fj&#13;\n" +
                "LXNvbHV0aS1tdWx0aXBsYS12NS5jcmwwHQYDVR0OBBYEFNRfctimy+BtJ2ZAMpSxLWT1U0SzMA4G&#13;\n" +
                "A1UdDwEB/wQEAwIF4DANBgkqhkiG9w0BAQsFAAOCAgEAV253AFOkgG9wYCUoKpRnZqoMNmkEzlnZ&#13;\n" +
                "/MghaBoC7hus3gS+3oWJtm3dvb4haEa0gZrSvhoS97WpRjG/HhrRHEy99HbRl+T7qbfcgrH8iK58&#13;\n" +
                "m+HEYbdpD2BwJNlk5VgbooRKGl7tbYaapqCndvdii++CKW2jf/Fu8pKJaMD7bXF1hIQczUpCQq6y&#13;\n" +
                "3xClDLnHSIRuMdoyGhwbuWKlqD7EpGwxnWKPAgiz5zePhKO0GEHb68g4Q9yPQMmMUUJzsnajD9DZ&#13;\n" +
                "xwifddFajTiaN8etfl9gpmfgaFFCxhF+yhqvh4XE97gMlkN/GjaVQt4Hnt6KjqsmZ/EuiUKyh9vx&#13;\n" +
                "WDXT0Y95szy150JOOeoFec33Kr2D5VBjxDzcbl1ERcvqeYmZI9Ud7ggd3ffl/Vc4HGf01q08jpic&#13;\n" +
                "SJwXYxG5dpLx70fMGLNXmygNRbo+arC0QaKm8MDFXygJvGAM4J1NQkY3sdObsYXG1Cj4arGSfvT2&#13;\n" +
                "7vt6ecfkcDLCBWu2V/snoyABZdhWqd83RFRHe5e09MVCufsRcVxSZjmwZ972GTL5loLFcoSoJIUH&#13;\n" +
                "YZZRnSSU/Rk4hhugF5vZ68GbCx85pg7ogz/TwTZBz3iv12g+oybuung8bbEcNdJjpjCYRVOvdMlH&#13;\n" +
                "xqVK+4gGOKri4+TjA88vC/a6oJUgKPDCgVSD+2+dBDA=</X509Certificate></X509Data></KeyInfo></Signature></evento></envEvento>");

        assertNotNull(element.getValue().getEvento());
        assertNotNull(element.getValue().getEvento().get(0).getInfEvento());
        assertNotNull(element.getValue().getEvento().get(0).getSignature());
        assertNotNull(element.getValue().getEvento().get(0).getSignature().getSignatureValue());

    }
}
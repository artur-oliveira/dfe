package org.dfe.components.internal.nfe;

import org.dfe.enums.internal.UF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QrCodeV2UrlGeneratorTest {

    @Test
    void testGetVersion() {
        assertEquals("2", new QrCodeV2UrlGenerator().getVersion());
    }


    @Test
    void testGetParams() {
        assertEquals("99999999999999999999999999999999999999999999|2|2|1", new QrCodeV2UrlGenerator().getParams(
                "99999999999999999999999999999999999999999999",
                "2",
                "1",
                null,
                null,
                null,
                "1"
        ));

    }

    @Test
    void testGetParamsOffline() {
        assertEquals("99999999999999999999999999999999999999999999|2|2|01|0.00|5a506170536b6b772b61715067784d5277363031724659557433513d|1", new QrCodeV2UrlGenerator().getParams(
                "99999999999999999999999999999999999999999999",
                "2",
                "9",
                "2022-01-01T00:00:00-03:00",
                "0.00",
                new byte[]{100, -10, -87, 74, 73, 48, -7, -86, -113, -125, 19, 17, -61, -83, 53, -84, 86, 20, -73, 116},
                "1"
        ));
    }

    @Test
    public void testGenerateAcProd() throws Exception {
        assertEquals("http://www.sefaznet.ac.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AC").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateAlProd() throws Exception {
        assertEquals("http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AL").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateApProd() throws Exception {
        assertEquals("https://www.sefaz.ap.gov.br/nfce/nfcep.php?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AP").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateAmProd() throws Exception {
        assertEquals("https://sistemas.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AM").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateBaProd() throws Exception {
        assertEquals("http://nfe.sefaz.ba.gov.br/servicos/nfce/qrcode.aspx?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("BA").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateDfProd() throws Exception {
        assertEquals("http://www.fazenda.df.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("DF").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateEsProd() throws Exception {
        assertEquals("http://app.sefaz.es.gov.br/ConsultaNFCe/?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("ES").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateGoProd() throws Exception {
        assertEquals("http://nfe.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("GO").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateMaProd() throws Exception {
        assertEquals("nfce.sefaz.ma.gov.br/portal/consultarNFCe.jsp?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MA").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateMtProd() throws Exception {
        assertEquals("http://www.sefaz.mt.gov.br/nfce/consultanfce?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MT").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateMsProd() throws Exception {
        assertEquals("http://www.dfe.ms.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MS").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateMgProd() throws Exception {
        assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MG").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGeneratePaProd() throws Exception {
        assertEquals("https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/nfceForm.seam?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PA").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGeneratePbProd() throws Exception {
        assertEquals("http://www.sefaz.pb.gov.br/nfce?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PB").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGeneratePrProd() throws Exception {
        assertEquals("http://www.fazenda.pr.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PR").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGeneratePeProd() throws Exception {
        assertEquals("http://nfce.sefaz.pe.gov.br/nfce/consulta?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PE").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGeneratePiProd() throws Exception {
        assertEquals("http://www.sefaz.pi.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PI").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateRjProd() throws Exception {
        assertEquals("http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RJ").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateRnProd() throws Exception {
        assertEquals("http://nfce.set.rn.gov.br/consultarNFCe.aspx?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RN").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateRsProd() throws Exception {
        assertEquals("https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RS").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateRoProd() throws Exception {
        assertEquals("http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RO").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateRrProd() throws Exception {
        assertEquals("https://www.sefaz.rr.gov.br/nfce/servlet/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RR").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateScProd() throws Exception {
        assertEquals("https://sat.sef.sc.gov.br/nfce/consulta?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("SC").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateSpProd() throws Exception {
        assertEquals("https://www.nfce.fazenda.sp.gov.br/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("SP").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateSeProd() throws Exception {
        assertEquals("http://www.nfce.se.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("SE").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    public void testGenerateToProd() throws Exception {
        assertEquals("http://www.sefaz.to.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|1|1|C6536E73BCE16DA57234BD0EF9CF1D9BE21CF69D",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("TO").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "1",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateAcHom() throws Exception {
        assertEquals("http://www.hml.sefaznet.ac.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AC").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateAlHom() throws Exception {
        assertEquals("http://nfce.sefaz.al.gov.br/QRCode/consultarNFCe.jsp?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AL").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateApHom() throws Exception {
        assertEquals("https://www.sefaz.ap.gov.br/nfcehml/nfce.php?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AP").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateAmHom() throws Exception {
        assertEquals("https://sistemas.sefaz.am.gov.br/nfceweb-hom/consultarNFCe.jsp?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("AM").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateBaHom() throws Exception {
        assertEquals("http://hnfe.sefaz.ba.gov.br/servicos/nfce/qrcode.aspx?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("BA").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateDfHom() throws Exception {
        assertEquals("http://www.fazenda.df.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("DF").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateEsHom() throws Exception {
        assertEquals("http://homologacao.sefaz.es.gov.br/ConsultaNFCe?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("ES").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateGoHom() throws Exception {
        assertEquals("http://homolog.sefaz.go.gov.br/nfeweb/sites/nfce/danfeNFCe?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("GO").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateMaHom() throws Exception {
        assertEquals("homologacao.sefaz.ma.gov.br/portal/consultarNFCe.jsp?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MA").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateMtHom() throws Exception {
        assertEquals("http://homologacao.sefaz.mt.gov.br/nfce/consultanfce?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MT").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateMsHom() throws Exception {
        assertEquals("http://www.dfe.ms.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MS").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateMgHom() throws Exception {
        assertEquals("https://portalsped.fazenda.mg.gov.br/portalnfce/sistema/qrcode.xhtml?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("MG").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGeneratePaHom() throws Exception {
        assertEquals("https://appnfc.sefa.pa.gov.br/portal-homologacao/view/consultas/nfce/nfceForm.seam?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PA").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGeneratePbHom() throws Exception {
        assertEquals("http://www.sefaz.pb.gov.br/nfcehom?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PB").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGeneratePrHom() throws Exception {
        assertEquals("http://www.fazenda.pr.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PR").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGeneratePeHom() throws Exception {
        assertEquals("http://nfcehomolog.sefaz.pe.gov.br/nfce/consulta?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PE").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGeneratePiHom() throws Exception {
        assertEquals("http://www.sefaz.pi.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("PI").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateRjHom() throws Exception {
        assertEquals("http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RJ").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateRnHom() throws Exception {
        assertEquals("http://hom.nfce.set.rn.gov.br/consultarNFCe.aspx?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RN").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateRsHom() throws Exception {
        assertEquals("https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RS").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateRoHom() throws Exception {
        assertEquals("http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RO").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateRrHom() throws Exception {
        assertEquals("http://200.174.88.103:8080/nfce/servlet/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("RR").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateScHom() throws Exception {
        assertEquals("https://hom.sat.sef.sc.gov.br/nfce/consulta?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("SC").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateSpHom() throws Exception {
        assertEquals("https://www.homologacao.nfce.fazenda.sp.gov.br/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("SP").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateSeHom() throws Exception {
        assertEquals("http://www.hom.nfe.se.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("SE").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }

    @Test
    void testGenerateToHom() throws Exception {
        assertEquals("http://homologacao.sefaz.to.gov.br/nfce/qrcode?p=99999999999999999999999999999999999999999999|2|2|1|4702544D418BC2078B1D10DB34A1EC239C1DA2E3",
                new QrCodeV2UrlGenerator().generate(
                        UF.valueOfCode("TO").getCode(),
                        "99999999999999999999999999999999999999999999",
                        "2",
                        "1",
                        null,
                        null,
                        null,
                        "1",
                        "99999999999999999999"
                ));
    }
}
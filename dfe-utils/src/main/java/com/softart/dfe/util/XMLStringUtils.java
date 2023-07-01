package com.softart.dfe.util;

import java.util.Arrays;
import java.util.Collection;

public final class XMLStringUtils {
    public static final String ID_ATTRIBUTE = "Id";
    public static final String ID_PREFIX = "ID";
    public static final String ID_NFE_PREFIX = "NFe";
    public static final String ID_CTE_PREFIX = "CTe";
    public static final String ID_MDFE_PREFIX = "MDFe";
    private static final int MAX_NAMESPACE_REPLACING = 3;
    private static final String SIGNATURE_PREFIX = "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">";
    private static final Collection<String> DFE_NAMESPACES = Arrays.asList("http://www.portalfiscal.inf.br/nfe", "http://www.portalfiscal.inf.br/cte", "http://www.portalfiscal.inf.br/mdfe");
    private static final Collection<String> CURRENT_NAMESPACES = Arrays.asList("http://www.portalfiscal.inf.br/nfe", "http://www.portalfiscal.inf.br/cte", "http://www.portalfiscal.inf.br/mdfe", "http://www.w3.org/2000/09/xmldsig#");

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `XMLStringUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private XMLStringUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * It removes all the namespaces prefixes from the XML string
     *
     * @param str the string to be cleaned
     * @return The string with the namespaces removed.
     */
    public static String cleanNamespace(String str) {
        for (int i = 1; i <= MAX_NAMESPACE_REPLACING; i++) {
            for (String ns : DFE_NAMESPACES) {
                str = str.replace(String.format(" xmlns=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:ns%d=\"%s\"", i, ns), String.format(" xmlns=\"%s\"", ns));
            }
        }
        for (int i = 1; i <= MAX_NAMESPACE_REPLACING; i++) {
            for (String ns : CURRENT_NAMESPACES) {
                str = str.replace(String.format(" xmlns:ns%d=\"%s\"", i, ns), StringUtils.empty());
            }
            str = str.replace(String.format("<ns%d:Signature>", i), XMLStringUtils.SIGNATURE_PREFIX);
            str = str.replace(String.format("ns%d:", i), StringUtils.empty());
        }
        return str.replace("<Signature>", "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">");
    }

    /**
     * It takes an eventId, an accessKey, and a sequenceNumber, and returns a string that is the concatenation of the
     * eventId, the accessKey, and the sequenceNumber, with a prefix of "ID_PREFIX"
     *
     * @param eventId        The event ID of the event you want to get the ID for.
     * @param accessKey      This is the access key that you use to access the API.
     * @param sequenceNumber This is the sequence number of the event. It is a 2-digit number.
     * @return The id of the event.
     */
    public static String idEvento(String eventId, String accessKey, String sequenceNumber) {
        return ID_PREFIX + eventId + accessKey + StringUtils.padZeroStart(sequenceNumber, 2);
    }
    public static String idEventoCte400(String eventId, String accessKey, String sequenceNumber) {
        return ID_PREFIX + eventId + accessKey + StringUtils.padZeroStart(sequenceNumber, 3);
    }

    /**
     * It takes the parameters and concatenates them in a specific order, padding the serie and start/end numbers with
     * zeros
     *
     * @param uf    The state code (2 characters)
     * @param year  the year of the invoice
     * @param cnpj  CNPJ of the company
     * @param model The model of the document, which is always 02 for the cancellation of the NF-e.
     * @param serie The series of the NFe.
     * @param start The first number of the range of invoices to be canceled.
     * @param end   The last number of the range of invoices to be canceled.
     * @return A string with the following format:
     */
    public static String idNfeInut(String uf, String year, String cnpj, String model, String serie, String start, String end) {
        return ID_PREFIX + uf + year + cnpj + model + StringUtils.padZeroStart(serie, 3) + StringUtils.padZeroStart(start, 9) + StringUtils.padZeroStart(end, 9);
    }


    /**
     * It takes the UF, CNPJ, model, serie, start and end numbers and returns a string with the ID of the Inutilization
     *
     * @param uf    The state code.
     * @param cnpj  CNPJ of the company
     * @param model The model of the document. For example, for an invoice, it's 55.
     * @param serie The number of the series of the document.
     * @param start The first number of the invoice range
     * @param end   The last number of the invoice range.
     * @return A string with the following format:
     * ID_PREFIX + uf + cnpj + model + StringUtils.padZeroStart(serie, 3) + StringUtils.padZeroStart(start, 9) +
     * StringUtils.padZeroStart(end, 9);
     */
    public static String idCteInut(String uf, String cnpj, String model, String serie, String start, String end) {
        return ID_PREFIX + uf + cnpj + model + StringUtils.padZeroStart(serie, 3) + StringUtils.padZeroStart(start, 9) + StringUtils.padZeroStart(end, 9);
    }

    /**
     * It takes a bunch of strings, joins them together, and returns the result
     *
     * @param uf          The state code (2 digits)
     * @param year        year of emission
     * @param month       2 digits
     * @param cnpj        CNPJ of the company that issued the invoice
     * @param model       01, 55, 65, etc.
     * @param serie       The serie of the document.
     * @param number      The number of the document
     * @param emissonType 1 = Normal, 2 = Contingency, 3 = Off-line
     * @param code        The code of the product.
     * @param digit       The last digit of the barcode
     * @return A string with the following format:
     * ```
     * ID_NFE_PREFIX + uf + year + month + cnpj + model + serie + number + emissonType + code + digit
     * ```
     */
    public static String idNf(String uf, String year, String month, String cnpj, String model, String serie, String number, String emissonType, String code, String digit) {
        return String.join("", ID_NFE_PREFIX, uf, year, month, cnpj, model, StringUtils.padZeroStart(serie, 3), StringUtils.padZeroStart(number, 9), emissonType, code, digit);
    }

    /**
     * It generates a CTe ID.
     *
     * @param uf          The state code of the sender.
     * @param year        The year of the emission of the document.
     * @param month       2 digits
     * @param cnpj        CNPJ of the company
     * @param model       Model of the document.
     * @param serie       The serie of the document.
     * @param number      The number of the document
     * @param emissonType 1 - Normal, 2 - Contingency, 3 - SCAN, 4 - DPEC, 5 - Contingency, SCAN
     * @param code        The code of the state where the document was issued.
     * @param digit       The last digit of the CTe number
     * @return A string with the following format:
     */
    public static String idCte(String uf, String year, String month, String cnpj, String model, String serie, String number, String emissonType, String code, String digit) {
        return String.join("", ID_CTE_PREFIX, uf, year, month, cnpj, model, StringUtils.padZeroStart(serie, 3), StringUtils.padZeroStart(number, 9), emissonType, code, digit);
    }

    /**
     * It generates a unique ID for a MDF-e.
     *
     * @param uf          State code
     * @param year        year of emission
     * @param month       2 digits
     * @param cnpj        CNPJ of the company that issued the MDFe
     * @param model       55
     * @param serie       The serie of the MDF-e.
     * @param number      The number of the MDF-e
     * @param emissonType 1 - Normal, 2 - Contingency, 3 - Off-line
     * @param code        The code of the issuer of the document.
     * @param digit       Check digit
     * @return A string with the following format:
     * ```
     * ID_MDFE_PREFIX + uf + year + month + cnpj + model + serie + number + emissonType + code + digit
     * ```
     */
    public static String idMdfe(String uf, String year, String month, String cnpj, String model, String serie, String number, String emissonType, String code, String digit) {
        return String.join("", ID_MDFE_PREFIX, uf, year, month, cnpj, model, StringUtils.padZeroStart(serie, 3), StringUtils.padZeroStart(number, 9), emissonType, code, digit);
    }
}

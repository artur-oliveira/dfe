package com.softart.dfe.components.internal;

import com.softart.dfe.exceptions.internal.AccessKeyGeneratorException;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.DfeOptional;
import com.softart.dfe.util.StringUtils;

import java.util.Objects;

public final class AccessKeyGenerator {

    /**
     * This Java function returns a concatenated string of various input parameters.
     *
     * @param uf           The abbreviation for the Brazilian state where the document was issued (e.g. SP for São Paulo, RJ for Rio
     *                     de Janeiro, etc.).
     * @param emission     It is a date string representing the emission date of a document in the format "yyyy-MM-dd".
     * @param cnpj         The "cnpj" parameter is a String representing the CNPJ (Cadastro Nacional da Pessoa Jurídica) of a
     *                     company, which is a unique identification number assigned to Brazilian legal entities.
     * @param model        The "model" parameter in this method is likely referring to the model of the fiscal document being
     *                     generated or processed. This could be a specific type of invoice, receipt, or other type of document that is used
     *                     for tax or financial purposes. The exact meaning and format of the "model" parameter may
     * @param serie        The "serie" parameter is a String representing the series of the document being generated. It is
     *                     expected to have a length of 3 characters and be left-padded with zeros if necessary.
     * @param number       The "number" parameter is a String representing the invoice number, with a maximum length of 9 digits.
     *                     It is being left-padded with zeros to ensure a fixed length of 9 characters.
     * @param emissionType The parameter "emissionType" is a String that represents the type of emission of a document,
     *                     such as "1" for "Normal", "2" for "Contingency", "3" for "SCAN", etc.
     * @param code         The "code" parameter is not defined in the given code snippet. It is likely a specific code or
     *                     identifier related to the document being processed.
     * @return A concatenated string of the input parameters, with some of them being formatted or padded with zeros.
     */
    static String accessKeyWithoutDV(String uf, String emission, String cnpj, String model, String serie, String number, String emissionType, String code) {
        return String.join(
                "",
                DfeOptional.ofLength(uf, 2).orElseThrow(() -> new AccessKeyGeneratorException("UF da chave de acesso inválida: " + uf)),
                DateUtils.yyMM(emission),
                StringUtils.padZeroStart(DfeOptional.ofLengthIn(cnpj, 14, 11).orElseThrow(() -> new AccessKeyGeneratorException("CNPJ da chave de acesso inválida: " + cnpj)), 14),
                DfeOptional.ofCondition(Objects.nonNull(model) && model.length() == 2, uf).orElseThrow(() -> new AccessKeyGeneratorException("Modelo da chave de acesso inválida: " + model)),
                StringUtils.padZeroStart(DfeOptional.ofLengthGte(serie, 1).orElseThrow(() -> new AccessKeyGeneratorException("Série da chave de acesso inválida: " + serie)), 3),
                StringUtils.padZeroStart(DfeOptional.ofLengthGte(number, 1).orElseThrow(() -> new AccessKeyGeneratorException("Número da chave de acesso inválida: " + number)), 9),
                DfeOptional.ofLengthEq(emissionType, 1).orElseThrow(() -> new AccessKeyGeneratorException("Tipo de emissão da chave de acesso inválido " + emissionType)),
                DfeOptional.ofLength(code, 8).orElseThrow(() -> new AccessKeyGeneratorException("Código da chave de acesso inválido: " + code))
        );
    }

    /**
     * The function generates an access key by concatenating the result of accessKeyWithoutDV and digit methods.
     *
     * @param uf           The abbreviation of the Brazilian state where the document was issued (e.g. SP for São Paulo, RJ for Rio
     *                     de Janeiro, etc.).
     * @param emission     It is a string representing the date of issuance of the document in the format "yyyy-MM-dd".
     * @param cnpj         The "cnpj" parameter is a String representing the CNPJ (Cadastro Nacional da Pessoa Jurídica) of a
     *                     company. It is a unique identification number assigned to Brazilian legal entities by the Brazilian Federal Revenue
     *                     Service.
     * @param model        The "model" parameter in the "accessKey" method is likely referring to the model of the electronic
     *                     document being generated. In Brazil, this parameter is commonly used in the generation of NF-e (Nota Fiscal
     *                     Eletrônica) and NFC-e (Nota Fiscal de Consumidor Eletrônica
     * @param serie        The "serie" parameter is a String representing the series of the document being generated. In Brazil,
     *                     this is commonly used for invoices, and it is a sequential number that identifies a specific set of invoices issued
     *                     by a company.
     * @param number       The "number" parameter in the "accessKey" method is a String representing the invoice or document
     *                     number. It is used as one of the inputs to generate the access key for the document.
     * @param emissionType The parameter "emissionType" is a String that represents the type of emission of a document,
     *                     such as "1" for "Normal", "2" for "Complementary", "3" for "Adjustment", etc. This parameter is used in the
     *                     generation of an access key for electronic
     * @param code         The "code" parameter in the "accessKey" method is a string representing the verification code of the
     *                     electronic fiscal document. This code is generated by the tax authority and is used to validate the authenticity of
     *                     the document.
     * @return The method `accessKey` returns a string that represents the access key for a Brazilian electronic invoice
     * (NF-e), which is composed of several pieces of information such as the state (UF), emission date, CNPJ of the
     * issuer, model, series, number, emission type, and a verification code. The access key is generated by concatenating
     * the access key without the verification digit and the verification digit
     */
    public static String accessKey(String uf, String emission, String cnpj, String model, String serie, String number, String emissionType, String code) {
        return String.join("", AccessKeyGenerator.accessKeyWithoutDV(uf, emission, cnpj, model, serie, number, emissionType, code), AccessKeyGenerator.digit(uf, emission, cnpj, model, serie, number, emissionType, code));
    }

    /**
     * This Java function generates a digit for an access key based on several input parameters.
     *
     * @param uf           The two-letter abbreviation of the Brazilian state where the invoice was issued.
     * @param emission     The date of emission of the document in the format "yyyy-MM-dd".
     * @param cnpj         It is a parameter that represents the CNPJ (Cadastro Nacional da Pessoa Jurídica) of the company issuing
     *                     the document.
     * @param model        The model parameter is a String representing the model of the document, such as "55" for NF-e (Nota
     *                     Fiscal Eletrônica) or "65" for NFC-e (Nota Fiscal de Consumidor Eletrônica).
     * @param serie        The "serie" parameter is a String representing the series of the document. In Brazil, some documents,
     *                     such as invoices, have a series assigned to them to differentiate them from each other.
     * @param number       The parameter "number" is a String representing the invoice or document number.
     * @param emissionType The parameter "emissionType" is a String that represents the type of emission of a document,
     *                     such as "1" for "Normal", "2" for "Complementary", "3" for "Adjustment", etc.
     * @param code         The "code" parameter is a string representing the verification code of the access key. It is used to
     *                     calculate the last digit of the access key.
     * @return The method is returning a String value representing the calculated digit for a given set of parameters.
     */
    public static String digit(String uf, String emission, String cnpj, String model, String serie, String number, String emissionType, String code) {
        final char[] values = AccessKeyGenerator.accessKeyWithoutDV(uf, emission, cnpj, model, serie, number, emissionType, code).toCharArray();
        final int[] intValues = {2, 3, 4, 5, 6, 7, 8, 9};
        int index = 0;
        int sum = 0;
        int tempValue;
        int tempMult;
        for (int i = values.length; i > 0; i--) {
            if (index >= intValues.length) {
                index = 0;
            }

            tempValue = Integer.parseInt(String.valueOf(values[i - 1]));
            tempMult = intValues[index++];
            sum += tempValue * tempMult;
        }
        final int dv = 11 - (sum % 11);
        return ((dv == 11) || (dv == 10)) ? String.valueOf(0) : String.valueOf(dv);
    }
}

package com.softart.dfe.components.internal;

import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.StringUtils;

public final class AccessKeyGenerator {

    private static String accessKeyWithoutDV(String uf, String emission, String cnpj, String model, String serie, String number, String emissionType, String code) {
        return String.join(
                "",
                uf,
                DateUtils.yyMM(emission),
                cnpj,
                model,
                StringUtils.padZeroStart(serie, 3),
                StringUtils.padZeroStart(number, 9),
                emissionType,
                code
        );
    }

    public static String accessKey(String uf, String emission, String cnpj, String model, String serie, String number, String emissionType, String code) {
        return String.join("", AccessKeyGenerator.accessKeyWithoutDV(uf, emission, cnpj, model, serie, number, emissionType, code), AccessKeyGenerator.digit(uf, emission, cnpj, model, serie, number, emissionType, code));
    }

    public static String digit(String uf, String emission, String cnpj, String model, String serie, String number, String emissionType, String code) {
        final char[] valores = AccessKeyGenerator.accessKeyWithoutDV(uf, emission, cnpj, model, serie, number, emissionType, code).toCharArray();
        final int[] valoresInt = {2, 3, 4, 5, 6, 7, 8, 9};
        int indice = 0;
        int soma = 0;
        int valorTemp;
        int multTemp;
        for (int i = valores.length; i > 0; i--) {
            if (indice >= valoresInt.length) {
                indice = 0;
            }

            valorTemp = Integer.parseInt(String.valueOf(valores[i - 1]));
            multTemp = valoresInt[indice++];
            soma += valorTemp * multTemp;
        }
        final int dv = 11 - (soma % 11);
        return ((dv == 11) || (dv == 10)) ? String.valueOf(0) : String.valueOf(dv);
    }
}

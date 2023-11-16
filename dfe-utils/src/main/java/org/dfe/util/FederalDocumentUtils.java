package org.dfe.util;


import org.dfe.exceptions.FederalDocumentUtilsException;

public final class FederalDocumentUtils {
    private FederalDocumentUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * This function checks if a given CNPJ (Brazilian company registration number) is valid.
     *
     * @param cnpj The parameter "cnpj" is a string representing a CNPJ (Cadastro Nacional de Pessoa Jurídica), which is a
     *             unique identifier for Brazilian companies. The method "isValidCnpj" checks if the given CNPJ is valid according to
     *             the algorithm specified in the code.
     * @return The method is returning a boolean value indicating whether the given CNPJ (Brazilian company registration
     * number) is valid or not.
     */
    public static boolean isValidCnpj(String cnpj) {
        String finalCnpj = DfeOptional.ofLength(StringUtils.extractDigits(cnpj), 14).orElseThrow(() -> new FederalDocumentUtilsException("cnpj inválido: " + cnpj));

        int i;
        int j;
        int k;
        int sum;
        int digVal;
        StringBuilder dig = new StringBuilder();
        String digmon = finalCnpj.substring(12, 14);
        finalCnpj = finalCnpj.substring(0, 12);
        j = 1;
        StringBuilder cnpjBuilder = new StringBuilder(finalCnpj);
        while (j <= 2) {
            k = 2;
            sum = 0;
            i = cnpjBuilder.length();
            while (i >= 1) {
                sum = sum + Integer.parseInt(cnpjBuilder.substring(i - 1, i)) * k;
                k = k + 1;
                if (k > 9) {
                    k = 2;
                }
                i = i - 1;
            }
            digVal = 11 - sum % 11;
            if (digVal >= 10) {
                digVal = 0;
            }
            cnpjBuilder.append(digVal);
            dig.append(digVal);
            j = j + 1;
        }
        return Integer.parseInt(dig.toString()) == Integer.parseInt(digmon);
    }

    /**
     * This Java function checks if a given CPF (Brazilian individual taxpayer registry identification) number is valid.
     *
     * @param cpf The parameter "cpf" is a String representing a Brazilian CPF (Cadastro de Pessoas Físicas), which is a
     *            unique identification number assigned to Brazilian citizens and residents. The method "isValidCpf" checks if the
     *            given CPF is valid according to the Brazilian government's rules and returns a boolean
     * @return The method is returning a boolean value indicating whether the given CPF (Brazilian individual taxpayer
     * registry identification) is valid or not.
     */
    public static boolean isValidCpf(String cpf) {
        String finalCpf = DfeOptional.ofRange(StringUtils.extractDigits(cpf), 11, 14).orElseThrow(() -> new FederalDocumentUtilsException("cpf inválido: " + cpf));

        if (finalCpf.length() == 14 && finalCpf.startsWith("000")) finalCpf = finalCpf.substring(3);

        if (finalCpf.length() != 11 || finalCpf.chars().distinct().count() == 1) return false;

        int i;
        int j;
        int k;
        int sum;
        int digit;

        StringBuilder dig = new StringBuilder();
        String digmon = finalCpf.substring(9, 11);
        finalCpf = finalCpf.substring(0, 9);
        j = 1;
        StringBuilder cpfBuilder = new StringBuilder(finalCpf);
        while (j <= 2) {
            k = 2;
            sum = 0;
            i = cpfBuilder.length();
            while (i >= 1) {
                sum = sum + Integer.parseInt(cpfBuilder.substring(i - 1, i)) * k;
                k = k + 1;
                i = i - 1;
            }
            digit = 11 - sum % 11;
            if (digit >= 10) {
                digit = 0;
            }
            cpfBuilder.append(digit);
            dig.append(digit);
            j = j + 1;
        }
        return Integer.parseInt(dig.toString()) == Integer.parseInt(digmon);
    }
}

package org.dfe.components.internal.parser;

import org.dfe.enums.internal.Model;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.internal.AccessKeyParserException;
import org.dfe.util.DfeOptional;
import org.dfe.util.FederalDocumentUtils;
import org.dfe.util.StringUtils;

import java.time.YearMonth;

class AccessKeyParserFactoryImpl extends AccessKeyParserFactory {

    private static final int YEAR_OFFSET = 2000;


    public static AccessKeyParserFactoryImpl nfe() {
        return Holder.NFE;
    }

    public static AccessKeyParserFactoryImpl cte() {
        return Holder.CTE;
    }

    public static AccessKeyParserFactoryImpl mdfe() {
        return Holder.MDFE;
    }

    @Override
    public String fromId(String id) {
        return DfeOptional.ofLength(DfeOptional.ofLengthGte(id, 44).orElseThrow(() -> new AccessKeyParserException("chave de acesso inválida: " + id)).replace(idPrefix(), StringUtils.empty()), 44).orElseThrow(() -> new AccessKeyParserException("chave de acesso de tamanho inválido: " + id));
    }

    @Override
    public String idPrefix() {
        return StringUtils.empty();
    }

    public YearMonth yearMonth(String ch) {
        return YearMonth.of(year(ch), month(ch));
    }

    public int month(String ch) {
        return DfeOptional.ofRange(Integer.parseInt(fromId(ch).substring(4, 6)), 1, 12).orElseThrow(() -> new AccessKeyParserException("mês inválido para a chave de acesso: " + ch));
    }

    public int year(String ch) {
        return AccessKeyParserFactoryImpl.YEAR_OFFSET + Integer.parseInt(fromId(ch).substring(2, 4));
    }

    public String cnpj(String ch) {
        return fromId(ch).substring(6, 20);
    }

    public Model model(String ch) {
        return Model.valueOfCode(fromId(ch).substring(20, 22));
    }

    public int serie(String ch) {
        return DfeOptional.ofRange(Integer.parseInt(fromId(ch).substring(22, 25)), 1, 999).orElseThrow(() -> new AccessKeyParserException("série inválida para a chave de acesso: " + ch));
    }

    public int number(String ch) {
        return DfeOptional.ofRange(Integer.parseInt(fromId(ch).substring(25, 34)), 1, 999_999_999).orElseThrow(() -> new AccessKeyParserException("número do documento inválido para a chave de acesso: " + ch));
    }

    public int code(String ch) {
        return DfeOptional.ofRange(Integer.parseInt(fromId(ch).substring(35, 43)), 0, 99999999).orElseThrow(() -> new AccessKeyParserException("código do documento inválido para a chave de acesso: " + ch));
    }

    public int digit(String ch) {
        return DfeOptional.ofRange(Integer.parseInt(fromId(ch).substring(43, 44)), 0, 9).orElseThrow(() -> new AccessKeyParserException("dígito do documento inválido: " + ch));
    }

    public UF uf(String ch) {
        return UF.valueOfCode(fromId(ch).substring(0, 2));
    }

    public String format(String ch) {
        return fromId(ch).replaceAll("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3 $4 $5 $6 $7 $8 $9 $10 $11");
    }

    public String prettyFormat(String ch) {
        if (FederalDocumentUtils.isValidCnpj(cnpj(ch))) {
            return fromId(ch).replaceAll("^(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})(\\d{2})(\\d{3})(\\d{3})(\\d{3})(\\d{3})(\\d)(\\d{8})(\\d)", "$1 $2/$3 $4.$5.$6/$7-$8 $9 $10 $11-$12-$13 $14 $15-$16");
        } else if (FederalDocumentUtils.isValidCpf(cnpj(ch))) {
            return fromId(ch).replaceAll("^(\\d{2})(\\d{2})(\\d{2})(\\d{3})(\\d{3})(\\d{3})(\\d{3})(\\d{2})(\\d{2})(\\d{3})(\\d{3})(\\d{3})(\\d{3})(\\d)(\\d{8})(\\d)", "$1 $2/$3 $5.$6.$7-$8 $9 $10 $11-$12-$13 $14 $15-$16");
        } else {
            throw new AccessKeyParserException("não foi possível formatar a chave de acesso: " + ch);
        }
    }

    static final class Holder {
        final static AccessKeyParserFactoryImpl NFE = new NfAccessKeyParser();
        final static AccessKeyParserFactoryImpl CTE = new CteAccessKeyParser();
        final static AccessKeyParserFactoryImpl MDFE = new MdfeAccessKeyParser();

    }
}

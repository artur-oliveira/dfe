package com.softart.dfe.components.internal.parser;

import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.interfaces.internal.AccessKeyParser;
import com.softart.dfe.util.StringUtils;

import java.time.YearMonth;

public abstract class AccessKeyParserFactory implements AccessKeyParser {

    private static final int YEAR_OFFSET = 2000;

    protected AccessKeyParserFactory() {
    }

    public static AccessKeyParserFactory nfe() {
        return Holder.NFE;
    }

    public static AccessKeyParserFactory cte() {
        return Holder.CTE;
    }

    public static AccessKeyParserFactory mdfe() {
        return Holder.MDFE;
    }

    @Override
    public String fromId(String id) {
        return id.replace(idPrefix(), StringUtils.empty());
    }

    public YearMonth emission(String ch) {
        return YearMonth.of(year(ch), month(ch));
    }

    public int month(String ch) {
        return Integer.parseInt(ch.substring(4, 6));
    }

    public int year(String ch) {
        return AccessKeyParserFactory.YEAR_OFFSET + Integer.parseInt(ch.substring(2, 4));
    }

    public String cnpj(String ch) {
        return ch.substring(6, 20);
    }

    public Model model(String ch) {
        return Model.valueOfCode(ch.substring(20, 22));
    }

    public int serie(String ch) {
        return Integer.parseInt(ch.substring(22, 25));
    }

    public int number(String ch) {
        return Integer.parseInt(ch.substring(25, 34));
    }

    public int code(String ch) {
        return Integer.parseInt(ch.substring(35, 43));
    }

    public int digit(String ch) {
        return Integer.parseInt(ch.substring(43, 44));
    }

    public UF uf(String ch) {
        return UF.valueOfCode(ch.substring(0, 2));
    }

    public String format(String ch) {
        return ch.replaceFirst("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3 $4 $5 $6 $7 $8 $9 $10 $11");
    }

    static final class Holder {
        final static AccessKeyParserFactory NFE = new NfAccessKeyParser();
        final static AccessKeyParserFactory CTE = new CteAccessKeyParser();
        final static AccessKeyParserFactory MDFE = new MdfeAccessKeyParser();

    }
}

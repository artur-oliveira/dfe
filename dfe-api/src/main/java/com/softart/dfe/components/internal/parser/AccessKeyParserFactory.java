package com.softart.dfe.components.internal.parser;

import com.softart.dfe.interfaces.internal.AccessKeyParser;

public abstract class AccessKeyParserFactory implements AccessKeyParser {

    private static final int YEAR_OFFSET = 2000;

    AccessKeyParserFactory() {
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

    static final class Holder {
        final static AccessKeyParserFactory NFE = new NfAccessKeyParser();
        final static AccessKeyParserFactory CTE = new CteAccessKeyParser();
        final static AccessKeyParserFactory MDFE = new MdfeAccessKeyParser();

    }
}

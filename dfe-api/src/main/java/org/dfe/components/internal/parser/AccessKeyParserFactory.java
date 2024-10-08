package org.dfe.components.internal.parser;

import org.dfe.interfaces.internal.AccessKeyParser;

public abstract class AccessKeyParserFactory implements AccessKeyParser {

    AccessKeyParserFactory() {
    }

    public static AccessKeyParserFactory any() {
        return Holder.ANY;
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
        final static AccessKeyParserFactory ANY = new AccessKeyParserFactoryImpl();
        final static AccessKeyParserFactory NFE = new NfAccessKeyParser();
        final static AccessKeyParserFactory CTE = new CteAccessKeyParser();
        final static AccessKeyParserFactory MDFE = new MdfeAccessKeyParser();
    }
}

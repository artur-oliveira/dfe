package com.softart.dfe.components.internal.parser;

import com.softart.dfe.util.XMLStringUtils;

/**
 * The NfAccessKeyParser class extends the AccessKeyParserFactory and provides an idPrefix method that returns a specific
 * prefix.
 */
final class NfAccessKeyParser extends AccessKeyParserFactory {

    NfAccessKeyParser() {
    }

    @Override
    public String idPrefix() {
        return XMLStringUtils.ID_NFE_PREFIX;
    }
}

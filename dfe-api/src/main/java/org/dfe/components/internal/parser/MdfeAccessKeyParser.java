package org.dfe.components.internal.parser;

import org.dfe.util.XMLStringUtils;

/**
 * The MdfeAccessKeyParser class extends the AccessKeyParserFactory and overrides the idPrefix method to return a specific
 * prefix.
 */
final class MdfeAccessKeyParser extends AccessKeyParserFactoryImpl {

    @Override
    public String idPrefix() {
        return XMLStringUtils.ID_MDFE_PREFIX;
    }
}

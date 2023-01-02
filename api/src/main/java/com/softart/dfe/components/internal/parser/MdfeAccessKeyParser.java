package com.softart.dfe.components.internal.parser;

import com.softart.dfe.util.XMLStringUtils;

final class MdfeAccessKeyParser extends AccessKeyParserFactory {

    @Override
    public String idPrefix() {
        return XMLStringUtils.ID_MDFE_PREFIX;
    }
}

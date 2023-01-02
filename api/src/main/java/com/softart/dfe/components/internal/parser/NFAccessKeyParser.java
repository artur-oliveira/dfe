package com.softart.dfe.components.internal.parser;

import com.softart.dfe.util.XMLStringUtils;

final class NFAccessKeyParser extends AccessKeyParserFactory {

    NFAccessKeyParser() {
    }

    @Override
    public String idPrefix() {
        return XMLStringUtils.ID_NFE_PREFIX;
    }
}

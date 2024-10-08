package org.dfe.models.internal.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.exceptions.DfeUncheckedException;
import org.dfe.interfaces.internal.config.*;
import org.dfe.util.DateUtils;
import org.dfe.util.IOUtils;
import org.dfe.util.StringUtils;

import java.util.Objects;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class RootPath {
    private final Config config;
    private final String key;
    private String xmlName;
    private Integer month;
    private Integer year;

    public String getRootString() {
        return "xmls";
    }

    public String getRootEnvironmentString() {
        return getConfig().environment().getRootPath();
    }

    public String getCnpjString() {
        return getConfig().cnpj();
    }

    public String getKeyString() {
        return getKey();
    }

    public String getYearString() {
        if (Objects.nonNull(getXmlName()) && getXmlName().length() == 44) {
            return String.valueOf(AccessKeyParserFactory.any().model(getXmlName()).parser().year(getXmlName()));
        } else if (Objects.nonNull(getYear())) {
            return String.valueOf(getYear());
        }
        return DateUtils.currentyear();
    }

    public String getMonthString() {
        if (Objects.nonNull(getXmlName()) && getXmlName().length() == 44) {
            return StringUtils.padZeroStart(AccessKeyParserFactory.any().model(getXmlName()).parser().month(getXmlName()), 2);
        } else if (Objects.nonNull(getMonth())) {
            return StringUtils.padZeroStart(getMonth(), 2);
        }
        return StringUtils.padZeroStart(DateUtils.currentMonth(), 2);
    }

    public String getRootPath() {
        return String.join(IOUtils.separator(),
                getRootString(),
                getRootEnvironmentString(),
                getCnpjString(),
                getKey(),
                getYearString(),
                getMonthString()
        );
    }
}

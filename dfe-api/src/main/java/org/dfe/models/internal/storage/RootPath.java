package org.dfe.models.internal.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
import org.dfe.exceptions.DfeUncheckedException;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.util.DateUtils;
import org.dfe.util.IOUtils;
import org.dfe.util.StringUtils;

import java.util.*;

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

    String xmlNameWithoutExtension() {
        return Optional.ofNullable(getXmlName()).map(it -> it.replace(".xml", "")).orElse(null);
    }

    public Collection<RootPath> getAllPaths() {
        String xmlName = Optional.ofNullable(xmlNameWithoutExtension()).orElseThrow(() -> new DfeUncheckedException("xmlName is null"));
        String chDFe = Arrays.stream(xmlName.split("-")).filter(it -> it.length() == 44).findFirst().orElse(null);

        if (xmlName.length() == 44 || Objects.isNull(chDFe)) {
            return List.of(this);
        }

        RootPath otherPath = RootPath
                .builder()
                .config(getConfig())
                .key(getKey())
                .xmlName(xmlNameWithoutExtension())
                .month(AccessKeyParserFactory.any().model(chDFe).parser().month(chDFe))
                .year(AccessKeyParserFactory.any().model(chDFe).parser().year(chDFe))
                .build();

        return List.of(this, otherPath);
    }

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
        if (Objects.nonNull(xmlNameWithoutExtension()) && xmlNameWithoutExtension().length() == 44) {
            return String.valueOf(AccessKeyParserFactory.any().model(xmlNameWithoutExtension()).parser().year(xmlNameWithoutExtension()));
        } else if (Objects.nonNull(getYear())) {
            return String.valueOf(getYear());
        }
        return DateUtils.currentyear();
    }

    public String getMonthString() {
        if (Objects.nonNull(xmlNameWithoutExtension()) && xmlNameWithoutExtension().length() == 44) {
            return StringUtils.padZeroStart(AccessKeyParserFactory.any().model(xmlNameWithoutExtension()).parser().month(xmlNameWithoutExtension()), 2);
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

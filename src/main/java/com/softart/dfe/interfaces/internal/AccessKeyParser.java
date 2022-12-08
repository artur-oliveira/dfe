package com.softart.dfe.interfaces.internal;

import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;

import java.time.YearMonth;

public interface AccessKeyParser {
    YearMonth emission(String accessKey);

    String fromId(String id);

    String idPrefix();

    int month(String accessKey);

    int year(String accessKey);

    String cnpj(String accessKey);

    Model model(String accessKey);

    int serie(String accessKey);

    int number(String accessKey);

    int code(String accessKey);

    int digit(String accessKey);

    UF uf(String accessKey);

    String format(String accessKey);
}

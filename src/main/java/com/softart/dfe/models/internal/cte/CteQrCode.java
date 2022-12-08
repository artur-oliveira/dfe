package com.softart.dfe.models.internal.cte;

import com.softart.dfe.interfaces.internal.config.CteConfig;
import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class CteQrCode {
    private Object cte;
    private CteConfig config;
}

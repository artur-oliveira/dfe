package com.softart.dfe.models.internal.cte;

import com.softart.dfe.models.cte.reception_gtve.Gtve;
import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public final class GtveQrCode {
    private Gtve gtve;
}

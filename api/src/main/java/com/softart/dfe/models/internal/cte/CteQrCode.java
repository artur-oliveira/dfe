package com.softart.dfe.models.internal.cte;

import com.softart.dfe.models.cte.reception.Cte;
import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public final class CteQrCode {
    private Cte cte;
}

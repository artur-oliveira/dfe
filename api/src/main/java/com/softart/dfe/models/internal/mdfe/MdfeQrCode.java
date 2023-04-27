package com.softart.dfe.models.internal.mdfe;

import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeQrCode {
    private Mdfe mdfe;
}

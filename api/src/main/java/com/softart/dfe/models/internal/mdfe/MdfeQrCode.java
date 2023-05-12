package com.softart.dfe.models.internal.mdfe;

import com.softart.dfe.models.mdfe.reception_sync.Mdfe;
import lombok.Builder;

@Builder
public record MdfeQrCode(
        Mdfe mdfe
) {
}

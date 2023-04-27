package com.softart.dfe.models.internal.mdfe;

import com.softart.dfe.enums.internal.UF;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public final class RouteLocator {
    public UF start;
    public UF end;
    @Builder.Default
    public boolean includeStartEnd = Boolean.FALSE;
}

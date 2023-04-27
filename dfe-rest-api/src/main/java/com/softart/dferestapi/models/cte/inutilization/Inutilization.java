package com.softart.dferestapi.models.cte.inutilization;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
public final class Inutilization {

    @NotNull
    @Builder.Default
    private Integer ano = Year.now().getValue();
    @Min(0)
    @NotNull
    private Integer serie;
    @NotNull
    @Min(0)
    private Integer nctIni;
    @NotNull
    @Min(0)
    private Integer nctFin;
    @Builder.Default
    @NotNull
    @Size(min = 15, max = 255)
    private String xJust = CteEvent.INUTILIZATION.getDefaultMessage();
    @Builder.Default
    @NotNull
    private Model model = Model.CTE;
    private Environment tpAmb;

    @AssertTrue(message = "model must be CTE or CTE_OS")
    public boolean isCteOrCteOs() {
        return Arrays.asList(Model.CTE, Model.CTE_OS).contains(getModel());
    }
}

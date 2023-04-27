package com.softart.dferestapi.models.nfe.inutilization;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.nf.NFEvent;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;

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
    private Integer nnfIni;
    @NotNull
    @Min(0)
    private Integer nnfFin;
    @Builder.Default
    @NotNull
    @Size(min = 15, max = 255)
    private String xJust = NFEvent.INUTILIZATION.getDefaultMessage();
    private Environment tpAmb;
}

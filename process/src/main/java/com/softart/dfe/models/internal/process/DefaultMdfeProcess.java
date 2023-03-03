package com.softart.dfe.models.internal.process;

import com.softart.dfe.components.process.ProcessFactory;
import com.softart.dfe.components.process.mdfe.MdfeProcessFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;


@Getter
@ToString
@NoArgsConstructor
final class DefaultMdfeProcess extends MdfeProcess {

    private final List<MdfeProcessFactory> processFactories = Arrays.asList(ProcessFactory.fileStorageProcess().mdfe(), ProcessFactory.noStorageProcess().mdfe());

}

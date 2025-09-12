package org.dfe.models.internal.process;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dfe.components.process.ProcessFactory;
import org.dfe.components.process.mdfe.MdfeProcessFactory;

import java.util.Arrays;
import java.util.List;


@Getter
@ToString
@NoArgsConstructor
final class DefaultMdfeProcess extends MdfeProcess {

    private final List<MdfeProcessFactory> processFactories = Arrays.asList(ProcessFactory.fileStorageProcess().mdfe(), ProcessFactory.noStorageProcess().mdfe());

}

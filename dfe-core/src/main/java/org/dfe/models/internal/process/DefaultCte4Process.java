package org.dfe.models.internal.process;

import org.dfe.components.process.ProcessFactory;
import org.dfe.components.process.cte4.Cte4ProcessFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;


@Getter
@ToString
@NoArgsConstructor
final class DefaultCte4Process extends Cte4Process {

    private final List<Cte4ProcessFactory> processFactories = Arrays.asList(ProcessFactory.fileStorageProcess().cte4(), ProcessFactory.noStorageProcess().cte4());

}

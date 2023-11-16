package org.dfe.models.internal.process;

import org.dfe.components.process.ProcessFactory;
import org.dfe.components.process.cte.CteProcessFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;


@Getter
@ToString
@NoArgsConstructor
final class DefaultCteProcess extends CteProcess {

    private final List<CteProcessFactory> processFactories = Arrays.asList(ProcessFactory.fileStorageProcess().cte(), ProcessFactory.noStorageProcess().cte());

}

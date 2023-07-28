package com.softart.dfe.models.internal.process;

import com.softart.dfe.components.process.ProcessFactory;
import com.softart.dfe.components.process.cte.CteProcessFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
final class S3CteProcess extends CteProcess {
    private final List<CteProcessFactory> processFactories = Arrays.asList(ProcessFactory.s3().cte(), ProcessFactory.noStorageProcess().cte());
}

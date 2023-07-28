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
final class S3MdfeProcess extends MdfeProcess {
    private final List<MdfeProcessFactory> processFactories = Arrays.asList(ProcessFactory.s3().mdfe(), ProcessFactory.noStorageProcess().mdfe());
}

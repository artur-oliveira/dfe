package org.dfe.models.internal.process;

import org.dfe.components.process.ProcessFactory;
import org.dfe.components.process.nf.NfProcessFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public final class S3NfProcess extends NfProcess {
    private final List<NfProcessFactory> processFactories = Arrays.asList(ProcessFactory.s3().nf(), ProcessFactory.noStorageProcess().nf());
}

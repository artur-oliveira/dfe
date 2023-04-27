package com.softart.dfe.models.internal.process;

import com.softart.dfe.components.process.nf.NfProcessFactory;
import com.softart.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import com.softart.dfe.components.process.nf.cancel.impl.CancelProcessFactory;
import com.softart.dfe.components.process.nf.correction_letter.impl.CorrectionLetterProcessFactory;
import com.softart.dfe.components.process.nf.distribution.impl.DistributionProcessFactory;
import com.softart.dfe.components.process.nf.epec.impl.EpecProcessFactory;
import com.softart.dfe.components.process.nf.interested_actor.impl.InterestedActorProcessFactory;
import com.softart.dfe.components.process.nf.inut.impl.InutilizationProcessFactory;
import com.softart.dfe.components.process.nf.manifestation.impl.ManifestationProcessFactory;
import com.softart.dfe.components.process.nf.query_gtin.impl.QueryGtinProcessFactory;
import com.softart.dfe.components.process.nf.query_protocol.impl.QueryProtocolProcessFactory;
import com.softart.dfe.components.process.nf.query_register.impl.QueryRegisterProcessFactory;
import com.softart.dfe.components.process.nf.query_status_service.impl.QueryStatusServiceProcessFactory;
import com.softart.dfe.components.process.nf.return_authorization.impl.ReturnAuthorizationProcessFactory;
import com.softart.dfe.components.process.nf.substitute_cancel.impl.SubstituteCancelProcessFactory;
import com.softart.dfe.interfaces.process.nf.NfProcessService;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;
import com.softart.dfe.interfaces.process.nf.distribution.AfterDistribution;
import com.softart.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;
import com.softart.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import com.softart.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import com.softart.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import com.softart.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import com.softart.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import com.softart.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import com.softart.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public abstract class NfProcess implements NfProcessService {

    private static final String DEFAULT = System.getProperty("com.softart.dfe.process.nf", "default");

    public static NfProcess getInstance() {
        switch (DEFAULT) {
            case "s3":
                return HolderS3.INSTANCE;
            case "default":
            default:
                return Holder.INSTANCE;
        }
    }

    public abstract List<NfProcessFactory> getProcessFactories();

    public List<InutilizationProcessFactory> inutilizations() {
        return getProcessFactories().stream().map(NfProcessFactory::inutilization).collect(Collectors.toList());
    }

    public List<CancelProcessFactory> cancels() {
        return getProcessFactories().stream().map(NfProcessFactory::cancel).collect(Collectors.toList());
    }

    public List<AuthorizationProcessFactory> authorizations() {
        return getProcessFactories().stream().map(NfProcessFactory::authorization).collect(Collectors.toList());
    }

    public List<ReturnAuthorizationProcessFactory> returnAuthorizations() {
        return getProcessFactories().stream().map(NfProcessFactory::returnAuthorization).collect(Collectors.toList());
    }

    public List<QueryProtocolProcessFactory> queryProtocols() {
        return getProcessFactories().stream().map(NfProcessFactory::queryProtocol).collect(Collectors.toList());
    }

    public List<DistributionProcessFactory> distributions() {
        return getProcessFactories().stream().map(NfProcessFactory::distribution).collect(Collectors.toList());
    }

    public List<ManifestationProcessFactory> manifestations() {
        return getProcessFactories().stream().map(NfProcessFactory::manifestation).collect(Collectors.toList());
    }

    public List<CorrectionLetterProcessFactory> correctionLetters() {
        return getProcessFactories().stream().map(NfProcessFactory::correctionLetter).collect(Collectors.toList());
    }

    public List<EpecProcessFactory> epecs() {
        return getProcessFactories().stream().map(NfProcessFactory::epec).collect(Collectors.toList());
    }

    public List<InterestedActorProcessFactory> interestedActors() {
        return getProcessFactories().stream().map(NfProcessFactory::interestedActor).collect(Collectors.toList());
    }

    public List<QueryStatusServiceProcessFactory> queryStatusServices() {
        return getProcessFactories().stream().map(NfProcessFactory::queryStatusService).collect(Collectors.toList());
    }

    public List<QueryGtinProcessFactory> queryGtins() {
        return getProcessFactories().stream().map(NfProcessFactory::queryGtin).collect(Collectors.toList());
    }

    public List<SubstituteCancelProcessFactory> substituteCancels() {
        return getProcessFactories().stream().map(NfProcessFactory::substituteCancel).collect(Collectors.toList());
    }

    public List<QueryRegisterProcessFactory> queryRegisters() {
        return getProcessFactories().stream().map(NfProcessFactory::queryRegister).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterInut> afterInutilization() {
        return inutilizations().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeInut> beforeInutilization() {
        return inutilizations().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterCancel> afterCancel() {
        return cancels().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeCancel> beforeCancel() {
        return cancels().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterAuthorization> afterAuthorization() {
        return authorizations().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeAuthorization> beforeAuthorization() {
        return authorizations().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterReturnAuthorization> afterReturnAuthorization() {
        return returnAuthorizations().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeReturnAuthorization> beforeReturnAuthorization() {
        return returnAuthorizations().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQueryProtocol> afterQueryProtocol() {
        return queryProtocols().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQueryProtocol> beforeQueryProtocol() {
        return queryProtocols().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQueryStatusService> afterQueryStatusService() {
        return queryStatusServices().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQueryStatusService> beforeQueryStatusService() {
        return queryStatusServices().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterSubstituteCancel> afterSubstituteCancel() {
        return substituteCancels().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeSubstituteCancel> beforeSubstituteCancel() {
        return substituteCancels().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterDistribution> afterDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeDistribution> beforeDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterManifestation> afterManifestation() {
        return manifestations().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeManifestation> beforeManifestation() {
        return manifestations().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterCorrectionLetter> afterCorrectionLetter() {
        return correctionLetters().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeCorrectionLetter> beforeCorrectionLetter() {
        return correctionLetters().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterEpec> afterEpec() {
        return epecs().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeEpec> beforeEpec() {
        return epecs().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterInterestedActor> afterInterestedActor() {
        return interestedActors().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeInterestedActor> beforeInterestedActor() {
        return interestedActors().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQueryGtin> afterQueryGtin() {
        return queryGtins().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQueryGtin> beforeQueryGtin() {
        return queryGtins().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<AfterQueryRegister> afterQueryRegister() {
        return queryRegisters().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeQueryRegister> beforeQueryRegister() {
        return queryRegisters().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
    }

    static final class HolderS3 {
        final static NfProcess INSTANCE = new S3NfProcess();
    }

    static final class Holder {
        final static NfProcess INSTANCE = new DefaultNfProcess();
    }
}

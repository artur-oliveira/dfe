package com.softart.dfe.components.process.nf;

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

import java.util.Collection;

public abstract class NfProcessFactory implements NfProcessService {

    public static NfProcessFactory noStorageProcess() {
        return NfProcessFactoryHolder.NO_STORAGE_INSTANCE;
    }

    public static NfProcessFactory fileStorageProcess() {
        return NfProcessFactoryHolder.FILE_STORAGE_INSTANCE;
    }

    public static NfProcessFactory s3StorageProcess() {
        return S3NfProcessFactoryHolder.S3_INSTANCE;
    }

    public abstract InutilizationProcessFactory inutilization();

    public abstract CancelProcessFactory cancel();

    public abstract AuthorizationProcessFactory authorization();

    public abstract ReturnAuthorizationProcessFactory returnAuthorization();

    public abstract QueryProtocolProcessFactory queryProtocol();

    public abstract DistributionProcessFactory distribution();

    public abstract ManifestationProcessFactory manifestation();

    public abstract CorrectionLetterProcessFactory correctionLetter();

    public abstract EpecProcessFactory epec();

    public abstract InterestedActorProcessFactory interestedActor();

    public abstract QueryStatusServiceProcessFactory queryStatusService();

    public abstract QueryGtinProcessFactory queryGtin();

    public abstract SubstituteCancelProcessFactory substituteCancel();

    public abstract QueryRegisterProcessFactory queryRegister();

    public Collection<AfterCancel> afterCancel() {
        return cancel().after();
    }

    public Collection<BeforeCancel> beforeCancel() {
        return cancel().before();
    }

    public Collection<AfterAuthorization> afterAuthorization() {
        return authorization().after();
    }

    public Collection<BeforeAuthorization> beforeAuthorization() {
        return authorization().before();
    }

    public Collection<AfterReturnAuthorization> afterReturnAuthorization() {
        return returnAuthorization().after();
    }

    public Collection<BeforeReturnAuthorization> beforeReturnAuthorization() {
        return returnAuthorization().before();
    }

    public Collection<AfterQueryProtocol> afterQueryProtocol() {
        return queryProtocol().after();
    }

    public Collection<BeforeQueryProtocol> beforeQueryProtocol() {
        return queryProtocol().before();
    }

    public Collection<AfterDistribution> afterDistribution() {
        return distribution().after();
    }

    public Collection<BeforeDistribution> beforeDistribution() {
        return distribution().before();
    }

    @Override
    public Collection<AfterInut> afterInutilization() {
        return inutilization().after();
    }

    @Override
    public Collection<BeforeInut> beforeInutilization() {
        return inutilization().before();
    }

    @Override
    public Collection<AfterQueryStatusService> afterQueryStatusService() {
        return queryStatusService().after();
    }

    @Override
    public Collection<BeforeQueryStatusService> beforeQueryStatusService() {
        return queryStatusService().before();
    }

    @Override
    public Collection<AfterManifestation> afterManifestation() {
        return manifestation().after();
    }

    @Override
    public Collection<BeforeManifestation> beforeManifestation() {
        return manifestation().before();
    }

    @Override
    public Collection<AfterCorrectionLetter> afterCorrectionLetter() {
        return correctionLetter().after();
    }

    @Override
    public Collection<BeforeCorrectionLetter> beforeCorrectionLetter() {
        return correctionLetter().before();
    }

    @Override
    public Collection<AfterEpec> afterEpec() {
        return epec().after();
    }

    @Override
    public Collection<BeforeEpec> beforeEpec() {
        return epec().before();
    }

    @Override
    public Collection<AfterInterestedActor> afterInterestedActor() {
        return interestedActor().after();
    }

    @Override
    public Collection<BeforeInterestedActor> beforeInterestedActor() {
        return interestedActor().before();
    }

    @Override
    public Collection<AfterQueryGtin> afterQueryGtin() {
        return queryGtin().after();
    }

    @Override
    public Collection<BeforeQueryGtin> beforeQueryGtin() {
        return queryGtin().before();
    }

    @Override
    public Collection<AfterSubstituteCancel> afterSubstituteCancel() {
        return substituteCancel().after();
    }

    @Override
    public Collection<BeforeSubstituteCancel> beforeSubstituteCancel() {
        return substituteCancel().before();
    }

    @Override
    public Collection<AfterQueryRegister> afterQueryRegister() {
        return queryRegister().after();
    }

    @Override
    public Collection<BeforeQueryRegister> beforeQueryRegister() {
        return queryRegister().before();
    }

    private static final class S3NfProcessFactoryHolder {
        static final NfProcessFactory S3_INSTANCE = new NfS3StorageProcessFactory();
    }

    private static final class NfProcessFactoryHolder {
        static final NfProcessFactory NO_STORAGE_INSTANCE = new NfNoStorageProcessFactory();
        static final NfProcessFactory FILE_STORAGE_INSTANCE = new NfFileStorageProcessFactory();
    }
}

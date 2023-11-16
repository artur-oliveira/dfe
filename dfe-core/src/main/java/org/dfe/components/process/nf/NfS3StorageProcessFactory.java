package org.dfe.components.process.nf;

import org.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import org.dfe.components.process.nf.cancel.impl.CancelProcessFactory;
import org.dfe.components.process.nf.correction_letter.impl.CorrectionLetterProcessFactory;
import org.dfe.components.process.nf.distribution.impl.DistributionProcessFactory;
import org.dfe.components.process.nf.epec.impl.EpecProcessFactory;
import org.dfe.components.process.nf.interested_actor.impl.InterestedActorProcessFactory;
import org.dfe.components.process.nf.inut.impl.InutilizationProcessFactory;
import org.dfe.components.process.nf.manifestation.impl.ManifestationProcessFactory;
import org.dfe.components.process.nf.query_gtin.impl.QueryGtinProcessFactory;
import org.dfe.components.process.nf.query_protocol.impl.QueryProtocolProcessFactory;
import org.dfe.components.process.nf.query_register.impl.QueryRegisterProcessFactory;
import org.dfe.components.process.nf.query_status_service.impl.QueryStatusServiceProcessFactory;
import org.dfe.components.process.nf.return_authorization.impl.ReturnAuthorizationProcessFactory;
import org.dfe.components.process.nf.substitute_cancel.impl.SubstituteCancelProcessFactory;

@SuppressWarnings("unused")
final class NfS3StorageProcessFactory extends NfProcessFactory {

    @Override
    public InutilizationProcessFactory inutilization() {
        return Holder.INUTILIZATION;
    }

    @Override
    public CancelProcessFactory cancel() {
        return Holder.CANCEL;
    }

    @Override
    public AuthorizationProcessFactory authorization() {
        return Holder.AUTHORIZATION;
    }

    @Override
    public ReturnAuthorizationProcessFactory returnAuthorization() {
        return Holder.RETURNAUTHORIZATION;
    }

    @Override
    public QueryProtocolProcessFactory queryProtocol() {
        return Holder.QUERYPROTOCOL;
    }

    @Override
    public DistributionProcessFactory distribution() {
        return Holder.DISTRIBUTION;
    }

    @Override
    public ManifestationProcessFactory manifestation() {
        return Holder.MANIFESTATION;
    }

    @Override
    public QueryStatusServiceProcessFactory queryStatusService() {
        return Holder.QUERYSTATUSSERVICE;
    }

    @Override
    public CorrectionLetterProcessFactory correctionLetter() {
        return Holder.CORRECTIONLETTER;
    }

    @Override
    public EpecProcessFactory epec() {
        return Holder.EPEC;
    }

    @Override
    public InterestedActorProcessFactory interestedActor() {
        return Holder.INTERESTEDACTOR;
    }

    @Override
    public QueryGtinProcessFactory queryGtin() {
        return Holder.QUERYGTIN;
    }

    @Override
    public QueryRegisterProcessFactory queryRegister() {
        return Holder.QUERYREGISTER;
    }

    @Override
    public SubstituteCancelProcessFactory substituteCancel() {
        return Holder.SUBSTITUTECANCEL;
    }

    static final class Holder {
        static final InutilizationProcessFactory INUTILIZATION = InutilizationProcessFactory.s3();
        static final CancelProcessFactory CANCEL = CancelProcessFactory.s3();
        static final AuthorizationProcessFactory AUTHORIZATION = AuthorizationProcessFactory.s3();
        static final ReturnAuthorizationProcessFactory RETURNAUTHORIZATION = ReturnAuthorizationProcessFactory.s3();
        static final QueryProtocolProcessFactory QUERYPROTOCOL = QueryProtocolProcessFactory.s3();
        static final DistributionProcessFactory DISTRIBUTION = DistributionProcessFactory.s3();
        static final ManifestationProcessFactory MANIFESTATION = ManifestationProcessFactory.s3();
        static final QueryStatusServiceProcessFactory QUERYSTATUSSERVICE = QueryStatusServiceProcessFactory.s3();
        static final CorrectionLetterProcessFactory CORRECTIONLETTER = CorrectionLetterProcessFactory.s3();
        static final EpecProcessFactory EPEC = EpecProcessFactory.s3();
        static final InterestedActorProcessFactory INTERESTEDACTOR = InterestedActorProcessFactory.s3();
        static final QueryGtinProcessFactory QUERYGTIN = QueryGtinProcessFactory.s3();
        static final QueryRegisterProcessFactory QUERYREGISTER = QueryRegisterProcessFactory.s3();
        static final SubstituteCancelProcessFactory SUBSTITUTECANCEL = SubstituteCancelProcessFactory.s3();
    }
}

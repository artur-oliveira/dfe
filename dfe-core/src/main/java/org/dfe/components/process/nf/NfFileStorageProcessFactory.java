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

final class NfFileStorageProcessFactory extends NfProcessFactory {

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
        static final InutilizationProcessFactory INUTILIZATION = InutilizationProcessFactory.fileStore();
        static final CancelProcessFactory CANCEL = CancelProcessFactory.fileStore();
        static final AuthorizationProcessFactory AUTHORIZATION = AuthorizationProcessFactory.fileStore();
        static final ReturnAuthorizationProcessFactory RETURNAUTHORIZATION = ReturnAuthorizationProcessFactory.fileStore();
        static final QueryProtocolProcessFactory QUERYPROTOCOL = QueryProtocolProcessFactory.fileStore();
        static final DistributionProcessFactory DISTRIBUTION = DistributionProcessFactory.fileStore();
        static final ManifestationProcessFactory MANIFESTATION = ManifestationProcessFactory.fileStore();
        static final QueryStatusServiceProcessFactory QUERYSTATUSSERVICE = QueryStatusServiceProcessFactory.fileStore();
        static final CorrectionLetterProcessFactory CORRECTIONLETTER = CorrectionLetterProcessFactory.fileStore();
        static final EpecProcessFactory EPEC = EpecProcessFactory.fileStore();
        static final InterestedActorProcessFactory INTERESTEDACTOR = InterestedActorProcessFactory.fileStore();
        static final QueryGtinProcessFactory QUERYGTIN = QueryGtinProcessFactory.fileStore();
        static final QueryRegisterProcessFactory QUERYREGISTER = QueryRegisterProcessFactory.fileStore();
        static final SubstituteCancelProcessFactory SUBSTITUTECANCEL = SubstituteCancelProcessFactory.fileStore();
    }
}

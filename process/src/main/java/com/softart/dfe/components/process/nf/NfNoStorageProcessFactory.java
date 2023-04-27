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

final class NfNoStorageProcessFactory extends NfProcessFactory {

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
    public SubstituteCancelProcessFactory substituteCancel() {
        return Holder.SUBSTITUTECANCEL;
    }

    @Override
    public QueryRegisterProcessFactory queryRegister() {
        return Holder.QUERYREGISTER;
    }

    static final class Holder {
        static final InutilizationProcessFactory INUTILIZATION = InutilizationProcessFactory.noStore();
        static final CancelProcessFactory CANCEL = CancelProcessFactory.noStore();
        static final AuthorizationProcessFactory AUTHORIZATION = AuthorizationProcessFactory.noStore();
        static final ReturnAuthorizationProcessFactory RETURNAUTHORIZATION = ReturnAuthorizationProcessFactory.noStore();
        static final QueryProtocolProcessFactory QUERYPROTOCOL = QueryProtocolProcessFactory.noStore();
        static final DistributionProcessFactory DISTRIBUTION = DistributionProcessFactory.noStore();
        static final ManifestationProcessFactory MANIFESTATION = ManifestationProcessFactory.noStore();
        static final QueryStatusServiceProcessFactory QUERYSTATUSSERVICE = QueryStatusServiceProcessFactory.noStore();
        static final CorrectionLetterProcessFactory CORRECTIONLETTER = CorrectionLetterProcessFactory.noStore();
        static final EpecProcessFactory EPEC = EpecProcessFactory.noStore();
        static final InterestedActorProcessFactory INTERESTEDACTOR = InterestedActorProcessFactory.noStore();
        static final QueryGtinProcessFactory QUERYGTIN = QueryGtinProcessFactory.noStore();
        static final QueryRegisterProcessFactory QUERYREGISTER = QueryRegisterProcessFactory.noStore();
        static final SubstituteCancelProcessFactory SUBSTITUTECANCEL = SubstituteCancelProcessFactory.noStore();
    }
}

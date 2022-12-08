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
import com.softart.dfe.components.process.nf.query_status_service.impl.QueryStatusServiceProcessFactory;
import com.softart.dfe.components.process.nf.return_authorization.impl.ReturnAuthorizationProcessFactory;
import com.softart.dfe.components.process.nf.substitute_cancel.impl.SubstituteCancelProcessFactory;

final class NfNoStorageProcessFactory extends NfProcessFactory {

    @Override
    public InutilizationProcessFactory inutilization() {
        return InutilizationProcessFactory.noStore();
    }

    @Override
    public CancelProcessFactory cancel() {
        return CancelProcessFactory.noStore();
    }

    @Override
    public AuthorizationProcessFactory authorization() {
        return AuthorizationProcessFactory.noStore();
    }

    @Override
    public ReturnAuthorizationProcessFactory returnAuthorization() {
        return ReturnAuthorizationProcessFactory.noStore();
    }

    @Override
    public QueryProtocolProcessFactory queryProtocol() {
        return QueryProtocolProcessFactory.noStore();
    }

    @Override
    public DistributionProcessFactory distribution() {
        return DistributionProcessFactory.noStore();
    }

    @Override
    public ManifestationProcessFactory manifestation() {
        return ManifestationProcessFactory.noStore();
    }

    @Override
    public QueryStatusServiceProcessFactory queryStatusService() {
        return QueryStatusServiceProcessFactory.noStore();
    }

    @Override
    public CorrectionLetterProcessFactory correctionLetter() {
        return CorrectionLetterProcessFactory.noStore();
    }

    @Override
    public EpecProcessFactory epec() {
        return EpecProcessFactory.noStore();
    }

    @Override
    public InterestedActorProcessFactory interestedActor() {
        return InterestedActorProcessFactory.noStore();
    }

    @Override
    public QueryGtinProcessFactory queryGtin() {
        return QueryGtinProcessFactory.noStore();
    }

    @Override
    public SubstituteCancelProcessFactory substituteCancel() {
        return SubstituteCancelProcessFactory.noStore();
    }
}

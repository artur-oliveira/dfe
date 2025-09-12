package org.dfe.components.process.nf;

import org.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import org.dfe.components.process.nf.distribution.impl.DistributionProcessFactory;
import org.dfe.components.process.nf.event.impl.EventProcessFactory;
import org.dfe.components.process.nf.inut.impl.InutilizationProcessFactory;
import org.dfe.components.process.nf.query_gtin.impl.QueryGtinProcessFactory;
import org.dfe.components.process.nf.query_protocol.impl.QueryProtocolProcessFactory;
import org.dfe.components.process.nf.query_register.impl.QueryRegisterProcessFactory;
import org.dfe.components.process.nf.query_status_service.impl.QueryStatusServiceProcessFactory;
import org.dfe.components.process.nf.return_authorization.impl.ReturnAuthorizationProcessFactory;

@SuppressWarnings("unused")
final class NfS3StorageProcessFactory extends NfProcessFactory {

    @Override
    public InutilizationProcessFactory inutilization() {
        return Holder.INUTILIZATION;
    }

    @Override
    public EventProcessFactory cancel() {
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
    public QueryStatusServiceProcessFactory queryStatusService() {
        return Holder.QUERYSTATUSSERVICE;
    }


    @Override
    public QueryGtinProcessFactory queryGtin() {
        return Holder.QUERYGTIN;
    }

    @Override
    public QueryRegisterProcessFactory queryRegister() {
        return Holder.QUERYREGISTER;
    }


    static final class Holder {
        static final InutilizationProcessFactory INUTILIZATION = InutilizationProcessFactory.s3();
        static final EventProcessFactory CANCEL = EventProcessFactory.s3();
        static final AuthorizationProcessFactory AUTHORIZATION = AuthorizationProcessFactory.s3();
        static final ReturnAuthorizationProcessFactory RETURNAUTHORIZATION = ReturnAuthorizationProcessFactory.s3();
        static final QueryProtocolProcessFactory QUERYPROTOCOL = QueryProtocolProcessFactory.s3();
        static final DistributionProcessFactory DISTRIBUTION = DistributionProcessFactory.s3();
        static final QueryStatusServiceProcessFactory QUERYSTATUSSERVICE = QueryStatusServiceProcessFactory.s3();
        static final QueryGtinProcessFactory QUERYGTIN = QueryGtinProcessFactory.s3();
        static final QueryRegisterProcessFactory QUERYREGISTER = QueryRegisterProcessFactory.s3();
    }
}

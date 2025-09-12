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

final class NfFileStorageProcessFactory extends NfProcessFactory {

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
        static final InutilizationProcessFactory INUTILIZATION = InutilizationProcessFactory.fileStore();
        static final EventProcessFactory CANCEL = EventProcessFactory.fileStore();
        static final AuthorizationProcessFactory AUTHORIZATION = AuthorizationProcessFactory.fileStore();
        static final ReturnAuthorizationProcessFactory RETURNAUTHORIZATION = ReturnAuthorizationProcessFactory.fileStore();
        static final QueryProtocolProcessFactory QUERYPROTOCOL = QueryProtocolProcessFactory.fileStore();
        static final DistributionProcessFactory DISTRIBUTION = DistributionProcessFactory.fileStore();
        static final QueryStatusServiceProcessFactory QUERYSTATUSSERVICE = QueryStatusServiceProcessFactory.fileStore();
        static final QueryGtinProcessFactory QUERYGTIN = QueryGtinProcessFactory.fileStore();
        static final QueryRegisterProcessFactory QUERYREGISTER = QueryRegisterProcessFactory.fileStore();
    }
}

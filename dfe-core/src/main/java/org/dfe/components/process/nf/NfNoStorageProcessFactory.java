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

final class NfNoStorageProcessFactory extends NfProcessFactory {

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
        static final InutilizationProcessFactory INUTILIZATION = InutilizationProcessFactory.noStore();
        static final EventProcessFactory CANCEL = EventProcessFactory.noStore();
        static final AuthorizationProcessFactory AUTHORIZATION = AuthorizationProcessFactory.noStore();
        static final ReturnAuthorizationProcessFactory RETURNAUTHORIZATION = ReturnAuthorizationProcessFactory.noStore();
        static final QueryProtocolProcessFactory QUERYPROTOCOL = QueryProtocolProcessFactory.noStore();
        static final DistributionProcessFactory DISTRIBUTION = DistributionProcessFactory.noStore();
        static final QueryStatusServiceProcessFactory QUERYSTATUSSERVICE = QueryStatusServiceProcessFactory.noStore();
        static final QueryGtinProcessFactory QUERYGTIN = QueryGtinProcessFactory.noStore();
        static final QueryRegisterProcessFactory QUERYREGISTER = QueryRegisterProcessFactory.noStore();
    }
}

package org.dfe.models.internal.process;

import org.dfe.components.process.nf.NfProcessFactory;
import org.dfe.components.process.nf.authorization.impl.AuthorizationProcessFactory;
import org.dfe.components.process.nf.distribution.impl.DistributionProcessFactory;
import org.dfe.components.process.nf.event.impl.EventProcessFactory;
import org.dfe.components.process.nf.inut.impl.InutilizationProcessFactory;
import org.dfe.components.process.nf.query_gtin.impl.QueryGtinProcessFactory;
import org.dfe.components.process.nf.query_protocol.impl.QueryProtocolProcessFactory;
import org.dfe.components.process.nf.query_register.impl.QueryRegisterProcessFactory;
import org.dfe.components.process.nf.query_status_service.impl.QueryStatusServiceProcessFactory;
import org.dfe.components.process.nf.return_authorization.impl.ReturnAuthorizationProcessFactory;
import org.dfe.interfaces.process.nf.NfProcessService;
import org.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import org.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import org.dfe.interfaces.process.nf.distribution.AfterDistribution;
import org.dfe.interfaces.process.nf.distribution.BeforeDistribution;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.process.nf.event.BeforeEvent;
import org.dfe.interfaces.process.nf.inut.AfterInut;
import org.dfe.interfaces.process.nf.inut.BeforeInut;
import org.dfe.interfaces.process.nf.query_gtin.AfterQueryGtin;
import org.dfe.interfaces.process.nf.query_gtin.BeforeQueryGtin;
import org.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import org.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import org.dfe.interfaces.process.nf.query_register.AfterQueryRegister;
import org.dfe.interfaces.process.nf.query_register.BeforeQueryRegister;
import org.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import org.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import org.dfe.interfaces.process.nf.return_authorization.AfterReturnAuthorization;
import org.dfe.interfaces.process.nf.return_authorization.BeforeReturnAuthorization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public abstract class NfProcess implements NfProcessService {


    public static NfProcess getInstance() {
        return switch (System.getProperty("org.dfe.process.nf", "default")) {
            case "s3" -> HolderS3.INSTANCE;
            default -> Holder.INSTANCE;
        };
    }

    public abstract List<NfProcessFactory> getProcessFactories();

    public List<InutilizationProcessFactory> inutilizations() {
        return getProcessFactories().stream().map(NfProcessFactory::inutilization).collect(Collectors.toList());
    }

    public List<EventProcessFactory> events() {
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

    public List<QueryStatusServiceProcessFactory> queryStatusServices() {
        return getProcessFactories().stream().map(NfProcessFactory::queryStatusService).collect(Collectors.toList());
    }

    public List<QueryGtinProcessFactory> queryGtins() {
        return getProcessFactories().stream().map(NfProcessFactory::queryGtin).collect(Collectors.toList());
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
    public Collection<AfterEvent> afterEvent() {
        return events().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeEvent> beforeEvent() {
        return events().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
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
    public Collection<AfterDistribution> afterDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.after())).flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public Collection<BeforeDistribution> beforeDistribution() {
        return distributions().stream().map(it -> new ArrayList<>(it.before())).flatMap(List::stream).collect(Collectors.toList());
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

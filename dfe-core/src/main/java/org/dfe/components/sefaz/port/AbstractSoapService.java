package org.dfe.components.sefaz.port;

import lombok.Getter;
import lombok.SneakyThrows;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.util.ReflectionUtils;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;

@Getter
public abstract class AbstractSoapService {
    protected final int RETRY_TIMES_IF_FAIL = Integer.parseInt(System.getProperty("org.dfe.soap.retry", "5"));
    protected final boolean LAZY_INITIALIZATION = Boolean.parseBoolean(System.getProperty("org.dfe.soap.lazy", "true"));
    protected boolean initialized = false;
    protected Config config;

    public AbstractSoapService() {

    }

    public AbstractSoapService(Config config) {
        this.config = config;
    }

    public AbstractSoapService withConfig(Config config) {
        this.config = config;
        return this;
    }

    @SneakyThrows
    protected <T> T newServiceInstance(Class<T> clazz) {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(getConfig()).getSocketFactory());
        T instance = null;
        for (int i = 0; i < RETRY_TIMES_IF_FAIL; i++) {
            instance = ReflectionUtils.safeNewInstance(clazz);
            if (Objects.nonNull(instance)) break;
        }
        if (Objects.isNull(instance)) {
            return ReflectionUtils.newInstance(clazz);
        }
        return instance;
    }

}

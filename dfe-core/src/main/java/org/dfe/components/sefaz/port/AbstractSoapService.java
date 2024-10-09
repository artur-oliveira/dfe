package org.dfe.components.sefaz.port;

import lombok.Getter;
import lombok.SneakyThrows;
import org.dfe.components.security.socket.SocketFactory;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.util.ReflectionUtils;

import javax.net.ssl.HttpsURLConnection;
import java.util.Objects;
import java.util.function.Supplier;

@Getter
public abstract class AbstractSoapService {
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

    protected void safeInititialization(Supplier<Void> function) {
        try {
            function.get();
        } catch (Exception ignored) {
        }
    }

    @SneakyThrows
    protected <T> T newServiceInstance(Class<T> clazz) {
        HttpsURLConnection.setDefaultSSLSocketFactory(SocketFactory.getInstance().context(getConfig()).getSocketFactory());
        T instance = null;
        for (int i = 0; i < SoapConfigurationProperties.RETRY_TIMES_IF_FAIL; i++) {
            instance = ReflectionUtils.safeNewInstance(clazz);
            if (Objects.nonNull(instance)) break;
        }
        if (Objects.isNull(instance)) {
            return ReflectionUtils.newInstance(clazz);
        }
        return instance;
    }
}

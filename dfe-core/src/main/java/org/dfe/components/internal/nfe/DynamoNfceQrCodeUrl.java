package org.dfe.components.internal.nfe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.nf.NfceQrCodeUrl;
import org.dfe.util.DynamoDBUtils;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public final class DynamoNfceQrCodeUrl implements NfceQrCodeUrl {

    private static final String DYNAMO_DB_TABLE = Optional.ofNullable(System.getenv("org.dfe.nfce.qrcode-url-table")).orElse(System.getProperty("org.dfe.nfce.qrcode-url-table", "dfe_uf_urls"));
    private static final Function<Map<String, AttributeValue>, NfceQueryUrlDynamo> TRANSFORMER = attr -> NfceQueryUrlDynamo
            .builder()
            .uf(UF.valueOf(attr.get("uf").s()))
            .urlProd(attr.get("qrcode_nfce_prod").s())
            .urlHom(attr.get("qrcode_nfce_hom").s())
            .build();

    private final Map<UF, NfceQueryUrlDynamo> data = DynamoDBUtils.getMapItems(DYNAMO_DB_TABLE, TRANSFORMER, NfceQueryUrlDynamo::getUf);

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static final class NfceQueryUrlDynamo {
        private UF uf;
        private String urlHom;
        private String urlProd;
    }

    @Override
    public String get(UF uf, Environment environment) throws NoProviderFound {
        if (Objects.isNull(data.get(uf))) {
            throw new NoProviderFound(uf);
        }
        NfceQueryUrlDynamo queryUrlDynamo = Optional.ofNullable(data.get(uf)).orElseThrow(() -> new NoProviderFound(uf));
        return Objects.equals(environment, Environment.PRODUCTION) ? queryUrlDynamo.getUrlProd() : queryUrlDynamo.getUrlHom();
    }
}

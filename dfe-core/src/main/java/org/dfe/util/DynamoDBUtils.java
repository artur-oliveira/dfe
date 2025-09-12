package org.dfe.util;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

import java.util.*;
import java.util.function.Function;

public final class DynamoDBUtils {
    private static final Region DYNAMODB_REGION = Region.of(Optional.ofNullable(System.getenv("org.dfe.dynamodb.region")).orElse(System.getProperty("org.dfe.dynamodb.region", "us-east-1")));
    private static final Map<String, List<Map<String, AttributeValue>>> scanCache = new HashMap<>();

    private DynamoDBUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    public static DynamoDbClient clientInstance() {
        return Holder.CLIENT_INSTANCE;
    }

    public static <T> List<T> getListItems(String tableName, Function<Map<String, AttributeValue>, T> mapper) {
        if (scanCache.containsKey(tableName)) {
            return scanCache.get(tableName).stream().map(mapper).toList();
        }
        ScanResponse response = clientInstance().scan(ScanRequest.builder().tableName(tableName).limit(100).build());
        List<Map<String, AttributeValue>> items = response.items();
        scanCache.put(tableName, items);
        return items.stream().map(mapper).toList();
    }


    public static <T, I> Map<I, T> getMapItems(String tableName, Function<Map<String, AttributeValue>, T> mapper, Function<T, I> mapMapper) {
        List<T> items = getListItems(tableName, mapper);
        Map<I, T> result = new HashMap<>();
        items.forEach(item -> {
            result.put(mapMapper.apply(item), item);
        });
        return Collections.unmodifiableMap(result);
    }


    private static final class Holder {
        private static final DynamoDbClient CLIENT_INSTANCE = DynamoDBUtils.newClient();
    }

    private static DynamoDbClient newClient() {
        return DynamoDbClient
                .builder()
                .region(DYNAMODB_REGION)
                .build();
    }
}

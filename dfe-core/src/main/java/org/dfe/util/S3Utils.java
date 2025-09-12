package org.dfe.util;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import static java.nio.charset.StandardCharsets.UTF_8;

@SuppressWarnings("all")
public final class S3Utils {

    private S3Utils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    public static S3Client clientInstance() {
        return Holder.CLIENT_INSTANCE;
    }

    protected static S3Client newClient() {
        try {
            return S3Client.builder().build();
        } catch (Exception ignored) {
            return null;
        }
    }

    public static PutObjectResponse putObject(S3Client client, String bucket, String key, byte[] bytes) throws IOException {
        try (InputStream bais = InputStreamUtils.newByteArrayInputStream(bytes)) {
            return client.putObject(
                    PutObjectRequest
                            .builder()
                            .bucket(bucket)
                            .key(key)
                            .build(),
                    RequestBody.fromInputStream(bais, bytes.length)
            );
        }
    }

    public static PutObjectResponse putObject(S3Client client, String bucket, String key, String content) throws IOException {
        return putObject(client, bucket, key, content.getBytes(UTF_8));
    }

    public static PutObjectResponse putObject(String bucket, String key, String content) throws IOException {
        return putObject(clientInstance(), bucket, key, content);
    }

    public static PutObjectResponse putObject(String bucket, String key, byte[] bytes) throws IOException {
        return putObject(clientInstance(), bucket, key, bytes);
    }

    public static PutObjectResponse putObject(String key, byte[] bytes) throws IOException {
        return putObject(clientInstance(), requiredBucket(), key, bytes);
    }

    public static ResponseBytes<GetObjectResponse> getObject(S3Client client, String bucket, String key) {
        return client.getObjectAsBytes(GetObjectRequest.builder().bucket(bucket).key(key).build());
    }

    public static ResponseBytes<GetObjectResponse> getObject(String bucket, String key) {
        return getObject(clientInstance(), bucket, key);
    }

    public static ResponseBytes<GetObjectResponse> getObject(String key) {
        return getObject(clientInstance(), requiredBucket(), key);
    }

    static String requiredBucket() {
        return RequireUtils.nonNull(System.getProperty("org.dfe.s3.bucket"), "org.dfe.s3.bucket must be set in order to use this method");
    }

    public static Collection<S3Object> listObjects(S3Client client, String bucket, String key) {
        return client.listObjectsV2(ListObjectsV2Request
                .builder()
                .bucket(bucket)
                .prefix(key)
                .build()).contents();
    }

    public static Collection<S3Object> listObjects(String bucket, String key) {
        return listObjects(clientInstance(), bucket, key);
    }

    public static Collection<S3Object> listObjects(String key) {
        return listObjects(requiredBucket(), key);
    }

    private static final class Holder {
        private static final S3Client CLIENT_INSTANCE = S3Utils.newClient();
    }
}

package com.softart.dfe.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

@SuppressWarnings("all")
public final class S3Utils {

    public static final String DEFAULT_S3_BUCKET = System.getProperty("com.softart.dfe.s3.bucket");

    private S3Utils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    public static AmazonS3 clientInstance() {
        return Holder.CLIENT_INSTANCE;
    }

    protected static AmazonS3 newClient() {
        try {
            return AmazonS3ClientBuilder.standard().defaultClient();
        } catch (Exception ignored) {
            return null;
        }
    }

    public static PutObjectResult putObject(AmazonS3 client, String bucket, String key, byte[] bytes, ObjectMetadata metadata) throws IOException {
        try (InputStream bais = InputStreamUtils.newByteArrayInputStream(bytes)) {
            metadata.setContentLength(bytes.length);
            return client.putObject(new PutObjectRequest(bucket, key, bais, metadata));
        }
    }

    public static PutObjectResult putObject(AmazonS3 client, String bucket, String key, byte[] bytes) throws IOException {
        return putObject(client, bucket, key, bytes, new ObjectMetadata());
    }

    public static PutObjectResult putObject(AmazonS3 client, String bucket, String key, String content) throws IOException {
        return putObject(client, bucket, key, content.getBytes(UTF_8));
    }

    public static PutObjectResult putObject(String bucket, String key, String content) throws IOException {
        return putObject(clientInstance(), bucket, key, content);
    }

    public static PutObjectResult putObject(String key, byte[] bytes, ObjectMetadata metadata) throws IOException {
        return putObject(clientInstance(), requiredBucket(), key, bytes, metadata);
    }

    public static PutObjectResult putObject(String key, byte[] bytes) throws IOException {
        return putObject(clientInstance(), requiredBucket(), key, bytes);
    }

    public static S3Object getObject(AmazonS3 client, String bucket, String key) {
        return client.getObject(bucket, key);
    }

    public static S3Object getObject(String bucket, String key) {
        return getObject(clientInstance(), bucket, key);
    }

    public static S3Object getObject(String key) {
        return getObject(clientInstance(), requiredBucket(), key);
    }

    static String requiredBucket() {
        return RequireUtils.nonNull(DEFAULT_S3_BUCKET, "com.softart.dfe.s3.bucket must be set in order to use this method");
    }

    private static final class Holder {
        private static final AmazonS3 CLIENT_INSTANCE = S3Utils.newClient();
    }
}

package com.softart.dfe.util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

@SuppressWarnings("all")
public final class S3Utils {

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

    public static PutObjectResult putObject(AmazonS3 client, String bucket, String fileName, String content) throws IOException {
        final byte[] bytes = content.getBytes(UTF_8);
        try (InputStream bais = InputStreamUtils.newByteArrayInputStream(bytes)) {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(bytes.length);
            return client.putObject(new PutObjectRequest(bucket, fileName, bais, metadata));
        }
    }

    private static final class Holder {
        private static final AmazonS3 CLIENT_INSTANCE = S3Utils.newClient();
    }
}

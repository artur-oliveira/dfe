package com.softart.dferestapi.components.aws;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.softart.dfe.util.S3Utils;
import com.softart.dferestapi.configuration.properties.S3Properties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@Getter
@Setter
public class S3 {

    private final S3Properties s3Properties;

    public S3(
            S3Properties s3Properties
    ) {
        this.s3Properties = s3Properties;
    }

    public PutObjectResult upload(String fileName, InputStream is, ObjectMetadata objectMetadata) {
        return S3Utils.clientInstance().putObject(getS3Properties().getBucket(), fileName, is, objectMetadata);
    }

}

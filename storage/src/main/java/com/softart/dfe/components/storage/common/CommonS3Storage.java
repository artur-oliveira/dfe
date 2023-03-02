package com.softart.dfe.components.storage.common;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.storage.StorageService;
import com.softart.dfe.models.internal.storage.StorageResult;
import com.softart.dfe.util.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class CommonS3Storage extends CommonStorage implements StorageService {

}


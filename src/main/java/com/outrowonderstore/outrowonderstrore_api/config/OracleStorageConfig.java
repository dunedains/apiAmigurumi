package com.outrowonderstore.outrowonderstrore_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class OracleStorageConfig {
    @Value("${oracle.storage.access-key}")
    private String accessKey;
    @Value("${oracle.storage.secret-key}")
    private String secretKey;
    @Value("${oracle.storage.bucket-name}")
    private String bucketName;
    @Value("${oracle.storage.region}")
    private String region;
    @Value("${oracle.storage.namespace}")
    private String namespace;

    @Bean
    public S3Client s3Client(){
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
        String endpoint = String.format("https://%s.compat.objectstorage.%s.oraclecloud.com", namespace, region);

        return S3Client.builder()
                .region(Region.of(region))
                .endpointOverride(URI.create(endpoint))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

}

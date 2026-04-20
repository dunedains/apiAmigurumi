package com.outrowonderstore.outrowonderstrore_api.service.impl;

import com.outrowonderstore.outrowonderstrore_api.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final S3Client s3Client;

    @Value("${oracle.storage.bucket-name}")
    private String bucketName;

    @Value("${oracle.storage.namespace}")
    private String namespace;

    @Value("${oracle.storage.region}")
    private String region;

    @Override
    public String uploadFile(MultipartFile file){
        try{
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .contentType(file.getContentType()) // Le dice a la nube si es JPG, PNG, etc.
                    .build();

            s3Client.putObject(putObjectRequest,
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

            return String.format("https://objectstorage.%s.oraclecloud.com/n/%s/b/%s/o/%s",
                    region, namespace, bucketName, fileName);
        } catch (Exception e) {
            throw new RuntimeException("error uploading file:");
        }
    }
    }


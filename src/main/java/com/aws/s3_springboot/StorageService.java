package com.aws.s3_springboot;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.io.InputStream;

@Service
public class StorageService {
    private final S3Client s3Client;

    public StorageService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadFile(String bucketName, String key, InputStream inputStream) throws S3Exception, AwsServiceException, SdkClientException, IOException {
        s3Client.putObject(PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build(), RequestBody.fromInputStream(inputStream, inputStream.available()));
        return "File uploaded successfully.";
    }

    public InputStream downloadFile(String bucketName, String key) {
        return s3Client.getObject(GetObjectRequest.builder().bucket(bucketName).key(key).build());
    }

    public String deleteFile(String bucketName, String key) {
        s3Client.deleteObject(DeleteObjectRequest.builder().bucket(bucketName).key(key).build());
        return "File deleted successfully.";
    }
}

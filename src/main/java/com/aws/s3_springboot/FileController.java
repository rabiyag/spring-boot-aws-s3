package com.aws.s3_springboot;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final StorageService storageService;
    private final String bucketName = "springboot-s3-bucket"; // Replace with your bucket name

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            return storageService.uploadFile(bucketName, file.getOriginalFilename(), inputStream);
        } catch (Exception e) {
            return "File upload failed.";
        }
    }

    @GetMapping("/download/{fileName}")
    public byte[] downloadFile(@PathVariable String fileName) {
        try (InputStream inputStream = storageService.downloadFile(bucketName, fileName)) {
            return inputStream.readAllBytes();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @DeleteMapping("/delete/{fileName}")
    public String deleteFile(@PathVariable String fileName) {
        return storageService.deleteFile(bucketName, fileName);
    }
}
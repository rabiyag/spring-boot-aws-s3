# Spring Boot AWS S3

This project demonstrates how to integrate AWS S3 with a Spring Boot application. It provides functionality for uploading, downloading, and managing files directly on AWS S3 from within a Spring Boot application.

## Features
- AWS S3 Integration: Easily upload, download, and manage files in AWS S3 buckets.
- Spring Boot Setup: Simple integration with Spring Boot for quick setup and deployment.
- File Management: Supports uploading files from local systems to S3, downloading files, and deleting them.
- AWS SDK: Utilizes AWS SDK to interact with S3 directly from the Spring Boot application.

## Technologies Used
- **Spring Boot** (Backend framework)
- **AWS S3** (AWS Services)
- **Maven** (Dependency management)

## Prerequisites
- **JDK 8** or higher
- **Maven** for dependency management
- **AWS account**


## File Upload and Download

- Upload a file: You can upload a file using the /upload endpoint.
- Download a file: Use the /download/{filename} endpoint to download a file from the configured S3 bucket.

**Example Endpoints**
 - Upload file:
      POST /api/files/upload (Send file via form-data)

 - Download file:
      GET /api/files/download/{filename}

package com.file.upload.controller;

import com.file.upload.json.FileUploadResponse;
import com.file.upload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService service;

    @PostMapping("/uploadFile")
    @ResponseStatus(HttpStatus.OK)
    public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        return service.uploadFile(multipartFile);
    }
}

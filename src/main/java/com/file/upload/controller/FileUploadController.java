package com.file.upload.controller;

import com.file.upload.json.FileUploadResponse;
import com.file.upload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/uploadFile")
public class FileUploadController {

    @Autowired
    private FileUploadService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        return service.uploadFile(multipartFile);
    }
}

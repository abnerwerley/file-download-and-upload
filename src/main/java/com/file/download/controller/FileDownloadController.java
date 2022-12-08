package com.file.download.controller;

import com.file.download.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileDownloadController {

    @Autowired
    private FileDownloadService service;

    @GetMapping("/downloadFile/{fileCode}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> downloadFile(@PathVariable("fileCode") String fileCode) throws IOException {
        return service.downloadFile(fileCode);
    }
}

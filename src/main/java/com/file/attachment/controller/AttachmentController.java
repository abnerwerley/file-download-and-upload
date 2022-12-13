package com.file.attachment.controller;

import com.file.attachment.entity.Attachment;
import com.file.attachment.entity.CsvData;
import com.file.attachment.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class AttachmentController {
    @Autowired
    private final AttachmentService service;

    public AttachmentController(AttachmentService service) {
        this.service = service;
    }

    @PostMapping("/generateCsv")
    @ResponseStatus(HttpStatus.CREATED)
    public Attachment generateCsvFile(@RequestBody CsvData data) {
        return service.generateCsvFile(data);
    }
}


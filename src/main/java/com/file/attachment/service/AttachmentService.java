package com.file.attachment.service;

import com.file.attachment.entity.Attachment;
import com.file.attachment.entity.CsvData;
import com.file.attachment.repository.AttachmentRepository;
import lombok.extern.slf4j.Slf4j;
import nps.librarycsv.utils.CsvLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AttachmentService {

    @Autowired
    private final AttachmentRepository repository;

    public AttachmentService(AttachmentRepository repository) {
        this.repository = repository;
    }

    public void generateCsvFile(CsvData csvData) {
        Attachment attachment = new Attachment((csvData.getParseDateFrom() == null && csvData.getParseDateTo() == null) ?
                CsvLibrary.create(
                        csvData.getHeaders(),
                        csvData.getDataList(),
                        csvData.isShowHeader()) :
                CsvLibrary.create(
                        csvData.getHeaders(),
                        csvData.getDataList(),
                        csvData.isShowHeader(),
                        csvData.getParseDateFrom(),
                        csvData.getParseDateTo()));
        repository.save(attachment);
    }
}

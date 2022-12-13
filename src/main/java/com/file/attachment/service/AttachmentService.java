package com.file.attachment.service;

import com.file.attachment.entity.Attachment;
import com.file.attachment.entity.CsvData;
import com.file.attachment.repository.AttachmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AttachmentService {

    @Autowired
    private final AttachmentRepository repository;

    public AttachmentService(AttachmentRepository repository) {
        this.repository = repository;
    }

    public byte[] convertStringToBytes(List<String> headers, List<String> dataList, boolean showHeader) {
        String csv;
        if (showHeader && !headers.isEmpty()) {
            csv = headers.stream().map(String::valueOf)
                    .collect(Collectors.joining(","));

            csv += "\r\n";
            csv += dataList.stream().map(String::valueOf)
                    .collect(Collectors.joining(","));
        } else {
            csv = dataList.stream().map(String::valueOf)
                    .collect(Collectors.joining(","));
        }
        return csv.getBytes();
    }

    public Attachment generateCsvFile(CsvData data) {
        Attachment attachment = Attachment.builder()
                .fileName("newFile")
                .data(convertStringToBytes(data.getHeaders(), data.getDataList(), data.isShowHeader()))
                .build();
        return repository.save(attachment);
    }
}

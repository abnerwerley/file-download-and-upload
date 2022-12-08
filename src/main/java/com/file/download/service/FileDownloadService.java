package com.file.download.service;

import com.file.download.utils.FileDownloadUtil;
import com.file.exception.ResourceNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileDownloadService {
    public ResponseEntity<Object> downloadFile(String fileCode) throws IOException {
        try {
            FileDownloadUtil util = new FileDownloadUtil();
            Resource resource = util.getFileAsResource(fileCode);
            if (resource == null) {
                throw new ResourceNotFoundException("File not found: " + fileCode);
            }

            String contentType = "application/octet-stream";
            String headerValue = "attachment; filename = \"" + resource.getFilename() + "\"";

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                    .body(resource);

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("File not found: " + fileCode);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}

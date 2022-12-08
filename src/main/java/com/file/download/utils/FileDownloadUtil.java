package com.file.download.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {

    private Path foundFile;

    public Resource getFileAsResource(String fileCode) throws IOException {
        try {
            Path uploadDirectory = Paths.get("Files-Uploaded");

            Files.list(uploadDirectory).forEach(file -> {
                if (file.getFileName().toString().startsWith(fileCode)) {
                    foundFile = file;
                }
            });

            if (foundFile != null) {
                return new UrlResource(foundFile.toUri());
            }
            return null;

        } catch (IOException e) {
            throw new IOException("Error when downloading file: " + fileCode);
        }

    }
}

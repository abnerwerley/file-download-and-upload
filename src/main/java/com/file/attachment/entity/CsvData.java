package com.file.attachment.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CsvData {
    private List<String> headers;
    private List<List<String>> dataList;
    private boolean showHeader;
}

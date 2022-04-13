package com.example.ws.io.file.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestUpload extends RequestTemplate {
    String fileName;
    Byte fileType;
}

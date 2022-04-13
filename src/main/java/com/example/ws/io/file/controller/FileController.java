package com.example.ws.io.file.controller;

import com.example.ws.io.file.dto.RequestTemplate;
import com.example.ws.io.file.dto.RequestUpload;
import com.example.ws.io.file.model.XFile;
import com.example.ws.io.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/uploader")
    @ResponseBody
    public ResponseEntity<ResponseStatus> uploadFile(@RequestParam("file") MultipartFile file) {
        Object status = null;

        try {
            fileService.store(file);
            status = HttpStatus.CREATED;
        }catch (Exception e){
            e.printStackTrace();
            status =  HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(null , (HttpStatus) status);

    }

    @GetMapping("/downloader")
    @ResponseBody
    public ResponseEntity<byte[]> downloadFile(@RequestBody RequestTemplate req, BindingResult bindingResult){
        Object status = null;
        XFile fileDB = fileService.findFileByGroupId(req.getFileGroup());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFileGroup() + "\"")
                .body(fileDB.getFileType());

    }

}

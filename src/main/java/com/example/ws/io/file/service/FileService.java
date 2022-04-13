package com.example.ws.io.file.service;

import com.example.ws.io.file.model.XFile;
import com.example.ws.io.file.repository.XFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    XFileRepo xFileRepo;

    public XFile store(MultipartFile files) throws IOException {
        String fileName = files.getOriginalFilename();
        XFile xFile = new XFile(fileName, files.getContentType(), files.getBytes());

        return xFileRepo.save(xFile);
    }

    public XFile findFileByGroupId(String groupID){
        return xFileRepo.getFileByGroup(groupID);
    }
}

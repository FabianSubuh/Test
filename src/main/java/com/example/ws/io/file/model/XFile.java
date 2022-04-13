package com.example.ws.io.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class XFile {
    @Id
    @GeneratedValue
    private long id;
    private String fileGroup;
    private String filesName;
    @Lob
    private byte[] fileType;

    public XFile(String fileGroup, String filesName, byte[] fileType) {
        this.fileGroup = fileGroup;
        this.filesName = filesName;
        this.fileType = fileType;
    }

    public XFile(String fileGroup) {
        this.fileGroup = fileGroup;
    }
}

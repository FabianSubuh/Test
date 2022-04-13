package com.example.ws.io.file.repository;

import com.example.ws.io.file.model.XFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XFileRepo extends JpaRepository<XFile, Long> {
    @Query(value = " SELECT al from XFile al where al.fileGroup = ?1 ")
    XFile getFileByGroup(String fileGroup);
}

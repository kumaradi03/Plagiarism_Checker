package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public class FileUploadService {

    @Autowired
    FileUploadRepository fileUploadRepository;

    // Retrieve file
    public FileUpload findByFilename(String filename) {
        return fileUploadRepository.findByFilename(filename);
    }

    // Upload the file
    public void uploadFile(FileUpload doc) {
        fileUploadRepository.saveAndFlush(doc);
    }

}

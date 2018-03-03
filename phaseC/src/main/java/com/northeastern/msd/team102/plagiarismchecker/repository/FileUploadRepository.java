package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
    FileUpload findByFilename(String filename);
}

package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
    FileUpload findByFilename(String filename);

    List<FileUpload> findAllByHomeworkId(long hwId);

    @Query("Select f from FileUpload f where homework_id = ?1 and user_id <> ?2")
    List<FileUpload> findAllFileForOtherUser(long hwId, long userId);
}

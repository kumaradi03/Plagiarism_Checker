package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository for FileUpload entity.
 */
public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {

    /**
     * findByFilename to fetch file by File name.
     * @param filename name of the file
     * @return FileUpload object for the particular filename.
     */
    FileUpload findByFilename(String filename);

    /**
     * findAllByHomeworkId to fetch all the files for a particular homework.
     * @param hwId homework Id for the files to be fetched.
     * @return List of Fileuploads for the particular homework
     */
    List<FileUpload> findAllByHomeworkId(long hwId);

    /**
     * findAllFileForOtherUser to fetch all the files for other users.
     * @param hwId homework Id for the files to be fetched.
     * @param userId userId Id for the user whose file is not to be fetched..
     * @return List of Fileuploads for the particular homework and for users other than the
     * given userId.
     */
    @Query("Select f from FileUpload f where homework_id = ?1 and user_id <> ?2")
    List<FileUpload> findAllFileForOtherUser(long hwId, long userId);
}

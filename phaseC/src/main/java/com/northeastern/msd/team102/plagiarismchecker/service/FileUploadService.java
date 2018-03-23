package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Service class for FileUpload entity.
 */
@Component
public class FileUploadService {

    @Autowired
    FileUploadRepository fileUploadRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HomeworkService homeworkService;

    public static final Logger logger = Logger.getLogger(FileUploadService.class.getName());

    /**
     * findByFilename method returns the file by a file name.
     * @param filename
     * @return Fileupload for the given file.
     */
    public FileUpload findByFilename(String filename) {
        logger.log(Level.INFO, "Returning file by filename: " + filename );
        return fileUploadRepository.findByFilename(filename);
    }

    /**
     * uploadFile method uploads the given file.
     * @param doc File to be uploaded
     * @param userId userId for the file.
     * @param hwId  hwId for the file.
     * @return Fileupload object.
     */
    public FileUpload uploadFile(FileUpload doc, long userId, long hwId) {
        logger.log(Level.INFO, "Uploading file with filename: " + doc.getFilename() + "for userId: " + userId +
                "and homeworkId" + hwId );
        User user = userService.findUserByUserId(userId);
        Homework homework = homeworkService.findById(hwId);
        doc.setUser(user);
        doc.setHomework(homework);
        return fileUploadRepository.saveAndFlush(doc);
    }

    /**
     * findAllByHomeworkId method returns all the files for specified homework
     * @param hwId homework Id
     * @return List of FileUpload object
     */
    public List<FileUpload> findAllByHomeworkId(long hwId) {

        logger.log(Level.INFO, "Returning all the files for hwId: " + hwId);
        return fileUploadRepository.findAllByHomeworkId(hwId);
    }

    /**
     * findAllFileForOtherUser method returns all the files for other users and a given homework
     * @param hwId homework Id
     * @param userId user Id
     * @return List of FileUpload object.
     */
    public List<FileUpload> findAllFileForOtherUser(long hwId, long userId) {
        logger.log(Level.INFO, "Returning file for all users except " + userId  + "for homework: " + hwId);
        return fileUploadRepository.findAllFileForOtherUser(hwId, userId);
    }

}

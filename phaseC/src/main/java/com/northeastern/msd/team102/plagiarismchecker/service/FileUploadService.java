package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileUploadService {

    @Autowired
    FileUploadRepository fileUploadRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HomeworkService homeworkService;

    // Retrieve file
    public FileUpload findByFilename(String filename) {
        return fileUploadRepository.findByFilename(filename);
    }

    // Upload the file
    public void uploadFile(FileUpload doc, long userId, long hwId) {
        User user = userService.findUserByUserId(userId);
        Homework homework = homeworkService.findById(hwId);
        doc.setUser(user);
        doc.setHomework(homework);
        fileUploadRepository.saveAndFlush(doc);
    }
}

package com.northeastern.msd.team102.plagiarismchecker.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.northeastern.msd.team102.plagiarismchecker.service.ReportService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.FileUploadService;

/**
 * Controller class for FileUpload entity.
 */
@RestController
@RequestMapping("/rest/file")
public class FileController {

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    ReportService reportService;

    public static final Logger logger = Logger.getLogger(ReportController.class.getName());

    /**
     * getDistinctUsersForHw returns all the distinct users for that particular homework.
     * @param hwId Homework Id
     * @return a set of Users for that homework
     */
    @GetMapping("/getUser")

    public Set<User> getDistinctUsersForHw(@RequestParam("hwId") String hwId) {
        logger.log(Level.INFO, "Return distinct users for homework with id: " + hwId);
        Long hwID = Long.parseLong(hwId);
        Set<User> set = new HashSet<>();
        Map<Long, User> map = new HashMap<>();
        for (FileUpload file: fileUploadService.findAllByHomeworkId(hwID)) {
            if(!map.containsKey(file.getUser().getId())) {
                map.put(file.getUser().getId(), file.getUser());
                set.add(file.getUser());
            }
        }
        return set;
    }

    /**
     * uploadFile method uploads a multipart file to the database and generates a plagiarism report
     * of this file with all other files for that particular homework.
     * @param request MultipartHttpServletRequest
     * @param userId userId
     * @param hwId hwId
     * @throws IOException
     */
    @PostMapping("/upload")
    public void uploadFile(MultipartHttpServletRequest request,  @RequestParam("userId") String userId,  @RequestParam("hwId") String hwId) throws IOException, URISyntaxException {
        logger.log(Level.INFO, "File uploadede for userID: " + userId + "and hwId: " + hwId);
        long userID = Long.parseLong(userId);
        long hwID = Long.parseLong(hwId);
        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            String uploadedFile = itr.next();
            MultipartFile file = request.getFile(uploadedFile);
            String mimeType = file.getContentType();
            String filename = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            FileUpload newFile = new FileUpload(filename, bytes, mimeType);
            FileUpload fileUpload = fileUploadService.uploadFile(newFile, userID, hwID);
            reportService.generateReport(userID, hwID, fileUpload);
        }
    }
}

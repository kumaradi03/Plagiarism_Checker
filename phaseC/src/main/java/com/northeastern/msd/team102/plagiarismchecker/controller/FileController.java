package com.northeastern.msd.team102.plagiarismchecker.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.northeastern.msd.team102.plagiarismchecker.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.ASTGenerator;
import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.FileUploadService;


@RestController
@RequestMapping("/rest/file")
public class FileController {

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    ReportService reportService;

    @GetMapping("/parse")
    public String parsePythonFile() throws IOException {
        File file = new File("src/main/java/com/northeastern/msd/team102/plagiarismchecker/samplepython/SamplePythonFile1.py");
        byte[] encodedFile = Files.readAllBytes(file.toPath());
        ASTGenerator astPrinter = new ASTGenerator(encodedFile);
        return astPrinter.print();
	}

    @GetMapping("/getUser")
    public Set<User> getDistinctUsersForHw(@RequestParam long hwId) {
        Set<User> set = new HashSet<>();
        Map<Long, User> map = new HashMap<>();
        for (FileUpload file: fileUploadService.findAllByHomeworkId(hwId)) {
            if(!map.containsKey(file.getUser().getId())) {
                map.put(file.getUser().getId(), file.getUser());
                set.add(file.getUser());
            }
        }
        return set;
    }

    @PostMapping("/upload")
    public void uploadFile(MultipartHttpServletRequest request,  @RequestParam long userId,  @RequestParam long hwId) throws IOException {
        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            String uploadedFile = itr.next();
            MultipartFile file = request.getFile(uploadedFile);
            String mimeType = file.getContentType();
            String filename = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            FileUpload newFile = new FileUpload(filename, bytes, mimeType);
            reportService.generateReport(userId, hwId, bytes);
            fileUploadService.uploadFile(newFile, userId, hwId);
        }
    }
}

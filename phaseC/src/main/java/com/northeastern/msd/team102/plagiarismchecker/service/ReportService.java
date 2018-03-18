package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.CompareStrategy;
import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.CompareStrategyHashMap;
import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FileUploadService fileUploadService;

    public void createReport(Report report) { ;
        reportRepository.save(report);
    }

    public void generateReport(long userId1, long hwId, byte[] file) {
        User user = userService.findUserByUserId(userId1);
        List<FileUpload> fileUploads;
        fileUploads = fileUploadService.findAllByHomeworkId(hwId);
        if (!fileUploads.isEmpty()) {
            for(FileUpload f: fileUploads) {
                CompareStrategy compareStrategy = new CompareStrategyHashMap();
                Report report = new Report(user, f.getUser(), compareStrategy.compareFiles(file, f.getFile()));
                createReport(report);
                Report report1 = new Report(f.getUser(),user, compareStrategy.compareFiles(file, f.getFile()));
                createReport(report1);
            }
        }
    }
}

package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.antlr.ast.*;
import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service class for Report entity.
 */
@Component
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private HomeworkService homeworkService;

    /**
     * createReport saves the report in the database.
     * @param report
     */
    public void createReport(Report report) {
        reportRepository.save(report);
    }

    /**
     * generateReport method generates a report for the given file against all other files for that particular homework
     * and user other than the specified user.
     * @param userId userId
     * @param hwId homework id
     * @param file file to be compared
     */
    public void generateReport(long userId, long hwId, FileUpload file) {
        User user = userService.findUserByUserId(userId);
        Homework hw = homeworkService.findById(hwId);
        List<FileUpload> fileUploads;
        fileUploads = fileUploadService.findAllFileForOtherUser(hwId, userId);
        if (!fileUploads.isEmpty()) {
            for(FileUpload f: fileUploads) {
                Context context = new Context(new CompareStrategyHashMap());
                double resultStrategy1File1 = context.executeStrategy(file.getFile(), f.getFile());
                double resultStrategy1File2 = context.executeStrategy(f.getFile(), file.getFile());
                context = new Context(new CompareStrategyTrees());
                double resultStrategy2File1 = context.executeStrategy(file.getFile(), f.getFile());
                double resultStrategy2File2 = context.executeStrategy(f.getFile(), file.getFile());
                context = new Context(new CompareStrategyLevenshteinDist());
                double resultStrategy3File1 = context.executeStrategy(file.getFile(), f.getFile());
                double resultStrategy3File2 = context.executeStrategy(f.getFile(), file.getFile());
                Report report = new Report(user, f.getUser(), file, f, hw, resultStrategy1File1, resultStrategy2File1, resultStrategy3File1);
                createReport(report);
                Report report1 = new Report(f.getUser(), user, f, file, hw, resultStrategy1File2, resultStrategy2File2, resultStrategy3File2);
                createReport(report1);
            }
        }
    }

    /**
     * findAllReportSummary method returns the report foe the specified user id and homework id.
     * @param userId user id
     * @param hwId homework id
     * @return Lost of Report
     */
    public List<Report> findAllReportSummary(long userId, long hwId) {
        return reportRepository.findAllByHomeworkIdAndUser1Id(hwId,userId);
    }
}

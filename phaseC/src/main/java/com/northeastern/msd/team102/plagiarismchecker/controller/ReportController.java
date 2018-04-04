package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import com.northeastern.msd.team102.plagiarismchecker.service.ReportService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Controller class for Report entity.
 */
@RestController
@RequestMapping("/rest/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    public static final Logger logger = Logger.getLogger(ReportController.class.getName());

    /**
     * findAllReportSummary method which receives the request for fetching the plagiarism reports foa given user
     * and homework.
     * @param userId User Id
     * @param hwId Homework Id
     * @return returns all the reports for for this user and homework
     */
    @GetMapping("/findAllReportSummary")
    public List<Report> findAllReportSummary(@RequestParam("userId") String userId, @RequestParam("hwId") String hwId) {
        logger.log(Level.INFO, "Report summary for user with userId: "+ userId + "and homeworkId: " + hwId);
        long userID = Long.parseLong(userId);
        long hwID = Long.parseLong(hwId);
        return reportService.findAllReportSummary(userID, hwID);
    }

    @GetMapping("/getDetailedReport")
    public Map<Integer, String> getDetailedReport (@RequestParam("file1Id") String userId, @RequestParam("hwId") String hwId) {
        logger.log(Level.INFO, "Report summary for user with userId: "+ userId + "and homeworkId: " + hwId);
        long userID = Long.parseLong(userId);
        long hwID = Long.parseLong(hwId);
        return reportService.findAllReportSummary(userID, hwID);
    }

}

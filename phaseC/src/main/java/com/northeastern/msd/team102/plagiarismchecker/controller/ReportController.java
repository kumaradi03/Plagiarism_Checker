package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import com.northeastern.msd.team102.plagiarismchecker.service.ReportService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Report> findAllReportSummary(@RequestParam long userId, @RequestParam long hwId) {
        logger.log(Level.INFO, "Report summary for user with userId: "+ userId + "and homeworkId: " + hwId);
        return reportService.findAllReportSummary(userId, hwId);
    }
}

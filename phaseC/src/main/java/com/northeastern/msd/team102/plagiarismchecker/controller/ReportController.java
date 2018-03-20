package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import com.northeastern.msd.team102.plagiarismchecker.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/findAllReportSummary")
    public List<Report> findAllReportSummary(@RequestParam long userId, @RequestParam long hwId) {
        return reportService.findAllReportSummary(userId, hwId);
    }
}

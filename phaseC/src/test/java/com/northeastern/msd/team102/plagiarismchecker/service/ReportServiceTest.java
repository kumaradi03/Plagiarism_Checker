package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import com.northeastern.msd.team102.plagiarismchecker.repository.ReportRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Test Suite for Report Services
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ReportService.class, secure = false)
public class ReportServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportRepository reportRepository;

    @Autowired
    private ReportService reportService;

    @MockBean
    private UserService userService;

    @MockBean
    private FileUploadService fileUploadService;

    @MockBean
    private HomeworkService homeworkService;

//    @Test
//    public void createReport() throws Exception {
//        Report testReport = new Report();
//        ReportService reportService = mock(ReportService.class);
////        when(reportRepository.save(testReport)).thenReturn(testReport);
//        doNothing().when(reportService).createReport(testReport);
//        verify(reportService,times(1)).createReport(testReport);
////        given(this.reportService.createReport(testReport));
////        assertEquals(testReport,this.reportService.createReport(testReport));
//    }

//    @Test
//    public void generateReport() throws Exception {
//
//    }

    @Test
    public void findAllReportSummary() throws Exception {
        Report testReport = new Report();
        List<Report> testReportList=new ArrayList<>();
        when(reportRepository.findAllByHomeworkIdAndUser1Id(3,1)).thenReturn(testReportList);
        given(this.reportService.findAllReportSummary(3,1)).willReturn(testReportList);
        assertEquals(testReportList,this.reportService.findAllReportSummary(3,1));
    }

}
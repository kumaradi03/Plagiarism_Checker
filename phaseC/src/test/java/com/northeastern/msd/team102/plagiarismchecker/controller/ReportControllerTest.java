package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ReportController.class, secure = false)
public class ReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportService reportService;


    @Test
    public void findAllReportSummary() throws Exception{
        Report testReport = new Report(new User(), new User(), new FileUpload(), new FileUpload(), new Homework(), 10.00,12,12,12);
        List<Report> testReportList = new ArrayList<>();
        testReportList.add(testReport);
        String ExpectedOutput="[{\"id\":0,\"user1\":{\"id\":0,\"firstName\":null,\"lastName\":null,\"userType\":null,\"username\":null,\"password\":null,\"email\":null},\"user2\":{\"id\":0,\"firstName\":null,\"lastName\":null,\"userType\":null,\"username\":null,\"password\":null,\"email\":null},\"fileUpload1\":{\"id\":0,\"filename\":null,\"file\":null,\"mimeType\":null,\"homework\":null,\"user\":null},\"fileUpload2\":{\"id\":0,\"filename\":null,\"file\":null,\"mimeType\":null,\"homework\":null,\"user\":null},\"homework\":{\"id\":0,\"name\":null,\"description\":null,\"user\":null},\"percentageCompareHashMap\":10.0,\"percentageCompareTrees\":12.0,\"percentageCompareLevenshteinDistance\":12.0,\"percentageCompareAll\":12.0}]";
        Mockito.when(reportService.findAllReportSummary(3,1)).thenReturn(testReportList);
        MvcResult result;
        result=mockMvc.perform(MockMvcRequestBuilders.get("/rest/report/findAllReportSummary").param("userId","3")
                .param("hwId","1"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(ExpectedOutput, result.getResponse().getContentAsString());
    }
}
package com.northeastern.msd.team102.plagiarismchecker.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.FileUploadService;
import com.northeastern.msd.team102.plagiarismchecker.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RunWith(SpringRunner.class)
@WebMvcTest(value = FileController.class, secure = false)
public class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FileUploadService fileUploadService;

    @MockBean
    ReportService reportService;
    
    @Test
    public void getDistinctUsersForHw() throws Exception {
        String testHWId = "3";
        String ExpectedOutput="[]";
        User testUser =new User(3,"testFirst","testLast","student","testUser","testpassword","test@test.com","1234567");
        Set<User> set = new HashSet<>();
        set.add(testUser);
        List<FileUpload> fileUploadList = new ArrayList<>();
        Mockito.when(fileUploadService.findAllByHomeworkId(3)).thenReturn(fileUploadList);
        MvcResult result;
        result=mockMvc.perform(MockMvcRequestBuilders.get("/rest/file/getUser").param("shwId",testHWId))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(ExpectedOutput, result.getResponse().getContentAsString());
    }

    @Test
    public void uploadFile() throws Exception {
        FileUpload testFileUpload = new FileUpload();
        FileUpload testFileUpload2 = new FileUpload();
        MockMultipartFile firstFile = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
        Mockito.when(fileUploadService.uploadFile(testFileUpload,3,3)).thenReturn(testFileUpload2);
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/rest/file/upload")
                .file(firstFile)
                .param("sUserId", "4")
                .param("sHwId","5"))
                .andExpect(status().is(200));
    }
}

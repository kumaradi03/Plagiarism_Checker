package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.FileUpload;
import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.repository.FileUploadRepository;
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
import static org.mockito.Mockito.when;

/**
 * Test suite for File Upload Service Test
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = FileUploadService.class, secure = false)
public class FileUploadServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    FileUploadService fileUploadService;

    @MockBean
    private FileUploadRepository fileUploadRepository;

    @MockBean
    private HomeworkService homeworkService;

    @MockBean
    private UserService userService;


    @Test
    public void findByFilename() throws Exception {
        FileUpload testFileUpload = new FileUpload();
        testFileUpload.setFilename("testHomework");
        when(fileUploadService.findByFilename("testHomework")).thenReturn(testFileUpload);
        given(this.fileUploadService.findByFilename("testHomework")).willReturn(testFileUpload);
        assertEquals(testFileUpload,this.fileUploadService.findByFilename("testHomework"));
    }

    @Test
    public void uploadFile() throws Exception {
        FileUpload testFileUpload = new FileUpload();
        testFileUpload.setFilename("testHomework");
        testFileUpload.setId(3);
        when(fileUploadService.uploadFile(testFileUpload,3,1)).thenReturn(testFileUpload);
        given(this.fileUploadService.uploadFile(testFileUpload,3,1)).willReturn(testFileUpload);
        assertEquals(testFileUpload,this.fileUploadService.uploadFile(testFileUpload,3,1));
    }

    @Test
    public void findAllByHomeworkId() throws Exception {
        FileUpload testFileUpload = new FileUpload();
        List<FileUpload> testHomeWorkList = new ArrayList<>();
        testHomeWorkList.add(testFileUpload);
        when(fileUploadService.findAllByHomeworkId(3)).thenReturn(testHomeWorkList);
        given(this.fileUploadService.findAllByHomeworkId(3)).willReturn(testHomeWorkList);
        assertEquals(testHomeWorkList,this.fileUploadService.findAllByHomeworkId(3));
    }

    @Test
    public void findAllFileForOtherUser() throws Exception {
        FileUpload testFileUpload = new FileUpload();
        List<FileUpload> testHomeWorkList = new ArrayList<>();
        testHomeWorkList.add(testFileUpload);
        when(fileUploadService.findAllFileForOtherUser(3,1)).thenReturn(testHomeWorkList);
        given(this.fileUploadService.findAllFileForOtherUser(3,1)).willReturn(testHomeWorkList);
        assertEquals(testHomeWorkList,this.fileUploadService.findAllFileForOtherUser(3,1));
    }

}
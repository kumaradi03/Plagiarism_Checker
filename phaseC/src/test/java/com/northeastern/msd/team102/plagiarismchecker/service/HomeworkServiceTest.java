package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.repository.HomeworkRepository;
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
 * Test suite to test HomeWork Service
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = HomeworkService.class, secure = false)
public class HomeworkServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HomeworkService homeworkService;

    @MockBean
    private HomeworkRepository homeworkRepository;

    @MockBean
    private UserService userService;

    @Test
    public void createHomework() throws Exception {
        Homework testHomeWork = new Homework();
        when(homeworkRepository.save(testHomeWork)).thenReturn(testHomeWork);
        given(this.homeworkService.createHomework(testHomeWork,1)).willReturn(testHomeWork);
        assertEquals(testHomeWork,this.homeworkService.createHomework(testHomeWork,1));

    }

    @Test
    public void findAllByUserId() throws Exception {
        Homework testHomeWork = new Homework();
        List<Homework> homeworkList = new ArrayList<>();
        homeworkList.add(testHomeWork);
        when(homeworkRepository.save(testHomeWork)).thenReturn(testHomeWork);
        given(this.homeworkService.findAllByUserId(3)).willReturn(homeworkList);
        assertEquals(homeworkList,this.homeworkService.findAllByUserId(3));
    }

    @Test
    public void findById() throws Exception {
        Homework testHomeWork = new Homework();
        when(homeworkRepository.save(testHomeWork)).thenReturn(testHomeWork);
        given(this.homeworkService.findById(1)).willReturn(testHomeWork);
        assertEquals(testHomeWork,this.homeworkService.findById(1));
    }

}
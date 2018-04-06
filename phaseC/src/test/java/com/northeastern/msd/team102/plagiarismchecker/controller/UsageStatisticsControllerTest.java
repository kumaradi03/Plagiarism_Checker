package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.*;
import com.northeastern.msd.team102.plagiarismchecker.service.UsageStatisticsService;
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
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UsageStatisticsController.class, secure = false)
public class UsageStatisticsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsageStatisticsService usageStatisticsService;

    @Test
    public void findAllUsageStatisticsByProfessor() throws Exception{
        Date d = null;
        UsageStatistics u = new UsageStatistics(null, new User(), new User(), new Course(), new Homework(), 0, "HashMap");
        List<UsageStatistics> testUsageList = new ArrayList<>();
        testUsageList.add(u);
        String ExpectedOutput="[{\"id\":0,\"timestamp\":"+d+",\"professor\":" +
                "{\"id\":0,\"firstName\":null,\"lastName\":null,\"userType\":null,\"username\":null,\"password\":null," +
                "\"email\":null,\"statusFlag\":null},\"student\":{\"id\":0,\"firstName\":null,\"lastName\":null,\"userType\":null," +
                "\"username\":null,\"password\":null,\"email\":null,\"statusFlag\":null},\"course\":{\"id\":0,\"name\":null," +
                "\"description\":null,\"user\":null},\"homework\":{\"id\":0,\"name\":null,\"description\":null," +
                "\"user\":null,\"course\":null},\"compareCount\":0.0,\"algoType\":\"HashMap\"}]";
        Mockito.when(usageStatisticsService.findAllUsageStatisticsByProfessor(2)).thenReturn(testUsageList);
        MvcResult result;
        result=mockMvc.perform(MockMvcRequestBuilders.get("/rest/usagestatistics/findAllUsageStatisticsSummary")
                .param("userId","2"))
                .andExpect(status().isOk()).andReturn();
        assertEquals(ExpectedOutput, result.getResponse().getContentAsString());
    }
}

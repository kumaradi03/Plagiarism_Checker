package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.data.repository.init.ResourceReader.Type.JSON;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

//    @Test
//    public void login() throws Exception {
//        User mockUser = new User(1, "Aditya","Kumar","Student","adi", "adi","adidkool1@gmail.com","8573109310");
//        Mockito.when(
//                userService.findUserByCredentials(Mockito.any(User.class))).thenReturn(mockUser);
//        String testJson = "{\"id\":\"1\",\"firstName\":\"Aditya\",\"lastName\":\"Kumar\",\"userType\":\"Student\",\"username\":\"adi\",\"password\":\"adi\",\"email\":\"adidkool1@gmail.com\",\"phone\":\"8573109310\"}";
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
//                "/rest/user/login").accept(MediaType.APPLICATION_JSON).content(testJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        String expected = "{id:1,firstName:Aditya,lastName:Kumar,userType:Student,username:adi,password:adi,email:adidkool1@gmail.com,phone:'8573109310'}";
//        JSONAssert.assertEquals(expected, result.getResponse()
//                .getContentAsString(), false);
//    }
}